package setting;

import org.w3c.dom.ls.LSOutput;

public class ZombieDefault {
    protected int DAMAGE;
    protected double HP;
    protected int MONEY;
    protected double Infectiousness;

    // 빼기
    public void minusHP(double HP) {
        this.HP -= HP;
    }


    // 불러오기
    public int getDAMAGE() {
        return this.DAMAGE;
    }

    public double getHP() {
        return this.HP;
    }

    public int getMONEY() {
        return this.MONEY;
    }

    public int dropPotion() {
        return (int) (Math.floor((Math.random() * 10)));
    }

    public double getINFECTIOUSNESS() {
        return this.Infectiousness;
    }


}
