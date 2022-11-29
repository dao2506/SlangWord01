package ForntEnd;

import java.io.FileNotFoundException;

public class application {
    static Launcher launcher = new Launcher();
    public static void main(String[] args) throws Exception {
        System.out.println("Đồ án môn học #1!");
        //launcher.runApp();
        launcher.loop();
        //launcher.testFunction4();
    }
}
