package sceen;

// 좀비와 인간의 싸우는 씬 생성

import Zombie.*;
import ending.*;
import setting.Inventory;
import setting.Player;
import setting.ZombieDefault;

/*
* while로 죽을떄 까지 딜 주고 받기
*
*
* */

public class FightSceen {
    public static void fightSceen(int level, Player player, Inventory inventory) {

        ZombieDefault zombie = null;

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
        while (!(zombie.getHP() <= 0 || player.getHP() <= 0)) { // 좀비의 피가 0이 되거나 사람이 피가 0이 될떄까지
            if (attack == 6) { // 특수공격 사용으로 인한 attack 초기화 (5번 마다)
                attack = 1;
            }
            if (player.getSpecialAttack()) {
                System.out.println("턴 : " + attack); // 턴 출력
            }
            System.out.println("좀비 HP : " + zombie.getHP()); // 좀비 HP 출력
            System.out.println("플레이어 HP : " + player.getHP()); // 플레이어 HP 출력
            System.out.print(
                    "\n" +
                            "                                                                     ⠀⠀⠀⢀⠔⢂⣉⣠⣴⡗⡀⠀⠀⠀⠀⠀⠀⠀⢀⢾⣧⣦⣈⡁⠢⠀⠀⠀⠀\n" +
                            "                                                                     ⠀⠀⣿⣾⣿⣿⣿⣿⣻⣼⣶⣶⣶⣶⣶⣶⣶⣧⣜⡿⣿⣿⣿⣿⣶⠀⠀⠀\n" +
                            "                                                                     ⠀⠀⣽⢿⣿⣯⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣿⣯⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⢀⡆⠀⠀⠀⣀⡀⣀⣀⣰⣋⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀ ⠀⠀ ⠀⠀⣽⣾⢿⣿⡿⠛⣿⣿⡿⠻⣿⣿⣿⠛⢿⣿⣿⠟⣿⣿⡿⣷⣯⡀⠀⠀\n" +
                            "⠀⠀⠀⢠⡀⠀⠀⡨⡖⠃⠉⠀⠀⠀⠀⠀⠀⠀⠈⠉⠓⠦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                     ⢀⠎⡿⡃⢘⠟⠁⢘⠌⠋⠀⠀⠈⠛⠁⠀⠈⠙⠃⠀⠈⠛⠃⠈⢻⠱⡀⠀\n" +
                            "⠀⠀⠀⠀⠈⡷⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢯⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                     ⠀⠀⠀⠀⡼⠐⠊⠀⠀⠀⠀⠰⣪⣄⢄⡀⠀⠀⠀⠀⢀⣠⣤⠀⠀⠀⠀⠀⠀⠀⢰⠀\n" +
                            "⠀⠀⠀⠀⡰⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                     ⠀⠀⠀⠀⠀⠀⠀⠰⠀⠀⠠⠀⠢⠬⠦⣾⣿⣿⠦⠥⡦⠤⢤⠤⠴⣿⣿⡶⠤⠤⠄⠀⠀⠀⠀⠆\n" +
                            "⠀⠀⠀⠀⡇⠀⠆⠀⡠⠒⠋⠓⠢⡄⠀⠀⠀⢀⣀⣀⣀⠀⡸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                     ⠀⠀⠀⠀⡆⠀⠠⠊⠋⠀⠐⠐⢎⠿⠟⠀⠀⠀⠀⠀⠀⠀⠻⡿⠁⠀⠀⠀⠀⠀⠀⠀⠐\n" +
                            "⠀⠀⠀⠀⢇⠀⠇⠀⡇⠀⢀⠀⠀⠈⡆⠀⢠⠏⠀⠀⠀⠉⢞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                     ⠀⠀⠀⠁⠀⠀⠃⠀⡀⠀⢈⡐⣃⡄⠄⠂⠀⠀⠀⠐⠢⢄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠘⡄⠀⠀⢇⡀⠉⠀⠀⢸⠀⠀⢸⡀⠀⠀⠀⠁⡼⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                     ⠀⠀⠀⠀⡀⠀⠂⠁⠈⠂⠌⠀⠈⡇⠀⠀⣤⠀⠀⠀⣀⡀⠀⠡⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠘⣆⠀⠀⠙⠒⠒⠋⠀⠀⠀⡀⠫⠤⠤⢴⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                     ⠀⠀⠀⠀ ⢣⢜⢕⣳⡔⢨⠄⢀⠀⠀⠀⣾⣿⠇⠀⠀⣿⣷⠀⠀⠀⠀⠀⠀⣤⣦⣀⠀⡜\n" +
                            "⠀⠀⠀⠀⠀⠰⣇⡀⠀⠀⠀⠀⠀⠀⠐⠃⠈⠃⠀⠀⢀⣸⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                     ⠀⠀⠀⠀⠫⣯⣼⣏⣑⢺⢇⠂⠄⠀⠛⠛⠀⠀⠀⠙⠛⠀⢠⠀⠀⠀⢐⣹⢏⢞⠔⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⡇⠀⡤⢖⠒⠋⡇⠉⠉⠉⡝⠉⢱⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⠀⠀⠀⠀⠀⠀                     ⠀⠀⠀⠀⠀⠀⠈⠸⡹⣞⣟⡾⣯⢌⠦⣀⠀⠀⠀⠀⠀⣀⠴⣁⢡⢄⢈⣹⢟⠦⠋⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⡇⢸⡁⠙⠒⠒⣃⣠⠤⡄⠉⠉⠁⠀⠀⠀⠀⡴⠚⠉⢦⡔⠁⠀⠈⡇⣀⠄⠒⢦⡀⠀⠀                     ⠀⠀⠀⠀⠀⠈⠑⠉⡷⠞⣚⠿⠿⠾⠷⠶⠷⠾⠷⢶⣚⠛⢺⠙⠒⠁⠀⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⡇⠀⠙⠦⠤⠤⠼⠤⠼⠤⠤⠤⠤⡤⢀⠔⠦⡇⠀⣀⣘⣁⣀⣀⣘⠃⠀⠀⠀⡣⣀⡤⣄                     ⠀⠀ ⠀⠀⠀⠀⠀⡠⣨⣈⠈⠂⠡⠤⠯⠯⠤⠽⠶⠤⠌⠑⠀⢁⠀⢂⠀⠀⠀\n" +
                            "⠀⠀⠀⠀⠀⠀⠀⡨⢽⠳⠶⣒⠢⠤⠤⠤⢄⣀⣀⡼⠀⣫⡀⣀⠞⠁⣀⠀⠀⠀⠀⠀⠀⠉⠑⠦⡁⠀⠀⢱⠀                     ⠀  ⠀⠀⠀⠀⢌⣴⣿⡟⡠⣄⣴⣶⣶⣶⠄⠀⠀⡀⠀⠀⠀⠀⠀⠀⠡⡀⠀⠀⠀\n" +
                            "⠀⠀⠀⢀⠤⠒⠁⠀⠰⣉⢉⠒⠠⣍⡛⡆⠀⠀⠀⠀⡏⠁⣰⠃⠀⠀⣿⠀⠀⠀⠀⢰⡇⠀⠀⠀⠈⡇⣴⣃⡀⠀    __   _____       ⠀⠀⢀⣢⣾⣿⣿⠠⣿⣿⣿⠿⠛⠁⠀⠀⠀⣏⡉⠀⠀⠀⢇⠀⠀⢐⠄⠀⠀\n" +
                            "⠀⡠⠞⠁⠀⠀⠀⠀⠀⠀⡇⢄⠉⢩⠍⠁⠉⠒⣄⠀⠣⣤⡇⠀⡀⠀⠉⠀⠀⠀⠀⠀⠃⢰⠃⠀⠀⢸⠀⠀⠈⢇    \\ \\ / / __|      ⡠⠁⠈⠻⢿⠋⠜⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠁⠀⠀⠘⡦⠔⠀⠈⢆⠀\n" +
                            "⠀⡠⠞⠁⠀⠀⠀⠀⠀⠀⡇⢄⠉⢩⠍⠁⠉⠒⣄⠀⠣⣤⡇⠀⡀⠀⠉⠀⠀⠀⠀⠀⠃⢰⠃⠀⠀⢸⠀⠀⠈⢇     \\ V /\\__ \\      ⠣⡈⢈⠔⢺⠀⠼⣄⣄⣀⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣕⠲⡋⢐⠜\n" +
                            "⠘⢒⠀⠀⠀⠀⠀⠀⠀⠀⡏⠓⣜⢾⠀⢰⠀⠀⠀⡜⠀⡏⠀⡇⠀⠳⡄⠀⠀⠀⠀⠀⠀⠀⣨⠋⠁⠀⡇⣤⡤⠚      \\_/ |___/      ⠀⠀⠀⠁⡍⣉⡓⠓⠚⠂⠀⠤⠤⠀⠤⠄⠀⠀⠀⠐⠒⣀⠩⠜⠀⠀⠀⠀\n" +
                            "⠀⠀⠃⠀⠀⠇⠀⠀⠀⠀⡗⢄⠀⣇⠀⠀⡇⠀⠀⡇⠀⠳⣄⢼⣶⡀⠀⠉⠒⠒⠒⠊⠉⠁⠀⠀⢠⡏⠀⠀⠙⡄                     ⠀⠀⠀⠀⢹⢽⡯⠻⢋⣭⣴⢔⢒⣖⡐⠀⡂⡈⠉⠋⠉⢡⣝⢀⠄⡀⠀⠀\n" +
                            "⠀⢐⠀⠀⠀⡷⠁⠀⠀⠀⡏⠑⠊⡟⡄⠀⢇⠀⠀⡅⠀⠀⠀⣇⠀⠈⢉⡒⠒⠦⠤⠤⠒⢾⡅⠀⠈⡟⠲⠔⠁⠀                     ⠀⠀⠀⠀⠀⠹⡳⡟⡜⢾⡴⣘⢷⢬⠹⠗⡾⠐⠺⠀⡠⠬⣾⠾⢻⠆⠀⠀\n" +
                            "⠀⢸⠀⠀⠀⡇⠀⠀⠀⢀⠗⠠⡀⠀⢣⠀⠀⣇⠀⢸⠀⠀⠀⠀⠑⠒⠋⠳⣀⣀⠟⣄⣀⡴⠋⠙⠛⠓⠋⠀⠀                     ⠀⠀⠀⠀⠀⠀⠀⢓⠼⣿⣾⣚⠂⠹⠓⠆⡤⣴⠖⠀⠀⠻⠉⠈⠻⢵⣤⣀⡤\n" +
                            "⠀⢸⠀⠀⠀⡇⠀⠀⠀⢸⡐⠆⡀⠑⠢⣳⠀⢱⠀⠘⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⡀⢑⠀⠀⠀⠀⠀                     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⢉⢛⢯⢾⠡⡇⠀⢰⢙⡍⡡⠀⠘⠇⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⢸⠀⠀⠀⡇⠀⠀⠀⠀⠈⢦⠀⠈⢢⠃⠀⠀⢱⠀⢸⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡎⠀⡇⠀⠀⠀⠀⠀                     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡦⡛⠈⠀⢪⠇⠀⠘⣸⠏⠆⠐⢳⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "⠀⢸⠀⠀⠀⢳⠀⠀⠀⠀⠀⠀⠈⢆⡎⠀⠀⠀⠀⢳⠀⢿⠀⠀⠀⠀⠀⠀⠀⠀⠀⣰⠃⢸⠀⠀⠀⠀⠀⠀                     ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡉⣓⢉⡡⠀⠀⠀⢌⠉⣴⣉⡈⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                            "                                                                                                      \n" +
                            "⠀                                                                                                     \n");
//            switch (level) {
//                case 6:
//                    System.out.println("하급 좀비와 싸우는 중");
//                    break;
//                case 5:
//                case 4:
//                    System.out.println("중급 좀비와 싸우는 중");
//                    break;
//                case 3:
//                    System.out.println("상급 좀비와 싸우는 중");
//                    break;
//                case 2:
//                    System.out.println("감염 좀비와 싸우는 중");
//                    break;
//                case 1:
//                    System.out.println("보스 좀비와 싸우는 중");
//                    break;
//            } // switch close

            player.minusHP(zombie.getDAMAGE()); // 좀비가 플레이어에게 데미지를 줌

            if (player.getSpecialAttack() && attack == 5) { // 특수공격이 활성화가 되어있고 공격의 5번이 되었다면
                zombie.minusHP((player.getDAMAGE() * 3)); // 특수공격이 활성화가 되어있다면 3배의 데미지를 줌
            } else {
                zombie.minusHP(player.getDAMAGE()); // 플레이어가 좀비에게 데미지를 줌
            }

            if (player.getHP() <= 0) { // 플레이어가 죽었을 때
                DieEnding.dieending(); // 다이 엔딩 띄우기
            }
            if (zombie.getHP() <= 0) { // 좀비가 죽었을 때
                System.out.println("정상적으로 좀비가 죽었습니다.");
                if (zombie.dropPotion() == 5) {
                    System.out.println("하급 포션을 획득하였습니다.");
                    inventory.plusLowerPotion(1);
                }
                player.plusKill(1); // 플레이어의 킬 증가
                System.out.println("킬이 증가하였습니다" + player.getKill() + "킬");
                player.plusMoney(zombie.getMONEY()); // 좀비의 돈만큼 플레이어의 돈 추가
                System.out.println("돈이 증가하였습니다." + zombie.getMONEY() + "원");
                System.out.println(player.getKill() + "킬");
                System.out.println(player.getMoney() + "원");
            }
            sec2();
            nextText();
            attack++; // 턴 추가
        } // while close


    }


    // 다음 텍스트 전환 (스크롤)
    private static void nextText() {
        for (int i = 0; i < 100; i++) {
            System.out.println ();
        }
    }

    // 2초 대기
    private static void sec2() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
