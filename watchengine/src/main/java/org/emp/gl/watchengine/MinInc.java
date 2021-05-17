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
public class MinInc extends State {

    public MinInc( WatchEngine e) {
        super(e);
    }

    

    @Override
    public void doConfigue() {
        engine.changeState(new Init(engine));
    }

    @Override
    public void doMode() {
        engine.stopWatch();
        engine.changeState(new SecondInc(engine));
    }

    @Override
    public void doIncrement() {
        engine.incremntMin();
    }
    
}
