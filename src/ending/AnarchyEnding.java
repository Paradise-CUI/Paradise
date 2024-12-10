package ending;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AnarchyEnding {
    public static void anarchyEnding() {
        blank();
        System.out.println("                             당신은 성공적으로 좀비를 막았습니다.");
        blank();
        sec3();
        nextText();
        System.out.println("                              하지만 당신은 당선에 실패했습니다.");
        blank();
        sec3();
        nextText();
        System.out.println("                                 HIDDEN ENDING (4)");
        blank();
        sec3();
        nextText();
        System.out.println("                                        무정부");
        blank();
        sec3();
        nextText();
        try {
            String Capitalism = new String(Files.readAllBytes(Paths.get("Art/Ending/Anarchy.txt")));
            System.out.println(Capitalism); // 파일 내용 출력
        } catch (IOException e) {
            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
        miniBlank();
        System.exit(0);
    }
    // 공백 추가
    private static void blank() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }

    private static void miniBlank() {
        for (int i = 0; i < 2; i++) {
            System.out.println();
        }
    }

    // 다음 텍스트 전환 (스크롤)
    private static void nextText() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    // 3초 대기
    private static void sec3() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


