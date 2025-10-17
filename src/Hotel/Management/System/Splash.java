package Hotel.Management.System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {
    Splash(){
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/LOGINN1.jpg"));

        // Scale the image to match the window size
        Image image = imageIcon.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(image);

        // Add image to JLabel
        JLabel label = new JLabel(scaledIcon);
        label.setBounds(0, 0, 900, 600);
        add(label);

        setUndecorated(true);
        setLayout(null);
        setLocation(300,80);
        setSize(900,600);
        setVisible(true);

        try{
            Thread.sleep(5000);
            new Login();
            setVisible(false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
