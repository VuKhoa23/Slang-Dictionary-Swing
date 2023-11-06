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

            JButton addNewSlangWord = new JButton("Add new Slang Word");
            addNewSlangWord.setBackground(Color.green);
            addNewSlangWord.setPreferredSize(new Dimension(200, 50));
            addNewSlangWord.addActionListener((e) -> {
                main.removeAll();
                main.add(new AddSlangWord(manager));
                main.revalidate();
                main.repaint();
            });
            this.add(addNewSlangWord);

            JButton editSlangWord = new JButton("Edit Slang Word");
            editSlangWord.setBackground(Color.green);
            editSlangWord.setPreferredSize(new Dimension(200, 50));
            editSlangWord.addActionListener((e) -> {
                main.removeAll();
                main.add(new EditSlangWord(manager));
                main.revalidate();
                main.repaint();
            });
            this.add(editSlangWord);

            JButton deleteSlangWord = new JButton("Delete Slang Word");
            deleteSlangWord.setBackground(Color.green);
            deleteSlangWord.setPreferredSize(new Dimension(200, 50));
            deleteSlangWord.addActionListener((e) -> {
                main.removeAll();
                main.add(new DeleteSlangWord(manager));
                main.revalidate();
                main.repaint();
            });
            this.add(deleteSlangWord);

            JButton resetSlangWord = new JButton("Reset Slang Word");
            resetSlangWord.setBackground(Color.green);
            resetSlangWord.setPreferredSize(new Dimension(200, 50));
            resetSlangWord.addActionListener((e) -> {
                main.removeAll();
                try {
                    manager.readSlangWordsFromFile("slang.txt");
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
                JOptionPane.showMessageDialog(this.getParent(), "Data reset successfully !", "Notify", JOptionPane.INFORMATION_MESSAGE);
                main.revalidate();
                main.repaint();
            });
            this.add(resetSlangWord);
        }
    }

    public class RightNavBar extends JPanel {
        public RightNavBar() {
            this.setLayout(new FlowLayout(0, 0, 50));
            this.setBackground(Color.gray);
            this.setPreferredSize(new Dimension(200, 500));

            JButton guessDefinition = new JButton("Guess definition");
            guessDefinition.setBackground(Color.green);
            guessDefinition.setPreferredSize(new Dimension(200, 50));
            guessDefinition.addActionListener((e) -> {
                main.removeAll();
                main.add(new GuessDefinition(manager));
                main.revalidate();
                main.repaint();
            });
            this.add(guessDefinition);

            JButton guessSlang = new JButton("Guess Slang Word");
            guessSlang.setBackground(Color.green);
            guessSlang.setPreferredSize(new Dimension(200, 50));
            guessSlang.addActionListener((e) -> {
                main.removeAll();
                main.add(new GuessSlang(manager));
                main.revalidate();
                main.repaint();
            });
            this.add(guessSlang);
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
        RightNavBar rightNavBar = new RightNavBar();
        Footer footer = new Footer();
        this.add(header, BorderLayout.NORTH);
        this.add(leftNavBar, BorderLayout.WEST);
        this.add(main, BorderLayout.CENTER);
        this.add(rightNavBar, BorderLayout.EAST);
        this.add(footer, BorderLayout.SOUTH);

        this.setVisible(true);
        this.pack();
    }

}
