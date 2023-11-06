package com.vukhoa23.app.UI;

import com.vukhoa23.app.entity.SlangWordManager;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;


public class FindBySlang extends JPanel {

    public FindBySlang(SlangWordManager manager){
        this.setBounds(0,0,500,500);
        this.setPreferredSize(new Dimension(500, 500 ));
        this.setBackground(Color.darkGray);


        this.setLayout(new BorderLayout());

        JPanel inputContainer = new JPanel();
        inputContainer.setLayout(new FlowLayout());

        JTextField slangInput = new JTextField();
        slangInput.setPreferredSize(new Dimension(200, 50));
        slangInput.setHorizontalAlignment(JTextField.CENTER);

        JButton findBtn = new JButton("Find");
        findBtn.setPreferredSize(new Dimension(100, 50));

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        findBtn.addActionListener((e)->{
            String slang = slangInput.getText();
            HashMap<String, String> result = manager.findBySlangWord(slang);
            DefaultListModel<String> model = new DefaultListModel<>();
            if (result != null) {
                result.forEach((key, value) -> {
                    model.addElement(key + ": " + value);
                    manager.addToHistory(key, value);
                });
                main.removeAll();
                JList<String> findResult = new JList<>(model);
                findResult.setFont(new Font("SansSerif",Font.BOLD, 15));
                main.add(findResult, BorderLayout.CENTER);
                main.validate();
                main.repaint();
            } else {
                main.removeAll();
                JLabel label = new JLabel("SLANG WORD DOESN'T EXISTS");
                label.setFont(new Font("SansSerif",Font.BOLD, 30));
                label.setForeground(Color.white);
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                label.setForeground(Color.RED);
                main.add(label, BorderLayout.CENTER);
                main.validate();
                main.repaint();
            }

        });

        inputContainer.add(slangInput);
        inputContainer.add(findBtn);
        this.add(main, BorderLayout.CENTER);
        this.add(inputContainer, BorderLayout.NORTH);
    }
}
