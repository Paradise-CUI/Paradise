import Shop.WeaponShop;
import sceen.*;
import setting.Player;


public class Main {
    public static void main(String[] args) {
//        StartSceen.startSceen(); // 시작화면 씬 철력
//        MainMenu.mainmenu(); // 메인화면의 메인메뉴 출력
//        Sceen.sceen(); // 게임하는 전체 씬 출력

        Player player = new Player();
        player.plusMoney(1000000000);
        while (true) {
            WeaponShop.weapon(player);
        }

    }
}
