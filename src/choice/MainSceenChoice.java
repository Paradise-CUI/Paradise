package choice;

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
                sc.nextLine();
            }

            int newOrLoad = 0;
            if (coice == 1) {
//            System.out.println ("게임을 시작합니다.");
                System.out.println("1. 새 게임");
                System.out.println("2. 이어하기");
                while (true) {
                    try {
                        newOrLoad = sc.nextInt();
                    } catch (Exception e) {
                        System.out.println("잘못된 입력입니다. 정수만 입력해주세요.");
                        sc.nextLine();
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
                break;
            } else if (coice == 2) {
//            System.out.println ("게임방법을 출력합니다.");
                TutorialSceen.tutorial();
                break;
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
