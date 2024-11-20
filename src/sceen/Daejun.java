package sceen;

// 대전 도시의 씬 생성

import setting.Inventory;
import setting.Player;

public class Daejun {
    public static void daejun(Player player, Inventory inventory) {
        FightSceen.fightSceen(5, player, inventory);
    }
}
