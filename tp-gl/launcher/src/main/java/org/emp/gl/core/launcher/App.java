package org.emp.gl.core.launcher;

import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import org.emp.gl.timer.service.impl.withdelegation.TimerServiceImplWithDelegation;
import org.emp.gl.watchengine.WatchEngine;
import org.emp.gl.watchaction.WatchActions;
import org.emp.gl.watchgui.ButtonController;
import org.emp.gl.watchgui.GUI;

/**
 * Hello world!
 *
 */
public class App {
    
    // ce code nous permettra d'enregistrer les service que notre application utilsiera 
    // lors de l'execution
    static {
        Lookup.getInstance().register(TimerService.class, WatchEngine.getInstance());
        Lookup.getInstance().register(WatchActions.class, WatchEngine.getInstance());
        Lookup.getInstance().register(ButtonController.class, new ButtonController());
               
    }

    public static void main(String[] args) {
        testDuTimeService();
    }

    private static void testDuTimeService() {

        TimerService ts = Lookup.getInstance().getService(TimerService.class);

        ts.addTimeChangeListener(new GUI());
        /*for(int i=0;i<20;i++){

           int countdown_from=5 + (int)(Math.random() * 10);
          ts.addTimeChangeListener(new CompteARebour(countdown_from));
       }*/

    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
