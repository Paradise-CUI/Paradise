package setting;

import java.util.*;

public class Shop {
    Scanner sc = new Scanner(System.in);
    String[] weapon = {"도끼", "후라이팬", "대검", "쇠뇌", "권총", "샷건", "소총", "저격총"};
    String[] potion = {"중급 포션", "상급 포션", "마나 포션", "백신"}; // 하급 포션은 몬스터 드랍

    static int shopchoice = 1;
    public static void shop() {
//        try {
//            shopchoice = sc.nextInt();
//        } catch (Exception e) {
//            System.out.println("잘못된 입력입니다. 정수만 입력해주세요.");
//            sc.nextLine();
//        }
        nextText();

        switch (shopchoice) {
            case 1:
                System.out.println("1. 무기 상점");
                break;
            case 2:
                System.out.println("2. 포션 상점");
                break;
            case 3:
                System.out.println("3. 스탯 상점");
                break;
            default:
                break;
        }
    }

    private boolean haveMoney() {

        return false;
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
