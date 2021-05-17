/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.timer.service.impl.withdelegation;

import java.beans.PropertyChangeSupport;
import java.time.LocalTime;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;


/**
 *
 * @author islem
 */
public class TimerServiceImplWithDelegation  extends TimerTask
        implements TimerService {

    int dixiemeDeSeconde;
    int minutes;
    int secondes;
    int heures;

    /**
     * Constructeur du TimerServiceImpleWithDelegation Ici, nnous avons hérité de la classe
     * TimerTask, et nous nous avons utilisé un objet Timer, qui permet de
     * réaliser des tocs à chaque N millisecondes
     */
    
    public TimerServiceImplWithDelegation() {
        Timer timer = new Timer();

        LocalTime localTime = LocalTime.now();

        secondes = localTime.getSecond();
        minutes = localTime.getMinute();
        heures = localTime.getHour();
        dixiemeDeSeconde = localTime.getNano() / 100000000;

        timer.scheduleAtFixedRate(this, 100, 100);
    }

    @Override
    public void run() {
        timeChanged();
    }

    PropertyChangeSupport PCS = new PropertyChangeSupport(this);
    
    @Override
    public void addTimeChangeListener(TimerChangeListener pl) {
        //listeners.add(pl);
        PCS.addPropertyChangeListener(pl);
    }

    @Override
    public void removeTimeChangeListener(TimerChangeListener pl) {
        //listeners.remove(pl);
        PCS.removePropertyChangeListener(pl);
    }
    
    

    @Override
    public int getMinutes() {
        return minutes;
    }

    @Override
    public int getHeures() {
        return heures;
    }

    @Override
    public int getSecondes() {
        return secondes;
    }

    @Override
    public int getDixiemeDeSeconde() {
        return dixiemeDeSeconde;
    }

    private void timeChanged() {
        updateDixiemeDeSecode();
    }

    protected void updateDixiemeDeSecode() {
        int oldValue = dixiemeDeSeconde;
        dixiemeDeSeconde = (dixiemeDeSeconde + 1) % 10;

        // informer les listeners ! 
      /*  for (TimerChangeListener l : listeners) {
            l.propertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP,
                    oldValue, dixiemeDeSeconde);
        }*/
        PCS.firePropertyChange(TimerChangeListener.DIXEME_DE_SECONDE_PROP, oldValue,dixiemeDeSeconde);

        if (dixiemeDeSeconde == 0) {
            updateSecode();
        }
    }

    protected void updateSecode() {
        int oldValue = secondes;
        secondes = (secondes + 1) % 60;

      /*  for (TimerChangeListener l : listeners) {
            l.propertyChange(TimerChangeListener.SECONDE_PROP,
                    oldValue, secondes);
        }*/
    PCS.firePropertyChange(TimerChangeListener.SECONDE_PROP, oldValue,secondes);


        if (secondes == 0) {
            updateMinutes();
        }
    }

    protected void updateMinutes() {
        int oldValue = minutes;
        minutes = (minutes + 1) % 60;

 /*       for (TimerChangeListener l : listeners) {
            l.propertyChange(TimerChangeListener.MINUTE_PROP,
                    oldValue, minutes);
        }
*/
     PCS.firePropertyChange(TimerChangeListener.MINUTE_PROP, oldValue,minutes);

        if (minutes == 0) {
            updateHeures();
        }
    }

    protected void updateHeures() {
        int oldValue = heures;
        heures = (heures + 1) % 24;

        /*for (TimerChangeListener l : listeners) {
            l.propertyChange(TimerChangeListener.HEURE_PROP,
                    oldValue, heures);
        }*/
       PCS.firePropertyChange(TimerChangeListener.HEURE_PROP, oldValue,heures);

    }

}

