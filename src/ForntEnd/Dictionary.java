package ForntEnd;

import CommonClass.*;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    //ArrayList<Word> words = new ArrayList<>(100000);
    HashMap<String, ArrayList<String>> mapWords= new HashMap<String, ArrayList<String>>();
    Trie trieWords = new Trie();
    public Dictionary(){
        try {
            handleIOStream.importData("resources/slang.txt",trieWords, mapWords);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Dictionary(String dataURL){
        try {
            handleIOStream.importData(dataURL,trieWords,mapWords);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public  boolean isFound(String keyword){
        return trieWords.find(keyword);
    }
    public ArrayList<String> lookupMeaning(String key){
        return mapWords.get(key);
    }

    public void add(String keyword, ArrayList<String> newMeanings) {
        mapWords.put(keyword, newMeanings);
        trieWords.insert(keyword);
    }

    public void addAnotherMeaning(String keyword, ArrayList<String> newMeanings) {
        //TODO
    }

    public void overWriteNewMeanings(String keyword, ArrayList<String> newMeanings) {
        //TODO

    }

    public void delete(String keyword) {
        mapWords.remove(keyword);
        trieWords.delete(keyword);
    }


    public void resetData() throws Exception {
        handleIOStream.importData("resources/slang.txt",trieWords, mapWords);
    }
}
