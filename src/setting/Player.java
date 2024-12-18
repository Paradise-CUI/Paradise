package setting;

public class Player {
    int kill; // 잡은 좀비
    int Money; // 소지금
    int maxHP; // 최대 체력
    int HP; // 체력
    double weaponDamage; // 무기 공격력
    double DAMAGE; // 공격력
    boolean SpecialAttack; // 특수 공격 사용 가능 여부
    double rating; // 지지율
    double Infectiousness; // 감염율
    String Weapon; // 무기


    public Player() { // 플레이어 기본 세팅
        this.kill = 0;
        this.Money = 400; // 400
        this.maxHP = 300;
        this.HP = 300;
        this.weaponDamage = 0.0;
        this.DAMAGE = 34.0;
        this.SpecialAttack = false;
        this.rating = 1.0;
        this.Infectiousness = 0.0;
        this.Weapon = "맨손";
    }

    // 현재 상태 출력
    public void print() {
        nextText();
        System.out.println("                             MONEY : " + this.Money);
        System.out.println("                           최대 채력 : " + this.maxHP);
        System.out.println("                                HP : " + this.HP);
        System.out.println("                            DAMEGE : " + (int)(this.DAMAGE + this.weaponDamage));
        System.out.println("                            WEAPON : " + this.Weapon);
        if (this.SpecialAttack) {
            System.out.println("                            특수 공격 사용 가능");
        }
        System.out.println("                              킬 수 : " + this.kill);
        System.out.println("                              지지율 : " + this.rating);
        System.out.println("                              감염율 : " + this.Infectiousness);

        blank();
        sec5();
        nextText();
    }

    // 플러스
    public void plusKill(int kill) { // 킬 횟수 증가
        this.kill += kill;
    }

    public void plusMoney(int Money) {
        this.Money += Money;
    }

    public void plusHP(int HP) {
        if (this.HP + HP > this.maxHP) {
            this.HP = this.maxHP;
        } else {
            this.HP += HP;
        }
    }


    public void plusDamage(double DAMAGE) {
        this.DAMAGE += DAMAGE;
    }

    public void plusRating(double rating) {
        this.rating += rating;
    }


    public void plusInfectiousness(double Infectiousness) {
        if (this.Infectiousness + Infectiousness > 100) {
            setInfectiousness(100);
        } else {
            this.Infectiousness += Infectiousness;
        }
    }

    public void plusMaxHP(int maxHP) {
        this.maxHP += maxHP;
    }

    public boolean testPlusHP() { // 체력 증가 테스트
        boolean result = false;
        for (int i = 1; i <= 10; i++) {
            if (getMaxHP() == (getHP() + i)) {
                result = true;
                break;
            }
        }
        return result;
    }


    // 마이너스
    public void minusHP(int HP) {
        this.HP -= HP;
    }

    public void minusMoney(int Money) {
        this.Money -= Money;
    }

    public void minusInfectiousness(double Infectiousness) {
        this.Infectiousness -= Infectiousness;
    }

    // 불러오기
    public int getHP() {
        return HP;
    }

    public double getDAMAGE() {
        return DAMAGE;
    }

    public boolean getSpecialAttack() {
        return this.SpecialAttack;
    }

    public int getKill() {
        return this.kill;
    }

    public int getMoney() {
        return this.Money;
    }

    public double getInfectiousness() {
        return this.Infectiousness;
    }

    public String getWeapon() {
        return this.Weapon;
    }

    public double getRating() {
        return this.rating;
    }

    public int getMaxHP() {
        return this.maxHP;
    }

    public double getWeaponDamage() {
        return this.weaponDamage;
    }

    // 설정
    public void setSpecialAttack(boolean SpecialAttack) {
        this.SpecialAttack = SpecialAttack;
    }

    public void setInfectiousness(double Infectiousness) {
        this.Infectiousness = Infectiousness;
    }

    public void setWeapon(String Weapon) {
        this.Weapon = Weapon;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setWeaponDamage(double weaponDamage) {
        this.weaponDamage = weaponDamage;
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

    // 5초 대기
    private static void sec5() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
