package com.example.datacollector.swing;

import javax.swing.*;

public class DialogUI extends JFrame{
    public DialogUI(){
        JLabel text = new JLabel("Some information");
        text.setHorizontalAlignment(JLabel.CENTER);
        add(text);
        setVisible(true);
        setSize(200,100);
    }
}