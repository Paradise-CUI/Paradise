package sceen;

public class StartSceen {
    public static void startSceen() {
        // 창 크기 설정 메시지
        System.out.println("============================================================");
        System.out.println("  콘솔 창 크기를 설정하세요: 가로 너비를 충분히 넓게 조정한 후");
        System.out.println("  엔터를 눌러 게임을 시작하세요. ");
        System.out.println("============================================================");

        // 엔터 입력 대기
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 게임 시작 메시지들
        nextText ();
        System.out.println ("                            당신은 2099년에 살아가고 있는 밀리터리 덕후 일반인입니다                ");
        blank ();
        sec3 ();
        nextText ();

        System.out.println ("                2100년이 되자 지구는 멸망의 길로 들어서 좀비라는 새로운 종족이 나타나 사람을 좀비로 만들고 있습니다                ");
        blank ();
        sec3 ();
        nextText ();

        System.out.println ("                     이제는 당신이 대한민국의 희망입니다 좀비로부터 대한민국을 지키고 대한민국의 대통령이 되세요               ");
        blank ();
        sec3 ();
        nextText ();

        System.out.println ("                                               행운을 빕니다               ");
        blank ();
        sec3 ();
        nextText ();

        System.out.print (
                "                            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                            ⠀⠀⠀⠀⠀⠀⠀⠀⠠⣀⡀⠀⠀⠀⠀⠀⢀⣜⠉⣏⠀⠀⠀⠀⠀⠀⠀⢀⣴⠃\n" +
                "                            ⠀⠀⠀⠀⠀⠀⠀⠀⠚⡬⠧⠀⠀⠀⠀⠀⠀⠈⠎⠉⠀⠀⠀⠀⠀⣠⢶⡿⠃⠀\n" +
                "                            ⠀⠀⠀⠀⠀⣄⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⡒⢕⢕⠕⠁⠀⠀\n" +
                "                            ⠀⠀⠀⠀⠀⡇⠙⢦⡀⠀⢀⣀⠤⡴⠀⠀⢀⡀⠤⢒⡨⠐⡉⠔⡡⠂⠀⠀⠀⠀\n" +
                "                            ⠀⠀⠀⠀⠀⠃⠀⠀⠈⠉⠁⠀⢰⠃⢀⡉⠤⠐⠈⡁⠔⢊⠔⠈⠀⠀⠀⠀⠀⠀\n" +
                "                            ⠀⠀⢀⡤⠚⠁⠀⠀⠀⠀⠀⢀⠏⠁⣀⠠⠔⠂⢁⠠⠂⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                            ⠠⢶⣁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠻⡁⠀⡀⠄⠂⠁⠀⠀⠀⠀⡀⢀⠀⠀⠀⠀⠀\n" +
                "                            ⠀⠀⠀⠉⠑⢲⠀⠀⠀⢀⣀⣀⣀⡙⣅⠀⠀⠀⠀⠀⠀⠠⠔⡈⣫⡀⠀⠀⠀⠀\n" +
                "                            ⠀⠀⠀⠀⠀⠘⡆⠀⡰⠋⠀⠀⠀⠀⠈⠀⠀⠀⠀⠀⠀⠀⠀⠏⠀⠀⠀⠀⠀⠀\n" +
                "                            ⠀⢠⡀⣀⠀⠀⢣⠜⠁⠀⠀⠀⠀⠀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "                            ⠠⢮⢀⣢⡀⠀⠈⠀⠀⠀⠀⠀⠀⢀⠏⠒⢺⠃⠀⠀⠀⠀⠀⠀⠀⠀⢠⣀⡀⠀\n" +
                "                            ⠀⠀⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⠃⡄⢠⢈⣆⠀⠀⠀⠀⠀⠀⠀⠐⠻⡼⠆⠀\n" +
                "                            ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠸⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n");

        blank ();
        sec08 ();
        nextText ();

    }


    // 공백 추가
    private static void blank() {
        for (int i = 0; i < 15; i++) {
            System.out.println ();
        }
    }

    // 다음 텍스트 전환 (스크롤)
    private static void nextText() {
        for (int i = 0; i < 100; i++) {
            System.out.println ();
        }
    }

    // 3초 대기
    private static void sec3() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 0.8초 대기
    private static void sec08() {
        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
