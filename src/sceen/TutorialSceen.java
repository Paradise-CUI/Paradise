package sceen;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

// 튜토리얼을 위한 씬 생성

public class TutorialSceen {
    public static void tutorial() {
        Scanner sc = new Scanner(System.in);
        int select = 0;



        while (true) {
            nextText();
            System.out.println("               1. 맵, 2. 스탯, 3. 인벤토리, 4. 상점, 5. 저장, 6. 로드, 7. 나가기");
            blank();
            try {
                select = sc.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 정수만 입력해주세요.");
                sc.nextLine();
                continue;
            }
            nextText();
            if (select == 1) {
                try {
                    String Map = new String(Files.readAllBytes(Paths.get("Art/Tutorial/Map.txt")));
                    System.out.println(Map); // 파일 내용 출력
                } catch (IOException e) {
                    System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                }
            } else if (select == 2) {
                try {
                    String Status = new String(Files.readAllBytes(Paths.get("Art/Tutorial/Status.txt")));
                    System.out.println(Status); // 파일 내용 출력
                } catch (IOException e) {
                    System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                }
            } else if (select == 3) {
                try {
                    String Inventory = new String(Files.readAllBytes(Paths.get("Art/Tutorial/Inventory.txt")));
                    System.out.println(Inventory); // 파일 내용 출력
                } catch (IOException e) {
                    System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                }
            } else if (select == 4) {
                try {
                    String Shop = new String(Files.readAllBytes(Paths.get("Art/Tutorial/Shop.txt")));
                    System.out.println(Shop); // 파일 내용 출력
                } catch (IOException e) {
                    System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                }
            } else if (select == 5) {
                try {
                    String Save = new String(Files.readAllBytes(Paths.get("Art/Tutorial/Save.txt")));
                    System.out.println(Save); // 파일 내용 출력
                } catch (IOException e) {
                    System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                }
            } else if (select == 6) {
                try {
                    String Load = new String(Files.readAllBytes(Paths.get("Art/Tutorial/Load.txt")));
                    System.out.println(Load); // 파일 내용 출력
                } catch (IOException e) {
                    System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                }
            } else if (select == 7) {
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
                continue;
            }
            System.out.println("                       10초 후에 자동으로 튜토리얼 화면으로 돌아갑니다.");
            blank();
            sec10();
        }

    }

    // 10초 대기
    private static void sec10() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void nextText() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    private static void blank() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }

    // 2초 대기
    private static void sec2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
