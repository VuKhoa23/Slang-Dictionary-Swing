package com.vukhoa23.UI;


import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {
    public Header(){
        this.setPreferredSize(new Dimension(800, 100));
        this.setBackground(Color.black);
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("SLANG WORD DICTIONARY");
        label.setFont(new Font("SansSerif",Font.BOLD, 30));
        label.setForeground(Color.white);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        this.add(label);
    }
}
