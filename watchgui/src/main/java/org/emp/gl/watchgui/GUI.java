package org.emp.gl.watchgui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.emp.gl.core.lookup.Lookup;
import org.emp.gl.core.service.impl.gui.GuiService;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

/**
 * Hello world!
 *
 */
public class GUI implements TimerChangeListener {

    JFrame frame = new JFrame();
    TimerService ts = Lookup.getInstance().getService(TimerService.class);

    int heurs = ts.getHeures();
    int min = ts.getMinutes();
    int seconds = ts.getSecondes();
    int dixiem = ts.getDixiemeDeSeconde();

    public JLabel timeLabel = new JLabel();

    public GUI() {

        frame.setLayout(new BorderLayout());
        frame.setContentPane(new JLabel(new ImageIcon("darkBlue.jpg")));
        frame.setLayout(null);
        
        timeLabel.setBounds(120, 100, 200, 100);
        timeLabel.setForeground(Color.GREEN);
       
        
        timeLabel.setOpaque(false);
        timeLabel.setVisible(true);

        frame.add(timeLabel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setVisible(true);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        switch (evt.getPropertyName()) {
            case TimerChangeListener.DIXEME_DE_SECONDE_PROP:
                dixiem = ts.getDixiemeDeSeconde();
                break;
            case TimerChangeListener.HEURE_PROP:
                heurs = ts.getHeures();
                break;
            case TimerChangeListener.MINUTE_PROP:
                min = ts.getMinutes();
                break;
            case TimerChangeListener.SECONDE_PROP:
                seconds = ts.getSecondes();
                break;

            default:
                break;

        }
        updateTime();
    }

    public void updateTime() {
        timeLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        timeLabel.setText("<html>"+"<div style='text-align: center;'>" + "" + heurs + ":" + min + ":"
                + seconds + ":" + dixiem + "</div>"+"</html>");
    
    }
    

    @Override
    public void propertyChange(String propertyName, Object oldValue, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
