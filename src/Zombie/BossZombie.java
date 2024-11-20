package Zombie;

import setting.ZombieDefault;

public class BossZombie extends ZombieDefault { // 좀비를 상속받아서 보스 좀비 생성
    public BossZombie() { // 보스 좀비 기본 세팅
        super.DAMAGE = 1000;
        super.HP = 100000;
        super.MONEY = 10000;
    }
}
