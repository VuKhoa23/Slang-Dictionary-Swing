package com.vukhoa23.UI;


import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {
    public Footer(){
        this.setPreferredSize(new Dimension(800, 100));
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("21127631 - Vu Anh Khoa");
        label.setFont(new Font("SansSerif",Font.BOLD, 20));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        this.add(label);
    }

}
