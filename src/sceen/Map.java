package sceen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// 맵 선택 화면

public class Map {
    public static void map() {
        try {
            String Map = new String(Files.readAllBytes(Paths.get("Art/Sceen/Map.txt")));
            System.out.println(Map); // 파일 내용 출력
        } catch (IOException e) {
            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
