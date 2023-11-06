package com.vukhoa23.app.UI;

import com.vukhoa23.app.entity.SlangWordManager;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;

public class AppFrame extends JFrame {
    private final SlangWordManager manager = new SlangWordManager();
    private static final JPanel main = new JPanel();

    public class LeftNavBar extends JPanel {
        public LeftNavBar() throws FileNotFoundException {
            this.setLayout(new FlowLayout(0, 0, 20));
            this.setBackground(Color.gray);
            this.setPreferredSize(new Dimension(200, 500));

            JButton findBySlangBtn = new JButton("Find by Slang");
            findBySlangBtn.setBackground(Color.green);
            findBySlangBtn.setPreferredSize(new Dimension(200, 50));
            findBySlangBtn.addActionListener((e) -> {
                main.removeAll();
                main.add(new FindBySlang(manager));
                main.revalidate();
                main.repaint();
            });
            this.add(findBySlangBtn);

            JButton viewHistory = new JButton("View history");
            viewHistory.setBackground(Color.green);
            viewHistory.setPreferredSize(new Dimension(200, 50));
            viewHistory.addActionListener((e) -> {
                main.removeAll();
                main.add(new ViewHistory(manager));
                main.revalidate();
                main.repaint();
            });
            this.add(viewHistory);

            JButton findByDefinitionBtn = new JButton("Find by Definition");
            findByDefinitionBtn.setBackground(Color.green);
            findByDefinitionBtn.setPreferredSize(new Dimension(200, 50));
            findByDefinitionBtn.addActionListener((e) -> {
                main.removeAll();
                main.add(new FindByDefinition(manager));
                main.revalidate();
                main.repaint();
            });
            this.add(findByDefinitionBtn);


        }
    }

    public AppFrame() throws FileNotFoundException {
        super("Slang Words");
        main.setBackground(Color.darkGray);
        main.setLayout(null);
        main.setPreferredSize(new Dimension(500, 500));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());


        manager.readSlangWordsFromFile("slang.txt");
        Header header = new Header();
        LeftNavBar leftNavBar = new LeftNavBar();
        Footer footer = new Footer();
        this.add(leftNavBar, BorderLayout.WEST);
        this.add(header, BorderLayout.NORTH);
        this.add(footer, BorderLayout.SOUTH);
        this.add(main, BorderLayout.CENTER);

        this.setVisible(true);
        this.pack();
    }

}
