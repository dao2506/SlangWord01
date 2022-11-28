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
    public Dictionary(){
        try {
            handleIOStream.importData("resources/slang.txt",mapWords);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Dictionary(String dataURL){
        try {
            handleIOStream.importData(dataURL,mapWords);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<String> lookupMeaning(String key){

        if (mapWords.containsKey(key)){
            return mapWords.get(key);
        } else {
            return new ArrayList<String>(List.of(new String[]{"This is not meaning in slang words dictionary"})) ;
        }

    }

    public void updateInternalData() throws FileNotFoundException {
        String content ="";

        handleIOStream.writeOnFile("data.txt",content);
    }


}
