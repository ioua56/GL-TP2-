/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.states;

import org.emp.gl.state.State;
import org.emp.gl.watchengine.WatchEngine;

/**
 *
 * @author islem
 */
public class SecondInc extends State {

    public SecondInc(WatchEngine e) {
        super(e);
    }

    @Override
    public void doConfigue() {
        engine.startWatch();
        engine.changeState(new Init(engine));
    }

    @Override
    public void doMode() {
        engine.changeState(new HourInc(engine));
    }

    @Override
    public void doIncrement() {
        engine.incrmentSecond();
    }

}
