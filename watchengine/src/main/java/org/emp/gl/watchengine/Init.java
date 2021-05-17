/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.watchengine;


/**
 *
 * @author islem
 */
public class Init extends State {

    public Init(WatchEngine e) {
        super(e);
    }

    @Override
    public void doConfigue() {
        engine.changeState(new HourInc(engine));
    }

    @Override
    public void doMode() {
        System.out.println("doMODE : INIT STATE");
       // engine.changeState(new HourInc(engine));
    }

    @Override
    public void doIncrement() {
        System.out.println("doINCRMEMNT : INIT STATE");
        // System.out.println("you are in Init state do nothing ");
    }

}
