package com.vukhoa23.app.UI;

import com.vukhoa23.app.entity.SlangWordManager;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class DeleteSlangWord extends JPanel {
    public DeleteSlangWord(SlangWordManager manager) {
        this.setBounds(0, 0, 500, 500);
        this.setPreferredSize(new Dimension(500, 500));
        this.setBackground(Color.darkGray);


        this.setLayout(new BorderLayout());

        JPanel inputContainer = new JPanel();
        inputContainer.setLayout(new FlowLayout());
        inputContainer.setPreferredSize(new Dimension(500, 100));

        JLabel inputLabel = new JLabel("Input the slang word you want to delete");
        inputLabel.setFont(new Font("SansSerif",Font.PLAIN, 15));
        inputLabel.setPreferredSize(new Dimension(500, 20));
        inputLabel.setHorizontalAlignment(JLabel.CENTER);

        JTextField slangInput = new JTextField();
        slangInput.setPreferredSize(new Dimension(200, 50));
        slangInput.setHorizontalAlignment(JTextField.CENTER);

        JButton findBtn = new JButton("Delete");
        findBtn.setPreferredSize(new Dimension(100, 50));

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        findBtn.addActionListener((e) -> {
            String slang = slangInput.getText();
            HashMap<String, String> result = manager.findBySlangWord(slang);
            if (result != null) {
                int delete = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this Slang?",
                        "Delete",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (delete == 0) {
                    manager.deleteAWord(slang);
                    JOptionPane.showMessageDialog(this, "Slang deleted successfully", "Notify", JOptionPane.INFORMATION_MESSAGE);

                }
            } else {
                JOptionPane.showMessageDialog(this, "Slang word doesn't exists !", "Notify", JOptionPane.ERROR_MESSAGE);
            }
            manager.writeSlangWordsToFile("output.txt");
        });

        inputContainer.add(inputLabel);
        inputContainer.add(slangInput);
        inputContainer.add(findBtn);
        this.add(main, BorderLayout.CENTER);
        this.add(inputContainer, BorderLayout.NORTH);
    }
}
