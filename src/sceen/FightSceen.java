package sceen;

// 좀비와 인간의 싸우는 씬 생성

import Zombie.*;
import ending.*;
import setting.Ending;
import setting.Inventory;
import setting.Player;
import setting.ZombieDefault;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/*
 * while로 죽을떄 까지 딜 주고 받기
 *
 *
 * */

public class FightSceen {
    public static boolean Exit = false;

    public static void fightSceen(int level, Player player, Inventory inventory) {
        Scanner sc = new java.util.Scanner(System.in);
        ZombieDefault zombie = null;
        Exit = false;

        switch (level) { // zombie 객체 생성을 위한 switch 문
            case 6:
                zombie = new LowZombie();
//                System.out.println("중급 좀비생성 완료"); // 디버깅
                break;
            case 5:
            case 4:
                zombie = new IntermediateZombie();
//                System.out.println("중급 좀비생성 완료");
                break;
            case 3:
                zombie = new SuperiorityZombie();
//                System.out.println("중급 좀비생성 완료"); // 디버깅
                break;
            case 2:
                zombie = new InfecteZombie();
//                System.out.println("감염 좀비 생성 완료"); // 디버깅
                break;
            case 1:
                zombie = new BossZombie();
//                System.out.println("보스 좀비 생성 완료"); // 디버깅
                break;
        } // switch close


        int attack = 1; // 특수공격 사용을 위한 몇번의 공격을 했는지 확인
        while (! (zombie.getHP() <= 0 || player.getHP() <= 0)) { // 좀비의 피가 0이 되거나 사람이 피가 0이 될떄까지
            if (player.getSpecialAttack()) {
                System.out.println("턴 : " + attack); // 턴 출력
            }

            System.out.println("플레이어 HP : " + player.getHP() + "       좀비 HP : " + zombie.getHP() + "          감염율 : " + player.getInfectiousness()); // 플레이어 HP 출력 및 좀비 HP 출력

            switch (level) { // 좀비의 레벨에 따른 출력
                case 6:
                    try {
                        String LowZombie = new String(Files.readAllBytes(Paths.get("Art/Zombie/LowZombie.txt")));
                        System.out.println(LowZombie); // 파일 내용 출력
                    } catch (IOException e) {
                        System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                    }
                    break;
                case 5:
                case 4:
                    try {
                        String IntermediateZombie = new String(Files.readAllBytes(Paths.get("Art/Zombie/IntermediateZombie.txt")));
                        System.out.println(IntermediateZombie); // 파일 내용 출력
                    } catch (IOException e) {
                        System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        String SuperiorityZombie = new String(Files.readAllBytes(Paths.get("Art/Zombie/SuperiorityZombie.txt")));
                        System.out.println(SuperiorityZombie); // 파일 내용 출력
                    } catch (IOException e) {
                        System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        String InfecteZombie = new String(Files.readAllBytes(Paths.get("Art/Zombie/InfecteZombie.txt")));
                        System.out.println(InfecteZombie); // 파일 내용 출력
                    } catch (IOException e) {
                        System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                    }
                    break;
                case 1:
                    try {
                        String BossZombie = new String(Files.readAllBytes(Paths.get("Art/Zombie/BossZombie.txt")));
                        System.out.println(BossZombie); // 파일 내용 출력
                    } catch (IOException e) {
                        System.err.println("파일을 읽는 중 오류가 발생했습니다: " + e.getMessage());
                    }
                    break;
            } // switch close

            System.out.println("                       1. 공격 2. 포션사용 3. 도망가기");
            int select = 0;
            while (true) {
                try {
                    select = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("잘못된 입력입니다. 다시 입력해주세요.");
                    sc.nextLine();
                    continue;
                }
            }

            if (select == 1) { // 공격을 했을 때
                if (player.getSpecialAttack() && attack % 5 == 0) { // 특수공격이 활성화가 되어있고 공격의 5번이 되었다면
                    zombie.minusHP((int) ((player.getDAMAGE() + player.getWeaponDamage()) * 3)); // 특수공격이 활성화가 되어있다면 3배의 데미지를 줌
                    System.out.println("                  특수공격을 사용하였습니다.");
                    System.out.println("                      입힌 데미지 : " + (int) ((player.getDAMAGE() + player.getWeaponDamage()) * 3));
                    attack = 0;
                } else {
                    zombie.minusHP(player.getDAMAGE() + player.getWeaponDamage()); // 플레이어가 좀비에게 데미지를 줌
                    System.out.println("                      입힌 데미지 : " + (int) (player.getDAMAGE() + player.getWeaponDamage()));
                }
            } else if (select == 2) { // 포션을 사용했을 때
                if (inventory.allPotion()) { // 포션이 있다면
                    inventory.print(player); // 포션 출력
                    continue;
                } else {
                    System.out.println("포션이 없습니다.");
                }
            } else if (select == 3) { // 도망가기
                System.out.println("도망가기");
                player.setHP(1);
                Exit = true;
                break;

            } else {
                System.out.println("잘못된 입력입니다.");
                continue;
            }

            player.minusHP((zombie.getDAMAGE() / (int) player.getRating())); // 좀비가 플레이어에게 데미지를 줌
            System.out.println("                      받은 데미지 : " + (zombie.getDAMAGE() / ratingMinus(player)));
            player.plusInfectiousness(zombie.getINFECTIOUSNESS()); // 좀비가 플레이어에게 감염율을 줌


            // 죽거나 감염 엔딩
            if (player.getHP() <= 0) { // 플레이어가 죽었을 때
                SacrificeEnding.sacrificeEnding(); // 다이 엔딩 띄우기
            } else if (player.getInfectiousness() >= 100) { // 플레이어가 감염되었을 때
                InfecteEnding.infecteEnding(); // 감염 엔딩 띄우기
            }

            if (zombie.getHP() <= 0) { // 좀비가 죽었을 때
//                System.out.println("정상적으로 좀비가 죽었습니다.");
                if (zombie.dropPotion() == 3 || zombie.dropPotion() == 2 || zombie.dropPotion() == 1) { // 좀비가 포션을 드랍했을 때
                    System.out.println("              하급 포션을 획득하였습니다.");
                    inventory.plusLowerPotion(1);
                }
                player.plusKill(1); // 플레이어의 킬 증가
                System.out.println("           킬이 증가하였습니다" + player.getKill() + "킬");
                player.plusMoney(zombie.getMONEY()); // 좀비의 돈만큼 플레이어의 돈 추가
                System.out.println("          돈이 증가하였습니다." + zombie.getMONEY() + "원");
                System.out.println(player.getKill() + "킬");
                System.out.println(player.getMoney() + "원");
                player.plusRating(0.1);

                if (level == 1) {
                    Ending.ending(player);
                }

            }
            sec2();
            nextText();
            attack++; // 턴 추가
        } // while close


    }


    public static int ratingMinus(Player player) {
        if (player.getRating() >= 5.0) {
            return 5;
        } else {
            return (int)player.getRating();
        }
    }

        // 다음 텍스트 전환 (스크롤)
        private static void nextText () {
            for (int i = 0; i < 100; i++) {
                System.out.println();
            }
        }

        // 2초 대기
        private static void sec2 () {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
