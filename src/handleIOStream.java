import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public  class handleIOStream {

    static Scanner scanner;
    public static void importData(String url, Map<String,ArrayList<String>> map) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(url);
        scanner = new Scanner(fileInputStream);
        try {
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                Word wordTemp = new Word(temp);
                map.put(wordTemp.getKey(),wordTemp.getMeanings());
                //words.add(wordTemp);
            }
        } finally {
            try {
                scanner.close();
                fileInputStream.close();
                map.remove("Slag");
                System.out.println("Import successfully");
            } catch (IOException ex) {
                System.out.print("Can't find file");;
            }
        }
    }

    public static String inputKey(){
        System.out.print("Input key: ");
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
