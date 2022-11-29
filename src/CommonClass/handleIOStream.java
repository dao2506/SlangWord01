package CommonClass;

import java.io.*;
import java.util.*;

public  class handleIOStream {
    static Scanner scanner;

    public static String inputKey(){
        System.out.print("Input key: ");
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static String input(String title){
        System.out.print(title);
        scanner = new Scanner(System.in);
        return scanner.nextLine();
    }



    public static void writeOnFile(String url, String content) throws FileNotFoundException {
        File file = null;
        FileOutputStream fileOutputStream = null;
        try {
            file = new File(url);
            fileOutputStream = new FileOutputStream(file);
            //create file if not exists
            if (!file.exists()) {
                file.createNewFile();
            }
            //fetch bytes from data
            byte[] bs = content.getBytes();
            fileOutputStream.write(bs);
            fileOutputStream.flush();
            fileOutputStream.close();
            System.out.println("File written successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void importData(String URL, Trie trieWords, HashMap<String, ArrayList<String>> map, ArrayList<Word> words) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(URL);
        scanner = new Scanner(fileInputStream);
        //int index = -1;
        try {
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                Word wordTemp = new Word(temp);
                //index ++;
                map.put(wordTemp.getKey(),wordTemp.getMeanings());
                trieWords.insert(wordTemp.getKey());
                words.add(wordTemp);
            }
        } finally {
            try {
                scanner.close();
                fileInputStream.close();
                //map.remove("Slag");
                System.out.println("Import successfully");
            } catch (IOException ex) {
                System.out.print("Can't find file");;
            }
        }
    }
}
