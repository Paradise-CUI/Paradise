package Zombie;

import setting.ZombieDefault;

public class IntermediateZombie extends ZombieDefault { // 좀비를 상속받아서 중급 좀비 생성
    public IntermediateZombie() { // 중급 좀비 기본 세팅
        super.DAMAGE = 70;
        super.HP = 300;
        super.MONEY = 100;
        super.Infectiousness = 1.0;
    }
}
