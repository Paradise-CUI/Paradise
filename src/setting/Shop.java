package setting;

import Shop.*;

public class Shop {
    String[] weapon = {"도끼", "후라이팬", "대검", "쇠뇌", "권총", "샷건", "소총", "저격총"};
    String[] potion = {"중급 포션", "상급 포션", "백신"}; // 하급 포션은 몬스터 드랍

    public static void shop(int shopchoice, Player player, Inventory inventory) {
        nextText();
        if (shopchoice == 1) {
            WeaponShop.weapon(player);
        } else if (shopchoice == 2) {
            PotionShop.potion(player, inventory);
        } else if (shopchoice == 3) {
            StatsShop.stats(player);
        } else if (shopchoice == 0) {
            System.out.println("상점을 종료합니다.");
        } else {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요.");

        }
    }

    public static void print() {
        System.out.println("                            1. 무기 상점");
        System.out.println("                            2. 포션 상점");
        System.out.println("                            3. 스탯 상점");
        System.out.println("                            0. 상점 종료");
        blank();
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
