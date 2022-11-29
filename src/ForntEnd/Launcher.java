package ForntEnd;

import CommonClass.handleIOStream;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;


public class Launcher {
    Dictionary dictionary = new Dictionary("resources/slang.txt");
    String keyword;

    ArrayList<String> foundHistory = new ArrayList<>();

    private static final String message_NotFound = "Không tồn tại từ này trong từ điển. Vui lòng xem lại!";
    private static final String message_ThisFunctionNotBuildYet = "Chức năng này hiện chưa được cập nhập, xin vui lòng quay lại sau! Xin cảm ơn!";
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

    private String function1(){ //1. Chức năng tìm kiếm theo slang word.
        keyword = handleIOStream.input("Hãy nhập từ muốn tra:");
        foundHistory.add(keyword);
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
        return message_ThisFunctionNotBuildYet;
    }
    
    private String function3(){//3. Chức năng hiển thị history, danh sách các slang word đã tìm kiếm.
        StringBuilder content = new StringBuilder();
        content.append("Lịch sử tìm khiếm: \n");
        for (String i: foundHistory){
            content.append(i).append("\n");
        }
        return  content.toString();
    }
    private  String function4(){
        keyword = handleIOStream.input("Hãy nhập từ muốn thêm:");
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
        } else {
            System.out.println("""
                    Từ đã tồn tại, vui lòng đưa ra lựa chọn:
                    1. Ghi đè
                    2. Nhân bản""");
            int choose = Integer.parseInt(handleIOStream.input("Hãy chọn chức năng bạn muốn:"));
            switch (choose) {
                case 1 -> dictionary.overWriteNewMeanings(keyword, newMeanings);
                case 2 -> dictionary.addAnotherMeaning(keyword, newMeanings);
            }
        }
        return "Thêm từ mới thành công";
    }

    private String function5() {
        keyword = handleIOStream.input("Hãy nhập từ muốn chỉnh sửa: ");
        boolean isFound = false;
        dictionary.lookupMeaning(keyword, isFound);
        String YN = "";
        ArrayList<String> newMeanings = new ArrayList<>();
        if (!isFound){
            return message_NotFound;
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



    public void runApp() {
        //dictionary.updateInternalData();
        int choose = mainMenu();
        String result = switch (choose) {
            case 1 -> function1();
            case 2 -> function2();
            case 3 -> function3();
            case 4 -> function4();
            case 5 -> function5();
            case 6 -> function6();
            default -> "";
        };

        System.out.println(result);

    }

    private String function6() {
        keyword = handleIOStream.input("Hãy nhập từ muốn xóa: ");
        boolean isFound = false;
        dictionary.lookupMeaning(keyword, isFound);
        if (!isFound){
            return message_NotFound;
        }
        String confirm = handleIOStream.input("Từ này sẽ bị xóa khỏi từ điển. Bạn chắc chứ? " +
                "\n (Y: để chắc chắn. Chọn nhấn bất kì để hủy bỏ)");
        if (Objects.equals(confirm, "Y")){
            dictionary.delete(keyword);
            return "Đã xóa " + keyword + " thành công";
        }
        return "Đã hủy thao tác xóa";

    }


    public void loop(){
        runApp();
        keyword = handleIOStream.input("Bạn có muốn tiếp tục thao tác khác?"+
                "\n (Y: để chắc chắn. Chọn nhấn bất kì để hủy bỏ)");
        while (!Objects.equals(keyword, "Y"))
        {
            runApp();
        }

    }

    public void testFunction4(){
        System.out.println(function4());
        System.out.println(function1());

    }

}
