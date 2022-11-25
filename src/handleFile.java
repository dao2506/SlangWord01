import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class handleFile {

    static ArrayList<Word> words = new ArrayList<>();

    public static void importData(String url) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner scanner = new Scanner(fileInputStream);

        try {
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                Word wordTemp = new Word(temp);
                words.add(wordTemp);
            }
        } finally {
            try {
                scanner.close();
                fileInputStream.close();
            } catch (IOException ex) {
                System.out.print("Can't find file");;
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        importData("resources/slang.txt");
        for (Word word: words){
            word.display();
        }
    }



}
