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

    public HashMap<String, String> findBySlangWord(String slang){
        HashMap<String, String> rs = new HashMap<>();
        slangWords.forEach((key, value)->{
            if(key.equals(slang)){
                rs.put(key, value);
            }
        });
        if(rs.size() == 0){
            return null;
        }
        return rs;
    }

    public String getDefinitionBySlang(String slang){
        HashMap<String, String> rs = new HashMap<>();
        slangWords.forEach((key, value)->{
            if(key.equals(slang)){
                rs.put(key, value);
            }
        });
        if(rs.size() == 0){
            return null;
        }
        return rs.get(slang);
    }

    public HashMap<String, String> findWordsByKeyWord(String keyWord){
        HashMap<String, String> result = new HashMap<>();
        slangWords.forEach((key, value)->{
            if(value.contains(keyWord)){
                result.put(key, value);
            }
        });
        if(result.size() == 0){
            return null;
        }
        return result;
    }
}
