package Zombie;

import setting.ZombieDefault;

public class InfecteZombie extends ZombieDefault { // 좀비를 상속받아서 감염된 좀비 생성
    public InfecteZombie() { // 감염된 좀비 기본 세팅
        super.DAMAGE = 5000;
        super.HP = 3000;
        super.MONEY = 500;
        super.Infectiousness = 2.8;
    }

}
