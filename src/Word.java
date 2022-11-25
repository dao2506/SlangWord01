import java.util.ArrayList;

public class Word {
    String key;
    ArrayList<String> meaning = new ArrayList<String>();

    public Word(String string) {
        //split by ' to get key
        String[] key = string.split("'",2);
        this.key = key[0];
        //split by | to get meanings
        this.meaning.add(key[1]);
    }

    public void display(){
        System.out.println("Key: " + key);
        System.out.println("Meaning" + meaning);
    }

}
