package choice;

import java.util.Scanner;

import sceen.*;

public class MainSceenChoice {
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

            if (coice == 1) {
//            System.out.println ("게임을 시작합니다.");
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
