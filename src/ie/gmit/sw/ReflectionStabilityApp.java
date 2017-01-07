/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gmit.sw;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 *
 * @author eamon
 */
public class ReflectionStabilityApp {
    public static Map<String, Metric> classMap = new HashMap<>();
    
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, InterruptedException {
       
        initMap();
        
        for(String className : classMap.keySet()){
            calculateStability(className);
        }
        
        for(String className : classMap.keySet()){
            File jarFile = new File("/home/eamon/Desktop/example1.jar");
            try
            {
                URL fileURL = jarFile.toURI().toURL();
                String jarURL = "jar:" + fileURL + "!/";
                URL urls [] = { new URL(jarURL) };
                URLClassLoader ucl = new URLClassLoader(urls);
                Class cls = (Class) Class.forName(className, true,   ucl);
                
                System.out.println(classMap.get(cls.getName()).getStability());
            } catch(MalformedURLException | ClassNotFoundException e){}
        }
    }
       

    private static void initMap() {
        try{
            JarInputStream in = new JarInputStream(new FileInputStream(new File("/home/eamon/Desktop/example1.jar")));
            JarEntry next = in.getNextJarEntry();
            while (next != null) {
                if (next.getName().endsWith(".class")) {
                String name = next.getName().replaceAll("/", "\\.");
                name = name.replaceAll(".class", "");
                if (!name.contains("$")) name.substring(0, name.length() - ".class".length());
                    System.out.println(name);
                    classMap.put(name, new Metric());
                }
                next = in.getNextJarEntry();
            } 
        }catch(IOException e){}
    }

    private static void calculateStability(String className) {
        
        // adapated from https://coderanch.com/t/383279/java/dynamically-loading-class-file-jar post# 2
        File jarFile = new File("/home/eamon/Desktop/example1.jar");
	try
	{
            URL fileURL = jarFile.toURI().toURL();
            String jarURL = "jar:" + fileURL + "!/";
      	    URL urls [] = { new URL(jarURL) };
	    URLClassLoader ucl = new URLClassLoader(urls);
       	    Class cls = (Class) Class.forName(className, true,   ucl);
            
           
            // loop code adapted from https://www.javacodegeeks.com/2014/11/java-reflection-api-tutorial.html
            // loop through the interfaces
            Class[] interfaces = cls.getInterfaces();
            
            for(Class inf : interfaces){
                
                if(classMap.containsKey(inf.getName())){
                    
                    // increase the outdegrees for this class
                    classMap.get(cls.getName()).increaseOutDegrees();
                    
                    // increase the in degrees for interface class in the map
                    classMap.get(inf.getName()).increaseInDegrees();
                    }
            }   
                
            // loop through constructor params
            Constructor[] cons = cls.getConstructors();
            Class[] conParams;

            for(Constructor con: cons){ // for each constructor
                conParams = con.getParameterTypes(); // get the params
                for(Class conParam : conParams){ 
                    if(classMap.containsKey(conParam.getName())){
                         
                        // increase the outdegrees for this class
                        classMap.get(cls.getName()).increaseOutDegrees();

                        // increase the indegrees for the class type of the parameter in the classMap
                        classMap.get(conParam.getName()).increaseInDegrees();
                    }
                }
            }   

            // loop through the classes fields
            Field[] fields = cls.getFields();
            for(Field field : fields){
                if(classMap.containsKey(field.getName())){
                    // increase the outdegrees for this class
                    classMap.get(cls.getName()).increaseOutDegrees();

                    // increase the indegrees for the field class in the class map
                    classMap.get(field.getName()).increaseInDegrees();
                }
            }

            // loop through method params and return types
            Method[] methods = cls.getMethods();
            Class[] methodParams;

            for(Method method : methods){
                methodParams = method.getParameterTypes();

                for(Class methodParam : methodParams){
                    if(classMap.containsKey(methodParam.getName())){
                        // increase out degrees for this class
                        classMap.get(cls.getName()).increaseOutDegrees();

                        // increase in degrres for the method param class
                        classMap.get(methodParam.getName()).increaseInDegrees();
                    }
                }
                 // get the method return type
                Class mrt = method.getReturnType();
                if(classMap.containsKey(mrt.getName())){
                    // increase the outdegrees for this class
                    classMap.get(cls.getName()).increaseOutDegrees();
                    // increase the in degrees for the return type class
                    classMap.get(mrt.getName()).increaseInDegrees();
                }
            }
            
    
	} catch(MalformedURLException | ClassNotFoundException e){}
    }

   
    
}
