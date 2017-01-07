/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ie.gmit.sw;

/**
 *
 * @author eamon
 */
public class Metric {
    private int outDegrees;
    private int inDegrees;
    private String className;
    
    public double getStability(){
         double stability = 0.0;
         
         double ind = (double) getInDegrees();
         double outd = (double) getOutDegrees();
         
         if(outd > 0){
             stability = outd / (ind + outd);
         }
         
         return stability;
    }
    
    public int getOutDegrees(){
        return outDegrees;
    }
    
    public void increaseOutDegrees(){
        this.outDegrees++;
    }
    
    public int getInDegrees(){
        return inDegrees;
    }
    
    public void increaseInDegrees(){
        this.inDegrees++;
    }
    
    public String getClassName(){
        return className;
    }
    
    public void setClassName(String className){
        this.className = className;
    }
}
