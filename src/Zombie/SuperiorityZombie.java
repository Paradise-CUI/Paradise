package Zombie;

import setting.ZombieDefault;

public class SuperiorityZombie extends ZombieDefault { // 좀비를 상속받아서 상급 좀비 생성
    public SuperiorityZombie() { // 상급 좀비 기본 세팅
        super.DAMAGE = 300;
        super.HP = 1000;
        super.MONEY = 200;
        super.Infectiousness = 1.5;
    }
}
