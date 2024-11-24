package sceen;

import choice.MainSceenChoice;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MainMenu {
    public static void mainmenu() {
        try {
            String Menu = new String(Files.readAllBytes(Paths.get("Art/Sceen/Menu.txt")));
            System.out.println(Menu); // 파일 내용 출력
        } catch (IOException e) {
            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }

        MainSceenChoice.mainSceenChoice();
    }
}
