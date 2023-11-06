package com.vukhoa23.UI;

import com.vukhoa23.entity.SlangWordManager;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class AppFrame extends JFrame {
    private final SlangWordManager manager = new SlangWordManager();


    public AppFrame() throws FileNotFoundException {
        super("Slang Words");

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        manager.readSlangWordsFromFile("slang.txt");
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.pack();
    }

}
