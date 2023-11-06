package com.vukhoa23.app.UI;

import com.vukhoa23.app.entity.SlangWordManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class OnThisDaySlang extends JPanel {
    public OnThisDaySlang(SlangWordManager manager) {
        this.setBounds(0, 0, 500, 500);
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.darkGray);


        this.setLayout(new BorderLayout());

        String randomSlang = manager.getRandomSlang();
        String randomDefinition = manager.getDefinitionBySlang(randomSlang);

        JPanel main = new JPanel();
        main.setLayout(null);

        JLabel slang = new JLabel(randomSlang);
        slang.setFont(new Font("SansSerif", Font.BOLD, 30));
        slang.setForeground(Color.darkGray);
        slang.setBounds(0,50,500, 50);
        slang.setHorizontalAlignment(JLabel.CENTER);

        JLabel definition = new JLabel(randomDefinition);
        definition.setFont(new Font("SansSerif", Font.BOLD, 15));
        definition.setForeground(Color.black);
        definition.setBounds(0,110,500, 50);
        definition.setHorizontalAlignment(JLabel.CENTER);


        main.add(slang);
        main.add(definition);
        this.add(main, BorderLayout.CENTER);
    }
}
