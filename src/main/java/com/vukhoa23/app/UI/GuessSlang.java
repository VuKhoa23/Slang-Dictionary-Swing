package com.vukhoa23.app.UI;

import com.vukhoa23.app.entity.SlangWordManager;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Random;

public class GuessSlang extends JPanel {
    public GuessSlang(SlangWordManager manager) {
        this.setBounds(0, 0, 500, 500);
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.darkGray);


        this.setLayout(new BorderLayout());

        HashMap<String, String> randomSlangs = manager.getFourRandomSlang();
        Random generator = new Random();
        Object[] keys = randomSlangs.keySet().toArray();
        Object randomKey = keys[generator.nextInt(keys.length)];
        String answer = (String) randomKey;
        String randomValue = (String) manager.getWords().get(answer);

        Object[] options = randomSlangs.keySet().toArray();

        // print options
        JRadioButton option1 = new JRadioButton((String) options[0]);
        JRadioButton option2 = new JRadioButton((String) options[1]);
        JRadioButton option3 = new JRadioButton((String) options[2]);
        JRadioButton option4 = new JRadioButton((String) options[3]);
        option1.setFont(new Font("SansSerif", Font.BOLD, 15));
        option2.setFont(new Font("SansSerif", Font.BOLD, 15));
        option3.setFont(new Font("SansSerif", Font.BOLD, 15));
        option4.setFont(new Font("SansSerif", Font.BOLD, 15));

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(option1);
        buttonGroup.add(option2);
        buttonGroup.add(option3);
        buttonGroup.add(option4);

        JPanel optionsContainer = new JPanel();
        optionsContainer.setLayout(null);
        option1.setBounds(0, 0, 400, 40);
        option2.setBounds(0, 40, 400, 40);
        option3.setBounds(0, 80, 400, 40);
        option4.setBounds(0, 120, 400, 40);
        optionsContainer.add(option1);
        optionsContainer.add(option2);
        optionsContainer.add(option3);
        optionsContainer.add(option4);

        JButton submitBtn = new JButton("SUBMIT");
        submitBtn.setPreferredSize(new Dimension(100, 50));
        optionsContainer.add(submitBtn);
        submitBtn.setBounds(150, 170, 100, 80);


        JLabel label = new JLabel("Guess slang word base on the definition below: ");
        label.setFont(new Font("SansSerif", Font.BOLD, 15));
        label.setForeground(Color.white);
        label.setBackground(Color.darkGray);
        label.setOpaque(true);
        label.setBounds(0, 0, 500, 30);


        JLabel definition = new JLabel(randomValue);
        definition.setFont(new Font("SansSerif", Font.BOLD, 15));
        definition.setForeground(Color.darkGray);
        definition.setBounds(0, 50, 400, 30);

        optionsContainer.setBounds(0, 90, 400, 300);


        JPanel quizContainer = new JPanel();
        quizContainer.setLayout(null);
        quizContainer.add(label);
        quizContainer.add(definition);
        quizContainer.add(optionsContainer);

        // handle after choose
        this.add(quizContainer, BorderLayout.CENTER);

        submitBtn.addActionListener((e) -> {
            if (option1.isSelected()) {
                if (answer.equals((String) options[0])) {
                    JOptionPane.showMessageDialog(this, "YOU WIN !", "Notify", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "BETTER LUCK NEXT TIME !", "Notify", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (option2.isSelected()) {
                if (answer.equals((String) options[1])) {
                    JOptionPane.showMessageDialog(this, "YOU WIN !", "Notify", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "BETTER LUCK NEXT TIME !", "Notify", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (option3.isSelected()) {
                if (answer.equals((String) options[2])) {
                    JOptionPane.showMessageDialog(this, "YOU WIN !", "Notify", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "BETTER LUCK NEXT TIME !", "Notify", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (option4.isSelected()) {
                if (answer.equals((String) options[3])) {
                    JOptionPane.showMessageDialog(this, "YOU WIN !", "Notify", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "BETTER LUCK NEXT TIME !", "Notify", JOptionPane.INFORMATION_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please choose an answer !", "Notify", JOptionPane.ERROR_MESSAGE);

            }
        });
    }
}
