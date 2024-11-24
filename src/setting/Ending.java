package setting;

import ending.*;

public class Ending {
    public static void ending(Player player) {
        if (player.getMaxHP() >= 5000) { // 독재 엔딩
            DictatorshipEnding.dictatorshipEnding();
        } else if (player.getDAMAGE() >= 2500) { // 군사 정권 엔딩
            MilitaryRegimeEnding.militaryRegimeEnding();
        } else if (player.getMoney() >= 50000) { // 자본주의 엔딩
            CapitalismEnding.capitalismEnding();
        } else if (player.getRating() <= 70.0) { // 무정부 엔딩
            AnarchyEnding.anarchyEnding();
        } else { // 기본 엔딩
            DemocracyEnding.democracyEnding();
        }
    }
}
