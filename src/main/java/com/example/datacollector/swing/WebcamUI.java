package com.example.datacollector.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WebcamUI extends JFrame {
    JLabel title;
    JTextField field1,field2;
    JButton addBtn;
    JLabel result,resultValue;

    public WebcamUI(){
         title = new JLabel("Add 2 integer:");
         field1 = new JTextField(5);
         field2 = new JTextField(5);
         addBtn = new JButton("Add");
         result = new JLabel("Result:");
         resultValue = new JLabel("");

        addBtn.addActionListener(ev -> {
                int num1 = Integer.parseInt(field1.getText());
                int num2 = Integer.parseInt(field2.getText());
                resultValue.setText(num1+num2+"");
            }
        );

        add(title);
        add(field1);
        add(field2);
        add(addBtn);
        add(result);
        add(resultValue);
        setLayout(new FlowLayout());
        setSize(250,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showWebcamUI(){
        this.setVisible(true);
    }
    public void closeWebcamUI(){
        this.setVisible(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}