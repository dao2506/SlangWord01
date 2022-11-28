package ForntEnd;

import CommonClass.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    ArrayList<Word> words = new ArrayList<>();
    static Map<String, Integer> mapWords= new HashMap<String,Integer>();
    //Trie trieWords = new Trie();
    public Dictionary(){
        try {
            handleIOStream.importData("resources/slang.txt",mapWords, words);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Dictionary(String dataURL){
        try {
            handleIOStream.importData(dataURL,mapWords,words);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<String> lookupMeaning(String key, Boolean flat){

        if (mapWords.containsKey(key)){
            flat = true;
            Integer index = mapWords.get(key);
            return words.get(index).getMeanings();
        } else {
            flat = false;
            return new ArrayList<String>(List.of(new String[]{"This is not meaning in slang words dictionary"})) ;
        }

    }

    public void updateInternalData() throws FileNotFoundException {
        StringBuilder content = new StringBuilder();
        for (Word word: words){
            content.append(words.toString());
        }
        handleIOStream.writeOnFile("resources/data.txt", content.toString());
    }


    public void add(String keyword, ArrayList<String> newMeanings) {
        words.add(new Word(keyword, newMeanings));
        mapWords.put(keyword, words.size());
    }

    public void addAnotherMeaning(String keyword, ArrayList<String> newMeanings) {
        Integer index = mapWords.get(keyword);
        words.get(index).addMeaning(newMeanings);
    }
}
