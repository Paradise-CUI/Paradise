package Shop;

import setting.Player;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class WeaponShop {
    static Scanner sc = new Scanner(System.in);
    static String[] weapon = {"도끼", "후라이팬", "대검", "쇠뇌", "권총", "샷건", "소총", "저격총"};
    static boolean[] haveWeapon = {false, false, false, false, false, false, false, false};
    // 가격
    static int[] price = {200, 500, 1000, 4000, 7000, 9000, 12000, 15000};
    // 공격력
    static double[] damage = {20.0, 30.0, 60.0, 100.0, 300.0, 700.0, 800.0, 1000.0};

    public static void weapon(Player player) {
        int select = 0;
        int get = -1;
        boolean Break = false;
        while (true) {
            print();
            try {
                select = sc.nextInt();
            } catch (Exception e) {
                System.out.println("잘못된 입력입니다. 정수만 입력해주세요.");
                sc.nextLine();
            }

            for (int i = 0; i < weapon.length; i++) {
                if (weapon[i].equals(weapon[select - 1])) {
                    get = i;
                }
                for (int j = 0; j < get; j++) {
                    if (!haveWeapon[j]) {
                        System.out.println("이전 무기를 구매해주세요.");
                        sec1();
                        Break = true;
                        break;
                    }
                }
                if (Break) {
                    break;
                }
            }

            if (Break) {
                break;
            }

            if (select == 1) {
                if (! (haveWeapon[select - 1])) {
                    if (haveMoney(player, select)) {
                        player.minusMoney(price[select - 1]);
                        player.setWeapon(weapon[select - 1]);
                        player.plusDamage(damage[select - 1]);
                        haveWeapon[select - 1] = true;
                        System.out.println("                        도끼를 구매하셨습니다.");
                        try {
                            String Axe = new String(Files.readAllBytes(Paths.get("Art/Weapon/Axe.txt")));
                            System.out.println(Axe); // 파일 내용 출력
                        } catch (IOException e) {
                            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                        }
                        miniblank();
                        sec2();
                        break;
                    } else {
                        System.out.println("돈이 부족합니다.");
                        sec1();
                        break;
                    }
                } else {
                    System.out.println("이미 구매한 무기입니다.");
                    sec1();
                    break;
                }
            } else if (select == 2) {
                if (! (haveWeapon[select - 1])) {
                    if (haveMoney(player, select)) {
                        player.minusMoney(price[select - 1]);
                        player.setWeapon(weapon[select - 1]);
                        player.plusDamage(damage[select - 1]);
                        haveWeapon[select - 1] = true;
                        System.out.println("                 후라이팬을 구매하셨습니다.");
                        try {
                            String Pan = new String(Files.readAllBytes(Paths.get("Art/Weapon/Pan.txt")));
                            System.out.println(Pan); // 파일 내용 출력
                        } catch (IOException e) {
                            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                        }
                        miniblank();
                        sec2();
                        break;
                    } else {
                        System.out.println("돈이 부족합니다.");
                        sec1();
                        break;
                    }
                } else {
                    System.out.println("이미 구매한 무기입니다.");
                    sec1();
                    break;
                }
            } else if (select == 3) {
                if (! (haveWeapon[select - 1])) {
                    if (haveMoney(player, select)) {
                        player.minusMoney(price[select - 1]);
                        player.setWeapon(weapon[select - 1]);
                        player.plusDamage(damage[select - 1]);
                        haveWeapon[select - 1] = true;
                        System.out.println("             대검을 구매하셨습니다.");
                        try {
                            String Sword = new String(Files.readAllBytes(Paths.get("Art/Weapon/Sword.txt")));
                            System.out.println(Sword); // 파일 내용 출력
                        } catch (IOException e) {
                            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                        }
                        sec2();
                        break;
                    } else {
                        System.out.println("돈이 부족합니다.");
                        sec1();
                        break;
                    }
                } else {
                    System.out.println("이미 구매한 무기입니다.");
                    sec1();
                    break;
                }
            } else if (select == 4) {
                if (! (haveWeapon[select - 1])) {
                    if (haveMoney(player, select)) {
                        player.minusMoney(price[select - 1]);
                        player.setWeapon(weapon[select - 1]);
                        player.plusDamage(damage[select - 1]);
                        haveWeapon[select - 1] = true;
                        System.out.println("                   쇠뇌를 구매하셨습니다.");
                        try {
                            String Crossbow = new String(Files.readAllBytes(Paths.get("Art/Weapon/Crossbow.txt")));
                            System.out.println(Crossbow); // 파일 내용 출력
                        } catch (IOException e) {
                            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                        }
                        blank();
                        sec2();
                        break;
                    } else {
                        System.out.println("돈이 부족합니다.");
                        sec1();
                        break;
                    }
                } else {
                    System.out.println("이미 구매한 무기입니다.");
                    sec1();
                    break;
                }
            } else if (select == 5) {
                if (! (haveWeapon[select - 1])) {
                    if (haveMoney(player, select)) {
                        player.minusMoney(price[select - 1]);
                        player.setWeapon(weapon[select - 1]);
                        player.plusDamage(damage[select - 1]);
                        haveWeapon[select - 1] = true;
                        System.out.println("                    권총을 구매하셨습니다.");
                        try {
                            String Pistol = new String(Files.readAllBytes(Paths.get("Art/Weapon/Pistol.txt")));
                            System.out.println(Pistol); // 파일 내용 출력
                        } catch (IOException e) {
                            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                        }
                        blank();
                        sec2();
                        break;
                    } else {
                        System.out.println("돈이 부족합니다.");
                        sec1();
                        break;
                    }
                } else {
                    System.out.println("이미 구매한 무기입니다.");
                    sec1();
                    break;
                }
            } else if (select == 6) {
                if (! (haveWeapon[select - 1])) {
                    if (haveMoney(player, select)) {
                        player.minusMoney(price[select - 1]);
                        player.setWeapon(weapon[select - 1]);
                        player.plusDamage(damage[select - 1]);
                        haveWeapon[select - 1] = true;
                        System.out.println("                    샷건을 구매하셨습니다.");
                        try {
                            String Shotgun = new String(Files.readAllBytes(Paths.get("Art/Weapon/Shotgun.txt")));
                            System.out.println(Shotgun); // 파일 내용 출력
                        } catch (IOException e) {
                            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                        }
                        miniblank();
                        sec2();
                        break;
                    } else {
                        System.out.println("돈이 부족합니다.");
                        sec1();
                        break;
                    }
                } else {
                    System.out.println("이미 구매한 무기입니다.");
                    sec1();
                    break;
                }
            } else if (select == 7) {
                if (! (haveWeapon[select - 1])) {
                    if (haveMoney(player, select)) {
                        player.minusMoney(price[select - 1]);
                        player.setWeapon(weapon[select - 1]);
                        player.plusDamage(damage[select - 1]);
                        haveWeapon[select - 1] = true;
                        System.out.println("                     소총을 구매하셨습니다.");
                        try {
                            String Gun = new String(Files.readAllBytes(Paths.get("Art/Weapon/Gun.txt")));
                            System.out.println(Gun); // 파일 내용 출력
                        } catch (IOException e) {
                            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                        }
                        miniblank();
                        sec2();
                        break;
                    } else {
                        System.out.println("돈이 부족합니다.");
                        sec1();
                        break;
                    }
                } else {
                    System.out.println("이미 구매한 무기입니다.");
                    sec1();
                    break;
                }
            } else if (select == 8) {
                if (! (haveWeapon[select - 1])) {
                    if (haveMoney(player, select)) {
                        player.minusMoney(price[select - 1]);
                        player.setWeapon(weapon[select - 1]);
                        player.plusDamage(damage[select - 1]);
                        haveWeapon[select - 1] = true;
                        System.out.println("                  저격총을 구매하셨습니다.");
                        try {
                            String Sniper = new String(Files.readAllBytes(Paths.get("Art/Weapon/Sniper.txt")));
                            System.out.println(Sniper); // 파일 내용 출력
                        } catch (IOException e) {
                            System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                        }
                        miniblank();
                        sec2();
                        break;
                    } else {
                        System.out.println("돈이 부족합니다.");
                        sec1();
                        break;
                    }
                } else {
                    System.out.println("이미 구매한 무기입니다.");
                    sec1();
                    break;
                }
            } else if (select == 0) {
                System.out.println("상점을 종료합니다.");
                sec1();
                break;
            } else {
                System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                sec1();
                nextText();
            }
        }
    }

    public static void print() {
        System.out.println("                            1. 도끼 (가격 : 200)");
        System.out.println("                            2. 후라이팬 (가격 : 500)");
        System.out.println("                            3. 대검 (가격 : 1000)");
        System.out.println("                            4. 쇠뇌 (가격 : 4000)");
        System.out.println("                            5. 권총 (가격 : 7000)");
        System.out.println("                            6. 샷건 (가격 : 9000)");
        System.out.println("                            7. 소총 (가격 : 12000)");
        System.out.println("                            8. 저격총 (가격 : 15000)");
        System.out.println("                            0. 상점 종료");
        blank();
    }

    public static boolean haveMoney(Player player, int select) {
        if (player.getMoney() >= price[select - 1]) {
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

    private static void miniblank() {
        for (int i = 0; i < 7; i++) {
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
            Thread.sleep(900);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
