package setting;

import java.util.*;

public class Inventory {
    transient Scanner sc = new Scanner(System.in);
    transient int[] potionHeal = {50, 100, 500}; // 포션 회복량
    int LowerPotion; // 소형 포션
    int MiddlePotion; // 중형 포션
    int HighPotion; // 대형 포션
    int vaccine; // 백신
    transient int allPotion; // 모든 포션

    public Inventory() {
        this.LowerPotion = 5;
        this.MiddlePotion = 0;
        this.HighPotion = 0;
        this.vaccine = 0;
    }

    public void print(Player player) {
        if (allPotion()) { // 만약에 전체 포션이 0개 보다 많다면
            System.out.println("                      소형 포션 : " + this.LowerPotion);
            System.out.println("                      중형 포션 : " + this.MiddlePotion);
            System.out.println("                      대형 포션 : " + this.HighPotion);
            System.out.println("                        백신   : " + this.vaccine);
            System.out.println("                 포션을 사용 하시겠습니까(y/n)"); // 포션 사용 여부
            blank();
            char YorN = sc.next().charAt(0); // 포션 사용 여부 입력
            if (YorN == 'y' || YorN == 'Y') { // 포션 사용 여부가 y 또는 Y 라면
                nextText();
                printPotion(player); // 포션 사용
            } else { // 포션 사용이 아니라면
                System.out.println("             인벤토리를 종료합니다."); // 인벤토리 종료
            }
        } else {
            System.out.println("                      소형 포션 : " + this.LowerPotion);
            System.out.println("                      중형 포션 : " + this.MiddlePotion);
            System.out.println("                      대형 포션 : " + this.HighPotion);
            System.out.println("                        백신   : " + this.vaccine);
            blank();
        }
        sec3();
        nextText();
    }


    public void printPotion(Player player) { // 포션 사용
        blank();
        System.out.println("               어떤 포션을 사용하시겠습니까?");
        System.out.println("                    1. 소형 포션 : " + this.LowerPotion);
        System.out.println("                    2. 중형 포션 : " + this.MiddlePotion);
        System.out.println("                    3. 대형 포션 : " + this.HighPotion);
        System.out.println("                      4. 백신 : " + this.vaccine);
        System.out.println("                    0. 포션 사용 종료");
        blank();
        potionSelect(player);
    }

    public void potionSelect(Player player) {
        int select = 0;
        while (true) {
            try {
                select = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("잘못된 입력입니다. 정수만 입력해주세요.");
                sc.nextLine();
            }
            if (select == 0) {
                System.out.println("포션 사용을 종료합니다.");
                break;
            } else if (select == 1 || select == 2 || select == 3 || select == 4) {
                if (canPotion(player)) {
                    if (select == 1) {
                        if (this.LowerPotion > 0) {
                            if (player.testPlusHP()) {
                                System.out.println("포션 사용시 체력이 10이하로 찹니다. 사용하시겠습니까? (y/n)");
                                char YorN = sc.next().charAt(0);
                                if (YorN == 'n' || YorN == 'N') {
                                    break;
                                }
                            }
                            this.LowerPotion--;
                            player.plusHP(potionHeal[0]);
                            break;
                        } else {
                            System.out.println("소형 포션이 부족합니다.");
                            break;
                        }
                    } else if (select == 2) {
                        if (this.MiddlePotion > 0) {
                            if (player.testPlusHP()) {
                                System.out.println("포션 사용시 체력이 10이하로 찹니다. 사용하시겠습니까? (y/n)");
                                char YorN = sc.next().charAt(0);
                                if (YorN == 'n' || YorN == 'N') {
                                    break;
                                }
                            }
                            this.MiddlePotion--;
                            player.plusHP(potionHeal[1]);
                            break;
                        } else {
                            System.out.println("중형 포션이 부족합니다.");
                            break;
                        }
                    } else if (select == 3) {
                        if (this.HighPotion > 0) {
                            if (player.testPlusHP()) {
                                System.out.println("포션 사용시 체력이 10이하로 찹니다. 사용하시겠습니까? (y/n)");
                                char YorN = sc.next().charAt(0);
                                if (YorN == 'n' || YorN == 'N') {
                                    break;
                                }
                            }
                            this.HighPotion--;
                            player.plusHP(potionHeal[2]);
                            break;
                        } else {
                            System.out.println("대형 포션이 부족합니다.");
                            break;
                        }
                    } else if (select == 4) {
                        if (this.vaccine > 0) {
                            this.vaccine--;
                            player.minusInfectiousness(5.0);
                            if (player.getInfectiousness() < 0) {
                                player.setInfectiousness(0);
                            }
                            break;
                        } else {
                            System.out.println("백신이 부족합니다.");
                            break;
                        }
                    }
                } else {
                    System.out.println("포션 사용시 체력이 똑같습니다.");
                    break;
                }
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
            }
        }
    }


    public void plusLowerPotion(int EA) {
        this.LowerPotion += EA;
    }

    public void plusMiddlePotion(int EA) {
        this.MiddlePotion += EA;
    }

    public void plusHighPotion(int EA) {
        this.HighPotion += EA;
    }

    public void plusVaccine(int EA) {
        this.vaccine += EA;
    }

    public boolean allPotion() {
        this.allPotion = this.LowerPotion + this.MiddlePotion + this.HighPotion + this.vaccine;
        return this.allPotion > 0;
    }
    public boolean canPotion(Player player) {
        if (player.getMaxHP() == player.getHP()) {
            System.out.println("이미 최대 체력입니다.");
            return false;
        }
        return true;
    }

    // 공백 추가
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
