package ForntEnd;

import CommonClass.handleIOStream;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

public class Launcher {
    static Dictionary dictionary = new Dictionary("resources/slang.txt");

    public static void clearConsole() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
    private static int mainMenu(){
        clearConsole();
        System.out.println("""
                Các chức năng
                1. Chức năng tìm kiếm theo slang word.
                2. Chức năng tìm kiếm theo definition, hiển thị ra tất cả các slang words mà trong defintion có chứa keyword gõ vào.
                3. Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.
                4. Chức năng add 1 slang words mới. Nếu slang words trùng thì thông báo cho người dùng, confirm có overwrite hay duplicate ra 1 slang word mới.
                5. Chức năng edit 1 slang word.
                6. Chức năng delete 1 slang word. Confirm trước khi xoá.
                7. Chức năng reset danh sách slang words gốc.
                8. Chức năng random 1 slang word (On this day slang word).
                9. Chức năng đố vui, chương trình hiển thị 1 random slang word, với 4 đáp án cho người dùng chọn.
                10. Chức năng đố vui, chương trình hiển thị 1 definition, với 4 slang words đáp án cho người dùng chọn.""");
        return Integer.parseInt(handleIOStream.input("Hãy chọn chức năng bạn muốn:"));
    }

    private static String function1(){ //1. Chức năng tìm kiếm theo slang word.
        String keyword = handleIOStream.input("Hãy nhập từ muốn tra:");
        boolean isFound = false;
        ArrayList<String> meaning = dictionary.lookupMeaning(keyword, isFound);

        if (!isFound){
            return meaning.get(0);
        }
        StringBuilder result = new StringBuilder();
        for (String i: meaning) {
            result.append(i).append(" | ");
        }
        return result.toString();
    }

    private static String function2(){//2. Chức năng tìm kiếm theo definition, hiển thị ra tất cả các slang words mà trong defintion có chứa keyword gõ vào.
        return  "Chức năng này hiện chưa được cập nhập, xin vui lòng quay lại sau! Xin cảm ơn!";
    }
    
    private static String function3(){//3. Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.
        return  "Chức năng này hiện chưa được cập nhập, xin vui lòng quay lại sau! Xin cảm ơn!";
    }
    private static String function4(){
        String keyword = handleIOStream.input("Hãy nhập từ muốn thêm:");
        boolean isFound = false;
        ArrayList<String> meaning = dictionary.lookupMeaning(keyword, isFound);
        String YN = "";
        ArrayList<String> newMeanings = new ArrayList<>();
        if (!isFound){


            do {
                String newMeaning = handleIOStream.input("Hãy nhập nghĩa của từ");
                newMeanings.add(newMeaning);
                YN = handleIOStream.input("Hãy nhấn Y (Yes) nếu bạn đã nhập xong các nghĩa của từ. Nếu chưa, hãy nhấn bất kì để tiếp tục");
            } while (!Objects.equals(YN, "Y"));
            dictionary.add(keyword,newMeanings);
            return "Thêm từ mới thành công";
        }
        System.out.println("Từ này đã tồn tại với các nghĩa như sau: " + dictionary.lookupMeaning(keyword,null));
        YN = handleIOStream.input("Bạn muốn nhập thêm nghĩa mới của từ.Nhấn Y (Yes) để đồng ý. Nếu không, hãy nhấn bất kì để tiếp tục");

        while (!Objects.equals(YN, "Y")); {
            String newMeaning = handleIOStream.input("Hãy nhập nghĩa của từ");
            newMeanings.add(newMeaning);
            YN = handleIOStream.input("Bạn muốn nhập thêm nghĩa mới của từ.Nhấn Y (Yes) để đồng ý. Nếu không, hãy nhấn bất kì để tiếp tục");
        };
        dictionary.addAnotherMeaning(keyword,newMeanings);
        return "";
    }

    public static void main(String[] args) throws FileNotFoundException {
        dictionary.updateInternalData();
        int choose = mainMenu();
        String result = "";
        clearConsole();
        switch (choose){
            case 1:
                result = function1();
                break;
            case 2:
                result = function2();
                break;
            case 3:
                result =function3();
                break;
            case 4:
                result = function4();
                break;
                
        }
        System.out.println(result);


    }



}
