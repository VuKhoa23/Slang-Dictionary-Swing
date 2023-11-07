package com.vukhoa23.app.UI;

import com.vukhoa23.app.entity.SlangWordManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;


public class FindByDefinition extends JPanel {
    public FindByDefinition(SlangWordManager manager) {
        this.setBounds(0,0,500,500);
        this.setPreferredSize(new Dimension(500, 500 ));
        this.setBackground(Color.darkGray);


        this.setLayout(new BorderLayout());

        JPanel inputContainer = new JPanel();
        inputContainer.setLayout(new FlowLayout());
        inputContainer.setPreferredSize(new Dimension(500, 100));

        JLabel inputLabel = new JLabel("Input the definition of the slang word");
        inputLabel.setFont(new Font("SansSerif",Font.PLAIN, 15));
        inputLabel.setPreferredSize(new Dimension(500, 20));
        inputLabel.setHorizontalAlignment(JLabel.CENTER);

        JTextField keyWordInput = new JTextField();
        keyWordInput.setPreferredSize(new Dimension(200, 50));
        keyWordInput.setHorizontalAlignment(JTextField.CENTER);

        JButton findBtn = new JButton("Find");
        findBtn.setPreferredSize(new Dimension(100, 50));

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        findBtn.addActionListener((e)->{
            String keyWord = keyWordInput.getText();
            JTable table = new JTable();
            table.setDefaultEditor(Object.class, null);
            String[] columnHeaders = {"Slang Word", "Definition"};
            DefaultTableModel model = new DefaultTableModel(columnHeaders, 0);
            HashMap<String, String> result = manager.findWordsByKeyWord(keyWord);
            if (result != null) {
                result.forEach((key, value) -> {
                    model.addRow(new Object[]{key, value});
                });
                main.removeAll();
                table.setModel(model);
                table.setFont((new Font("SansSerif",Font.BOLD, 15)));
                JScrollPane scrollPane = new JScrollPane(table);
                main.add(scrollPane, BorderLayout.CENTER);
                main.validate();
                main.repaint();
            } else {
                main.removeAll();
                JLabel label = new JLabel("NO MATCHING SLANG WORD");
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

        inputContainer.add(inputLabel);
        inputContainer.add(keyWordInput);
        inputContainer.add(findBtn);
        this.add(main, BorderLayout.CENTER);
        this.add(inputContainer, BorderLayout.NORTH);
    }
}
