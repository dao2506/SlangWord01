package ForntEnd;

import CommonClass.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    ArrayList<Word> words = new ArrayList<>();
    static Map<String, ArrayList<String>> mapWords= new HashMap<String,ArrayList<String>>();
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
            return mapWords.get(key);
        } else {
            flat = false;
            return new ArrayList<String>(List.of(new String[]{"This is not meaning in slang words dictionary"})) ;
        }

    }

    public void updateInternalData() throws FileNotFoundException {
        String content ="";
        for (Word word: words){
            content +=words.toString();
        }
        handleIOStream.writeOnFile("resources/data.txt",content);
    }


    public void add(String keyword, ArrayList<String> newMeanings) {
        words.add(new Word(keyword, newMeanings));
        mapWords.put(keyword, newMeanings);
    }

    public void addAnotherMeaning(String keyword, ArrayList<String> newMeanings) {

    }
}
