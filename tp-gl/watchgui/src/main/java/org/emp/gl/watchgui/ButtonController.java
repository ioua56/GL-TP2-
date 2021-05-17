/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.emp.gl.watchgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.watchaction.WatchActions;

/**
 *
 * @author islem
 */
public class ButtonController implements ActionListener {

    JButton Mode = new JButton("Mode");
    JButton Incrment = new JButton("Incrment");
    JButton Configue = new JButton("Configue");
    JFrame frame = new JFrame();

    public ButtonController() {
        
        frame.setLayout(new BorderLayout());
        frame.setContentPane(new JLabel(new ImageIcon("lightBlue.jpg")));
        frame.setLayout(new FlowLayout());
        
        
        Mode.setBounds(40, 40, 100, 50);
        Mode.setFont(new Font("Ink Free", Font.PLAIN, 10));
        Mode.setFocusable(false);
        Mode.addActionListener(this);

        Incrment.setBounds(160, 40, 100, 50);
        Incrment.setFont(new Font("Ink Free", Font.PLAIN, 10));
        Incrment.setFocusable(false);
        Incrment.addActionListener(this);

        Configue.setBounds(280, 40, 100, 50);
        Configue.setFont(new Font("Ink Free", Font.PLAIN, 10));
        Configue.setFocusable(false);
        Configue.addActionListener(this);

        frame.add(Mode);
        frame.add(Incrment);
        frame.add(Configue);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 200);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        WatchActions action = Lookup.getInstance().getService(WatchActions.class);
        if (e.getSource() == Mode) {
            System.out.println("MODE : BUTTON CONTROOLER");
            action.doMode();
        }

        if (e.getSource() == Incrment) {
            System.out.println("INCREMENT : BUTTON CONTROOLER");
            action.doIncrement();
        }
        if(e.getSource()== Configue){
            System.out.println("Configue : Configue Button");
            action.doConfigue();       
        }
    }

}
