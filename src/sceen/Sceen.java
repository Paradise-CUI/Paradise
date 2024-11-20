package sceen;

// 게임 시작 후 메뉴 설정

import choice.MapSceenChoice;
import setting.Inventory;
import setting.Player;
import setting.Shop;
import SaveLoad.*;

import java.util.Scanner;
import java.io.File;

import static choice.MainSceenChoice.countinue;

public class Sceen {
    public static void sceen() {
        Scanner sc = new Scanner(System.in);
        Player player = null;
        Inventory inventory = null;
        if (countinue) {
            // 이어하기
            player = PlayerJsonLoader.loadData();
            inventory = InventoryJsonLoader.loadData();
            player.print();
        } else {
            // 새 게임
            player = new Player();
            inventory = new Inventory();
            player.print();
        }


        int select = 0;
        while (true) {
            nextText();
            System.out.println("               1. 맵, 2. 스탯, 3. 인벤토리, 4. 상점, 5. 저장 및 종료, 6. 종료");
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
                while (true) {
                    Shop.print();
                    int shopchoice = 0;
                    try {
                        shopchoice = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("잘못된 입력입니다. 정수만 입력해주세요.");
                        sc.nextLine();
                    }
                    if (shopchoice == 1 || shopchoice == 2 || shopchoice == 3) {
                    } else if (shopchoice == 0) {
                    } else {
                        System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                        continue;
                    }
                    Shop.shop(shopchoice, player, inventory);
                    break;
                }
            } else if (select == 5) {
                String path1 = "db/PlayerData.json";
                String path2 = "db/InventoryData.json";

                boolean exists1 = isFileCreated(path1);
                boolean exists2 = isFileCreated(path2);

                if (exists1 || exists2) {
                    System.out.println("데이터가 이미 존재합니다. 데이터를 덮어 씌우시겠습니까? (y/n)");
                    String answer = sc.next();
                    if (answer.equals("y") || answer.equals("Y")) {
                        PlayerJsonSaver.saveData(player);
                        InventoryJsonSaver.saveData(inventory);
                        break;
                    } else {
                        System.out.println("저장을 취소합니다.");
                    }
                } else {
                    PlayerJsonSaver.saveData(player);
                    InventoryJsonSaver.saveData(inventory);
                    break;
                }
            } else if (select == 6) {
                System.out.println("종료");
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }

    }

    public static boolean isFileCreated(String filePath) {
        File file = new File(filePath);
        return file.exists();
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
