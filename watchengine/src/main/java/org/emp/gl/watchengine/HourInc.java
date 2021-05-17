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
public class HourInc extends State {

    public HourInc(WatchEngine e) {
        super(e);
    }

    @Override
    public void doConfigue() {
        engine.changeState(new Init(engine));
    }

    @Override
    public void doMode() {
        System.out.println("doMODE : HOUR Incremnt State");
        engine.stopWatch();
        engine.changeState(new MinInc(engine));
    }

    @Override
    public void doIncrement() {
        System.out.println("doIncrment : Hour Incremnt STATE");
        engine.incremtnHour();
    }

}
