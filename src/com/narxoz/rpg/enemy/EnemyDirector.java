package com.narxoz.rpg.enemy;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.builder.BossEnemyBuilder;
import com.narxoz.rpg.builder.EnemyBuilder;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {

    private EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createMinion() {
        if (!(builder instanceof BasicEnemyBuilder)) {
            throw new IllegalStateException("Builder must be BasicEnemyBuilder for minions!");
        }
        return builder
                .setName("Minion")
                .setHealth(50)
                .setDamage(10)
                .build();
    }


    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        if (!(builder instanceof BossEnemyBuilder)) {
            throw new IllegalStateException("Builder must be BossEnemyBuilder for raid bosses!");
        }
        return builder
                .setName("Raid Boss")
                .setHealth(100000)
                .setDamage(1000)
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .addPhase(1, 100000)
                .addPhase(2, 50000)
                .addPhase(3, 25000)
                .setAI(factory.createAIBehavior())
                .build();
    }
}