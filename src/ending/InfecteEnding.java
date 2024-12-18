package ending;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class InfecteEnding {
    public static void infecteEnding() {
        blank();
        System.out.println("                 당신은 좀비와 싸우다 뒤에서 오는 좀비에게 감염되었습니다.");
        blank();
        sec3();
        nextText();
        System.out.println("                         이제 지구는 종말에 길로 들어섭니다.");
        blank();
        sec3();
        nextText();
        System.out.println("                              SAD ENDING (2)");
        blank();
        sec3();
        nextText();
        System.out.println("                                    감염");
        blank();
        sec3();
        nextText();
        try {
            String Infecte = new String(Files.readAllBytes(Paths.get("Art/Ending/Infecte.txt")));
            System.out.println(Infecte); // 파일 내용 출력
        } catch (IOException e) {
            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
        miniblank();
        System.exit(0);
    }
    // 공백 추가
    private static void blank() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }

    private static void miniblank() {
        for (int i = 0; i < 3; i++) {
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


