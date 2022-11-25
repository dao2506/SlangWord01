import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {
    static ArrayList<Word> words = new ArrayList<>();
    static Map<String, ArrayList<String>> mapWords= new HashMap<String,ArrayList<String>>();

    public static ArrayList<String> findMeaningOfKeywordInDictionary(String key){

        if (mapWords.containsKey(key)){
            return mapWords.get(key);
        } else {
            return new ArrayList<String>(List.of(new String[]{"This is not meaning in slang words dictionary"})) ;
        }

    }


    public static void main(String[] args) throws Exception {
        handleIOStream.importData("resources/slang.txt",mapWords);

        String key = handleIOStream.inputKey();
        System.out.println("Meaning: " + findMeaningOfKeywordInDictionary(key));

    }

}
