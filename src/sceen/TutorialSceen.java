package sceen;

// 튜토리얼을 위한 씬 생성

public class TutorialSceen {
    public static void tutorial() {
        System.out.println("게임방법");
        System.out.println("당신의 목표는 대통령이 되는 것 입니다.");
        System.out.println("당신은 여러 지역 중 하나의 도시를 선택할 수 있습니다. (각 도시마다 몬스터 스폰이 다릅니다.)");
        System.out.println("서울 : 보스 좀비, 제주 : 감염 좀비, 광양 : 상급 좀비, 부산 : 중급 좀비, 대전 : 중급 좀비, 대구 : 하급 좀비");
        System.out.println("만약 서울을 선택하면 서울로 이동합니다.");
        System.out.println("서울에서는 보스 좀비와 전투를 할 수 있습니다.");
        System.out.println("전투에서는 ");
        System.out.println("각각 50, 100, 200, 500, 10000골드가 드랍됩니다.");
        System.out.println("코인으로 상점에서 포션과 무기 스텟이 구매 가능합니다.");
        System.out.println("포션은 체력을 회복하고 무기는 공격력을 올립니다.");
        System.out.println("각 도시에서는 1번의 전투가 가능합니다.");
        System.out.println("1번의 전투가 끝나면 메인화면으로 이동합니다.");
        sec10();
        System.out.println("게임을 시작합니다.");
        sec2();
    }

    // 10초 대기
    private static void sec10() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
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
