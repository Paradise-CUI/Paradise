package choice;

import sceen.*;
import setting.Inventory;
import setting.Player;

import java.util.Scanner;

public class MapSceenChoice {
    public static void mainSceenChoice(Player player, Inventory inventory) {
        Scanner sc = new Scanner(System.in);

        int choice = 0;
        try {
            choice = sc.nextInt();
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 정수만 입력해주세요.");
            sc.nextLine();
        }

        if (choice == 1) {
            Seoul.seoul(player, inventory);
        } else if (choice == 2) {
            Jeju.jeju(player, inventory);
        } else if (choice == 3) {
            Guangyang.guangyang(player, inventory);
        } else if (choice == 4) {
            Busan.busan(player, inventory);
        } else if (choice == 5) {
            Daejun.daejun(player, inventory);
        } else if (choice == 6) {
            Daegu.daegu(player, inventory);
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}
