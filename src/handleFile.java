import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class handleFile {

    static ArrayList<String> list = new ArrayList<>();

    public static void importData(String url) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(url);
        Scanner scanner = new Scanner(fileInputStream);

        try {
            while (scanner.hasNextLine()) {
                String temp = scanner.nextLine();
                list.add(temp);
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
}
