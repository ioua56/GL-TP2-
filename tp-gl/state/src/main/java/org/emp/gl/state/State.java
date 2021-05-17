package org.emp.gl.state;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.core.service.impl.gui.GuiService;
import org.emp.gl.watchengine.WatchEngine;

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
