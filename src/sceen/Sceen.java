package sceen;

// 게임 시작 후 메뉴 설정

import choice.MapSceenChoice;
import setting.Inventory;
import setting.Player;
import setting.Shop;

import java.util.Scanner;

public class Sceen {
    public static void sceen() {
        Scanner sc = new Scanner(System.in);
        Player player = new Player();
        Inventory inventory = new Inventory();
        player.print();


        int select = 0;
        while (true) {
            nextText();
            System.out.println("               1. 맵, 2. 스탯, 3. 인벤토리, 4. 상점, 5. 저장, 6. 종료");
            blank();
            try {
                select = sc.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 정수만 입력해주세요.");
                sc.nextLine();
            }
            if (select == 1) {
                Map.map();
                MapSceenChoice.mainSceenChoice(player, inventory);
            } else if (select == 2) {
                player.print();
            } else if (select == 3) {
                inventory.print(player);
            } else if (select == 4) {
                Shop.shop();
            } else if (select == 5) {
                System.out.println("저장");
            } else if (select == 6) {
                System.out.println("종료");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

    }

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
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
