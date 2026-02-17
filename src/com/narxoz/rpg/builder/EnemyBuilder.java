package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;

public  interface EnemyBuilder {
    EnemyBuilder setName(String name);
    EnemyBuilder setHealth(int health);
    EnemyBuilder setDamage(int damage);
    EnemyBuilder setDefense(int defense);
    EnemyBuilder setSpeed(int speed);
    EnemyBuilder setElement(String element);

    EnemyBuilder addAbility(String ability);
    EnemyBuilder addPhase(int phaseNumber, int hpThreshold);

    Enemy build();

}
