/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package naumaxia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class WelcomeFrame extends JFrame {

    private JLabel label;
    private JButton button;
    private JTextField text;
    private JFrame selfFrame;

    public WelcomeFrame() {

        this.setTitle("Battleship - Player's Details");
        this.setSize(300, 150);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);

        label = new JLabel();
        button = new JButton();
        text = new JTextField();
        selfFrame = this;

        label.setText("Please insert your name and press 'OK'");
        label.setSize(240, 18);
        label.setLocation(30, 10);
        this.add(label);

        button.setText("OK");
        button.setSize(60, 20);
        button.setLocation(120, 85);
        this.add(button);

        text.setSize(150, 20);
        text.setLocation(75, 47);
        this.add(text);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerBoard fra = new PlayerBoard(text.getText());
                fra.setVisible(true);
                selfFrame.setVisible(false);
            }
        });


    }
}
