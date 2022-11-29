package ForntEnd;

import CommonClass.handleIOStream;

import java.util.ArrayList;
import java.util.Objects;

import static ForntEnd.MESSAGE.*;


public class Launcher {
    Dictionary dictionary = new Dictionary("resources/slang.txt");
    String keyword;
    ArrayList<String> foundHistory = new ArrayList<>();

    private static int mainMenu(){
        System.out.println(MESSAGE.mainMenu);
        return Integer.parseInt(handleIOStream.input("Hãy chọn chức năng bạn muốn: "));
    }

    private String function1(){ //1. Chức năng tìm kiếm theo slang word.
        keyword = handleIOStream.input("Hãy nhập từ muốn tra:");
        foundHistory.add(keyword);
        StringBuilder result = new StringBuilder();
        if (!dictionary.isFound(keyword)){
            result.append( message_NotFound);
        } else {
            ArrayList<String> meaning = dictionary.lookupMeaning(keyword);
            for (String i : meaning) {
                result.append(i).append(" | ");
            }
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
        //TODO code here
        // - return isFound or not
        // - if !isFound -> add new
        // - else overwrite/ add more meaning
        String YN;
        ArrayList<String> newMeanings = new ArrayList<>();
        if (!dictionary.isFound(keyword)){

            do {
                String newMeaning = handleIOStream.input("Hãy nhập nghĩa của từ: ");
                newMeanings.add(newMeaning);
                YN = handleIOStream.input(message_Confirm);
            } while (!Objects.equals(YN, "Y"));
            dictionary.add(keyword,newMeanings);
        } else {
            System.out.println("""
                    Từ đã tồn tại, vui lòng đưa ra lựa chọn:
                    1. Ghi đè
                    2. Nhân bản""");
           int choose = Integer.parseInt(handleIOStream.input("Hãy chọn chức năng bạn muốn:"));
           do {
                String newMeaning = handleIOStream.input("Hãy nhập nghĩa của từ: ");
                newMeanings.add(newMeaning);
                YN = handleIOStream.input(message_Confirm);
            } while (!Objects.equals(YN, "Y"));
            switch (choose) {
                case 1 -> dictionary.overWriteNewMeanings(keyword, newMeanings);
                case 2 -> dictionary.addAnotherMeaning(keyword, newMeanings);
            }
        }
        return "Thêm từ mới thành công";
    }

    private String function5() {
        keyword = handleIOStream.input("Hãy nhập từ muốn chỉnh sửa: ");
        //TODO code here
        // - return isFound or not
        // - if !isFound -> add new
        // - else overwrite/ add more meaning

//        boolean isFound = false;
//        dictionary.lookupMeaning(keyword, isFound);
//        String YN = "";
//        ArrayList<String> newMeanings = new ArrayList<>();
//
//        if (!isFound){
//            return message_NotFound;
//        }
//        System.out.println("Từ này đã tồn tại với các nghĩa như sau: " + dictionary.lookupMeaning(keyword,null));
//        YN = handleIOStream.input("Bạn muốn nhập thêm nghĩa mới của từ.Nhấ Y để đồng ý. Nếu không, hãy nhấn Enter để tiếp tục: ");
//
//        while (!Objects.equals(YN, "Y")) {
//            String newMeaning = handleIOStream.input("Hãy nhập nghĩa của từ");
//            newMeanings.add(newMeaning);
//            YN = handleIOStream.input(message_Confirm);
//        };
//        dictionary.addAnotherMeaning(keyword,newMeanings);
        return message_ThisFunctionNotBuildYet;
    }





    private String function10() {
        //TODO
        return "";
    }

    private String function9() {
        //TODO
        return "";
    }

    private String function8() {
        //TODO
        return "";
    }

    private String function7() throws Exception {//Chức năng reset danh sách slang words gốc.
        dictionary.resetData();
        return "Reset data reset danh sách slang words gốc thành công";
    }

    private String function6() {
        keyword = handleIOStream.input("Hãy nhập từ muốn xóa: ");
       if (!dictionary.isFound(keyword)){
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

    public void loop() throws Exception {
        runApp();
        keyword = handleIOStream.input("Bạn có muốn dừng thao tác khác?"+
                "\n (Y: để chắc chắn. Chọn nhấn enter để tiếp tục)");
        while (!Objects.equals(keyword, "Y"))
        {
            runApp();
        }

    }


    public void runApp() throws Exception {
        //dictionary.updateInternalData();
        int choose = mainMenu();
        String result = switch (choose) {
            case 1 -> function1();
            case 2 -> function2();
            case 3 -> function3();
            case 4 -> function4();
            case 5 -> function5();
            case 6 -> function6();
            case 7 -> function7();
            case 8 -> function8();
            case 9 -> function9();
            case 10 -> function10();
            case 0 -> endLauncher();
            default -> "";
        };

        System.out.println(result);

    }

    private String endLauncher() {
        System.exit(0);
        return "";
    }

}
