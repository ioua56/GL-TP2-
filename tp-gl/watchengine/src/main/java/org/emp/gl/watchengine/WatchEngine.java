package org.emp.gl.watchengine;

import java.util.List;
import org.emp.gl.timer.service.impl.withdelegation.TimerServiceImplWithDelegation;
import org.emp.gl.watchaction.WatchActions;
import org.emp.gl.state.State;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.states.Init;

/**
 * Hello world!
 *
 */
public class WatchEngine extends TimerServiceImplWithDelegation implements WatchActions
       
{
    //a singltone pattern
    private static WatchEngine Instance = null;
    private WatchEngine(){};
    public static WatchEngine getInstance(){
        if(Instance==null)
            Instance = new WatchEngine();
        return Instance;
    }

    // I can do this to change the current state of the watch
    //State state = Lookup.getInstance().getService(State.class);
    State state= new Init(this);
    
    //OR I can do this to change the current state of the watch
    public void changeState(State newState){
        state= newState;
    }
    
    @Override
    public void doConfigue() {
            state.doConfigue();               
    }

    @Override
    public void doMode() {
            System.out.println("doMODE : Watch ENGINE");
            state.doMode();
    }

    @Override
    public void doIncrement() {
            System.out.println("doINCRMENT : Watch ENGINE");
            state.doIncrement();
    }
    
    public void incremtnHour(){
        this.updateHeures();
    }
    public void incremntMin(){
        this.updateMinutes();
    }
    public void incrmentSecond(){
        this.updateSecode();
    }
    public void incrementDixiem(){
        this.updateDixiemeDeSecode();
    }

    public void stopWatch() {
    }

    public void startWatch() {   
    }
    
    
    
}
