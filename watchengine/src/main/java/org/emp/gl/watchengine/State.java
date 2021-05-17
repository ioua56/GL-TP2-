package org.emp.gl.watchengine;


/**
 * Hello world!
 *
 */
public abstract class  State 
{   
        
    public static  WatchEngine engine; 
   
    public State(WatchEngine e){
        engine=e;
    }
    
    public abstract void doConfigue();
    
    public abstract void doMode();
    
    public abstract void doIncrement();
        
}
