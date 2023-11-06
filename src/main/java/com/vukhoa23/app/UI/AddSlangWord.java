package com.vukhoa23.app.UI;

import com.vukhoa23.app.entity.SlangWordManager;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class AddSlangWord extends JPanel {
    public AddSlangWord(SlangWordManager manager) {
        this.setBounds(0,0,500,500);
        this.setPreferredSize(new Dimension(500, 500 ));
        this.setBackground(Color.darkGray);


        this.setLayout(new BorderLayout());

        JPanel slangInputContainer = new JPanel();
        slangInputContainer.setLayout(new FlowLayout());

        JLabel slangLabel = new JLabel("Input slang name");

        JTextField slangInput = new JTextField();
        slangInput.setPreferredSize(new Dimension(300, 50));
        slangInput.setHorizontalAlignment(JTextField.CENTER);

        JPanel definitionInputContainer = new JPanel();
        definitionInputContainer.setLayout(new FlowLayout());

        JLabel definitionLabel = new JLabel("Input Definition");

        JTextField definitionInput = new JTextField();
        definitionInput.setPreferredSize(new Dimension(300, 50));
        definitionInput.setHorizontalAlignment(JTextField.CENTER);

        JButton createBtn = new JButton("Create");
        createBtn.setPreferredSize(new Dimension(100, 50));

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        createBtn.addActionListener((e)->{
            String slang = slangInput.getText();
            String definition = definitionInput.getText();

            HashMap<String, String> result = manager.findBySlangWord(slang);
            if (result != null) {
                int rewrite = JOptionPane.showConfirmDialog(this,"Slang exists. Rewrite?", "Rewrite",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                // 0 is yes
                if (rewrite == 0) {
                    manager.addToWords(slang, definition);
                    JOptionPane.showMessageDialog(this, "Slang rewrited", "Notify", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(this, "Slang was not saved", "Notify", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                manager.addToWords(slang, definition);
                JOptionPane.showMessageDialog(this, "Slang added successfully", "Notify", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        slangInputContainer.add(slangLabel);
        slangInputContainer.add(slangInput);

        definitionInputContainer.add(definitionLabel);
        definitionInputContainer.add(definitionInput);
        this.add(main, BorderLayout.CENTER);

        JPanel inputContainer = new JPanel();
        inputContainer.setLayout(new FlowLayout());
        inputContainer.setPreferredSize(new Dimension(300, 100));
        inputContainer.add(slangInputContainer, BorderLayout.NORTH);
        inputContainer.add(definitionInputContainer, BorderLayout.NORTH);
        inputContainer.add(createBtn);
        this.add(inputContainer);
    }
}
