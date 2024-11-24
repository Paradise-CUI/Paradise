package choice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import sceen.*;

public class MainSceenChoice {
    public static boolean countinue = false;

    public static void mainSceenChoice() {
        Scanner sc = new Scanner(System.in);
        int coice = 0;

        while (true) {
            try {
                coice = sc.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 정수만 입력해주세요.");
                sc.nextLine(); // 입력 버퍼 비우기
                continue;
            }

            int newOrLoad = 0;
            if (coice == 1) {
                // "db/InventoryData.json" 파일 존재 여부 확인
                boolean saveFileExists = new File("db/PlayerData.json").exists();

                // 파일이 없으면 "새 게임" 옵션만 출력
                if (!saveFileExists) {
                    System.out.println("                1. 새 게임");
                    System.out.println("                저장된 파일이 없어 이어하기를 선택할 수 없습니다.");
                    while (true) {
                        try {
                            newOrLoad = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("잘못된 입력입니다. 정수만 입력해주세요.");
                            sc.nextLine();
                            continue;
                        }
                        if (newOrLoad == 1) {
                            break;
                        } else {
                            System.out.println("잘못된 입력입니다. 새 게임을 선택해주세요.");
                        }
                    }
                } else {
                    // 파일이 있으면 "새 게임"과 "이어하기" 모두 표시
                    System.out.println("                1. 새 게임");
                    System.out.println("                2. 이어하기");
                    while (true) {
                        try {
                            newOrLoad = sc.nextInt();
                        } catch (Exception e) {
                            System.out.println("잘못된 입력입니다. 정수만 입력해주세요.");
                            sc.nextLine();
                            continue;
                        }
                        if (newOrLoad == 1) {
                            break;
                        } else if (newOrLoad == 2) {
                            countinue = true;
                            break;
                        } else {
                            System.out.println("잘못된 입력입니다.");
                        }
                    }
                }
                break;
            } else if (coice == 2) {
                // "게임 방법" 선택
                TutorialSceen.tutorial();
                try {
                    String menu = new String(Files.readAllBytes(Paths.get("Art/Sceen/Menu.txt")));
                    System.out.println(menu); // 파일 내용 출력
                } catch (IOException e) {
                    System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                }
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
