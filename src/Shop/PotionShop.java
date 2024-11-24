package Shop;

import setting.Inventory;
import setting.Player;

import java.util.Scanner;

public class PotionShop {
    static Scanner sc = new Scanner(System.in);
    String[] potion = {"중급 포션", "상급 포션", "백신"}; // 하급 포션은 몬스터 드랍
    static int[] potionPrice = {100, 500, 2000}; // 포션 가격

    public static void potion(Player player, Inventory inventory) {
        int select = 0;
        while (true) {
            print();
            try {
                select = sc.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 정수만 입력해주세요.");
                sc.nextLine();
                continue;
            }

            if (select == 0) {
                System.out.println("                                 상점을 종료합니다.");
                sec1();
                break;
            }

            if (select < 0 || select > 3) {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                sec1();
                continue;
            }

            if (select == 1) {
                if (haveMoney(player, select)) {
                    player.minusMoney(potionPrice[select - 1]);
                    inventory.plusMiddlePotion(1);
                    System.out.println("                         중급 포션을 구매하셨습니다.");
                    blank();
                    sec2();
                    break;
                } else {
                    System.out.println("돈이 부족합니다.");
                    sec1();
                    break;
                }
            } else if (select == 2) {
                if (haveMoney(player, select)) {
                    player.minusMoney(potionPrice[select - 1]);
                    inventory.plusHighPotion(1);
                    System.out.println("                         상급 포션을 구매하셨습니다.");
                    blank();
                    sec2();
                    break;
                } else {
                    System.out.println("돈이 부족합니다.");
                    sec1();
                    break;
                }
            } else if (select == 3) {
                if (haveMoney(player, select)) {
                    player.minusMoney(potionPrice[select - 1]);
                    inventory.plusVaccine(1);
                    System.out.println("                            백신을 구매하셨습니다.");
                    blank();
                    sec2();
                    break;
                } else {
                    System.out.println("돈이 부족합니다.");
                    sec1();
                    break;
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                sec1();
                nextText();
            }
        }
    }

    public static void print() {
        System.out.println("                            1. 중급 포션 (100원)");
        System.out.println("                            2. 상급 포션 (500원)");
        System.out.println("                            3. 백신 (2000원)");
        System.out.println("                            0. 상점 종료");
        blank();
    }

    public static boolean haveMoney(Player player, int select) {
        if (player.getMoney() >= potionPrice[select - 1]) {
            return true;
        }
        return false;
    }

    private static void blank() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }

    private static void nextText() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    private static void sec2() {
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void sec1() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
