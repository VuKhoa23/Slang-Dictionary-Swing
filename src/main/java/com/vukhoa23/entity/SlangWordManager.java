package com.vukhoa23.entity;

import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

public class SlangWordManager {
    TreeMap<String, String> slangWords = new TreeMap<>();
    HashMap<String, Date> history = new HashMap<>();

    public void addToHistory(String key, String value) {
        history.put(key, new Date());
    }

    public void addToWords(String key, String value) {
        slangWords.put(key, value);
    }

    public void deleteAWord(String key){
        slangWords.remove(key);
    }
}
