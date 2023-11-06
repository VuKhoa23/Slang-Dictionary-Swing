package com.vukhoa23.app.UI;

import com.vukhoa23.app.entity.SlangWordManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ViewHistory extends JPanel {
    public Map<String, Date> sortHistoryByDates(HashMap<String, Date> history){
        Map<String, Date> sorted = history
                .entrySet()
                .stream()
                .sorted((i1, i2)
                        -> i2.getValue().compareTo(
                        i1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        return sorted;
    }
    public ViewHistory(SlangWordManager manager) {
        Map<String, Date> result = sortHistoryByDates(manager.getHistory());

        this.setBounds(0,0,500,500);
        this.setPreferredSize(new Dimension(500, 500 ));
        this.setBackground(Color.darkGray);


        this.setLayout(new BorderLayout());

        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        JTable table = new JTable();
        String[] columnHeaders = {"Date", "Slang Word"};
        DefaultTableModel model = new DefaultTableModel(columnHeaders, 0);

        result.forEach((key, value)->{
            model.addRow(new Object[]{value, key});
        });

        table.setModel(model);
        table.setFont((new Font("SansSerif",Font.BOLD, 15)));
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        this.add(main, BorderLayout.CENTER);
        main.add(scrollPane);
    }
}
