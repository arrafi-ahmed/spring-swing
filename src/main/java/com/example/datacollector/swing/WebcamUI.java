package com.example.datacollector.swing;

import com.github.sarxos.webcam.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class WebcamUI extends JFrame implements WebcamListener {
    Webcam webcam;
    WebcamPanel panel;
    BufferedImage image;
    JButton captureBtn = new JButton("Capture");
    JLabel capturedImg = new JLabel();
    GridBagConstraints gbc = new GridBagConstraints();
    Timer timer = new Timer();
    private final String imageName = LocalDateTime.now().toString() + ".jpeg";

    public WebcamUI() {
        setTitle("Capture Photo");
        setLayout(new GridBagLayout());
        setResizable(true);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(700, 600));
        capturedImg.setSize(new Dimension(640, 480));

        //webcam
        webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());

        //panel
        panel = new WebcamPanel(webcam);
        panel.setFPSDisplayed(true);
        panel.setMirrored(true);

        //capture action
        captureBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image = webcam.getImage();
                webcam.close();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 500;
        add(captureBtn, gbc);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(panel, gbc);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(capturedImg, gbc);

        webcam.addWebcamListener(this);
    }

    public String getImageName() {
        return this.imageName;
    }

    public void hidePanel() {
        this.capturedImg.setVisible(true);
        this.panel.setVisible(false);
    }

    public void showPanel() {
        this.capturedImg.setVisible(false);
        this.panel.setVisible(true);
    }

    public void showWebcamUI() {
        this.setVisible(true);
    }

    public void closeWebcamUI() {
        this.setVisible(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void webcamOpen(WebcamEvent webcamEvent) {
        showPanel();
    }

    public void webcamClosed(WebcamEvent webcamEvent) {
        try {
            hidePanel();
            capturedImg.setIcon(new ImageIcon(image));
            ImageIO.write(image, "JPEG", new File(imageName));

            //close window after 2 sec
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    closeWebcamUI();
                }
            }, 1000);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void webcamDisposed(WebcamEvent webcamEvent) {
    }

    public void webcamImageObtained(WebcamEvent webcamEvent) {
    }
}