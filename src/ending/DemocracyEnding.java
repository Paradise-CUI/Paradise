package ending;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DemocracyEnding {
    public static void democracyEnding() {
        blank();
        System.out.println("                             당신은 성공적으로 좀비를 막았습니다.");
        blank();
        sec3();
        nextText();
        try {
            String Text1 = new String(Files.readAllBytes(Paths.get("Art/Message/Text1.txt")));
            System.out.println(Text1); // 파일 내용 출력
        } catch (IOException e) {
            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
        blank();
        sec5();
        nextText();
        try {
            String Text2 = new String(Files.readAllBytes(Paths.get("Art/Message/Text2.txt")));
            System.out.println(Text2); // 파일 내용 출력
        } catch (IOException e) {
            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
        blank();
        sec5();
        nextText();
        try {
            String Text3 = new String(Files.readAllBytes(Paths.get("Art/Message/Text3.txt")));
            System.out.println(Text3); // 파일 내용 출력
        } catch (IOException e) {
            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
        blank();
        sec5();
        nextText();
        System.out.println("                                        ENDING");
        blank();
        sec3();
        nextText();
        System.out.println("                                         대통령");
        blank();
        sec3();
        nextText();
        try {
            String Democracy = new String(Files.readAllBytes(Paths.get("Art/Ending/Democracy.txt")));
            System.out.println(Democracy); // 파일 내용 출력
        } catch (IOException e) {
            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
        System.exit(0);
    }
    // 공백 추가
    private static void blank() {
        for (int i = 0; i < 15; i++) {
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

    // 5초 대기
    private static void sec5() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


