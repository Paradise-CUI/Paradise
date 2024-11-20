package Zombie;

import setting.ZombieDefault;

public class LowZombie extends ZombieDefault { // 좀비를 상속받아서 하급 좀비 생성
    public LowZombie() { // 하급 좀비 기본 세팅
        super.DAMAGE = 20;
        super.HP = 100;
        super.MONEY = 50;
    }
}
