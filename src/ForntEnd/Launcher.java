package ForntEnd;

import CommonClass.handleIOStream;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;

public class Launcher {
    static Dictionary dictionary = new Dictionary("resources/slang.txt");


    private static int mainMenu(){

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
        dictionary.lookupMeaning(keyword, isFound);
        String YN = "";
        ArrayList<String> newMeanings = new ArrayList<>();
        if (!isFound){
            do {
                String newMeaning = handleIOStream.input("Hãy nhập nghĩa của từ: ");
                newMeanings.add(newMeaning);

                YN = handleIOStream.input("Hãy nhấn Y (Yes) nếu bạn đã nhập xong các nghĩa của từ. Nếu chưa, hãy nhấn bất kì để tiếp tục: ");
            } while (!Objects.equals(YN, "Y"));
            dictionary.add(keyword,newMeanings);
            return "Thêm từ mới thành công";
        } else {
            System.out.println("""
                    Từ đã tồn tại, vui lòng đưa ra lựa chọn:
                    1. Ghi đè
                    2. Nhân bản""");
            Integer choose = Integer.parseInt(handleIOStream.input("Hãy chọn chức năng bạn muốn:"));





            fyuulo;

        }

        return "Thêm từ mới thành công";
    }

    public static void main(String[] args) throws FileNotFoundException {
        //dictionary.updateInternalData();
        int choose = 0;
        choose =        mainMenu();
        String result = switch (choose) {
            case 1 -> function1();
            case 2 -> function2();
            case 3 -> function3();
            case 4 -> function4();
            case 5 -> function5();
            default -> "";
        };

        System.out.println(result);


    }

    private static String function5() {
        String keyword = handleIOStream.input("Hãy nhập từ muốn chỉnh sửa:");
        boolean isFound = false;
        dictionary.lookupMeaning(keyword, isFound);
        String YN = "";
        ArrayList<String> newMeanings = new ArrayList<>();
        if (!isFound){
            return "Không tồn tại từ này trong từ điển. Vui lòng xem lại";
        }
        System.out.println("Từ này đã tồn tại với các nghĩa như sau: " + dictionary.lookupMeaning(keyword,null));
        YN = handleIOStream.input("Bạn muốn nhập thêm nghĩa mới của từ.Nhấn Y (Yes) để đồng ý. Nếu không, hãy nhấn bất kì để tiếp tục: ");

        while (!Objects.equals(YN, "Y")) {
            String newMeaning = handleIOStream.input("Hãy nhập nghĩa của từ");
            newMeanings.add(newMeaning);
            YN = handleIOStream.input("Bạn muốn nhập thêm nghĩa mới của từ.Nhấn Y (Yes) để đồng ý. Nếu không, hãy nhấn bất kì để tiếp tục");
        };
        dictionary.addAnotherMeaning(keyword,newMeanings);
        return "Đã chỉnh sửa thành công";
    }


}
