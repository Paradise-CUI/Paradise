package Shop;

import setting.Player;

import java.util.Scanner;

public class StatsShop {
    static Scanner sc = new Scanner(System.in);
    static int[] statsPrice = {100, 500, 2000}; // 포션 가격

    public static void stats(Player player) {
        int select = 0;
        while (true) {
            print();
            try {
                select = sc.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 정수만 입력해주세요.");
                sc.nextLine();
            }
            if (select == 1) {
                if (haveMoney(player, select)) {
                    player.minusMoney(statsPrice[select - 1]);
                    player.plusMaxHP(100);
                    player.setHP(player.getMaxHP());
                    System.out.println("                  HP를 100 증가하셨습니다.");
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
                    player.minusMoney(statsPrice[select - 1]);
                    player.plusDamage(10);
                    System.out.println("                   데미지를 10 증가하셨습니다.");
                    blank();
                    sec2();
                    break;
                } else {
                    System.out.println("돈이 부족합니다.");
                    sec1();
                    break;
                }
            } else if (select == 3) {
                if (player.getSpecialAttack()) {
                    System.out.println("                 이미 특수공격을 가지고 있습니다.");
                    sec1();
                    break;
                } else {
                    if (haveMoney(player, select)) {
                        player.minusMoney(statsPrice[select - 1]);
                        player.setSpecialAttack(true);
                        System.out.println("                특수공격을 배웠습니다.");
                        blank();
                        sec2();
                        break;
                    } else {
                        System.out.println("돈이 부족합니다.");
                        sec1();
                        break;
                    }
                }
            } else if (select == 4) {
                if (Rating(player)) {
                    System.out.println("                 이미 지지율이 100입니다.");
                    sec1();
                    break;
                }
                if (haveMoney(player, select)) {
                    player.minusMoney(statsPrice[select - 1]);
                    player.plusRating(1);
                    System.out.println("                 지지율이 1 증가하셨습니다.");
                    blank();
                    sec2();
                    break;
                } else {
                    System.out.println("돈이 부족합니다.");
                    sec1();
                    break;
                }
            } else if (select == 0) {
                System.out.println("                       상점을 종료합니다.");
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }

    public static void print() {
        System.out.println("                            1. HP (100원)");
        System.out.println("                            2. DAMAGE (500원)");
        System.out.println("                            3. 특수공격 (5000원)");
        System.out.println("                            4. 지지율 (2000원)");
        System.out.println("                            0. 상점 종료");
        blank();
    }

    public static boolean haveMoney(Player player, int select) {
        if (player.getMoney() >= statsPrice[select - 1]) {
            return false;
        }
        return true;
    }

    public static boolean Rating(Player player) {
        if (player.getRating() >= 100) {
            return false;
        }
        return true;
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
