package com.vukhoa23.app.entity;

import java.io.*;
import java.util.*;

public class SlangWordManager {
    private TreeMap<String, String> slangWords = new TreeMap<>();
    private HashMap<String, Date> history = new HashMap<>();

    public HashMap<String, Date> getHistory() {
        return history;
    }

    public TreeMap<String, String> getWords(){
        return slangWords;
    }

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

    public void readSlangWordsFromFile(String fileName) throws FileNotFoundException {
        slangWords = new TreeMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            String line;
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] rawDatas = line.split("`");
                List<String> datas = Arrays.stream(rawDatas).toList();
                if(datas.size() == 1){
                    continue;
                }
                addToWords(datas.get(0), datas.get(1));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getRandomSlang(){
        Random generator = new Random();
        Object[] keys = getWords().keySet().toArray();
        Object randomKey = keys[generator.nextInt(keys.length)];
        return (String) randomKey;
    }

    public HashMap<String, String> getFourRandomSlang(){
        HashMap<String, String> result = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            Random generator = new Random();
            Object[] keys = getWords().keySet().toArray();
            Object randomKey = keys[generator.nextInt(keys.length)];
            while(result.containsKey((String)randomKey)){
                randomKey = keys[generator.nextInt(keys.length)];
            }
            result.put((String) randomKey, slangWords.get(randomKey));

        }
        return result;
    }

    public void writeSlangWordsToFile(String fileName){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));) {
            writer.write("");
            slangWords.forEach((key, value)->{
                try {
                    writer.write(key + "`" + value + "\n");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
