package CommonClass;

import java.util.ArrayList;
import java.util.Collections;

public class Word {
    String key;
    ArrayList<String> meaning = new ArrayList<String>();


    public Word(String string) {
        //split by ' to get key
        String[] key = string.split("`",2);
        this.key = key[0];
        //split by | to get meanings
        if (key.length > 1){
            String[] meanings = key[1].split("\\|");
            Collections.addAll(this.meaning, meanings);
        } else {
            this.meaning.add("");
        }
    }

    public Word(String keyword, ArrayList<String> newMeanings) {
        key=keyword;
        meaning = newMeanings;
    }

    public void display(){
        System.out.println("Key: " + key);
        System.out.println("Meaning: " + meaning);
    }

    public String getKey(){
        return this.key;
    }

    public ArrayList<String> getMeanings(){
        return this.meaning;
    }

    public void addMeaning(ArrayList<String> newMeaning){
        meaning.addAll(newMeaning);
    }
    public String toString(){
        String temp = key +  "`";;
        for (String meaning : this.meaning){
            temp= meaning + "|";
        }
        return temp;
    }

}
