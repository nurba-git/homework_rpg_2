package com.narxoz.rpg;

import com.narxoz.rpg.builder.BasicEnemyBuilder;
import com.narxoz.rpg.enemy.*;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.prototype.EnemyRegistry;

public class Main {
    public static void main(String[] args) {


        EnemyComponentFactory fireFactory = new FireComponentFactory();

        DragonBoss fireDragon = new DragonBoss.Builder()
                .setName("Fire Dragon")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(200)
                .setSpeed(50)
                .setElement("FIRE")
                .setAbilities(fireFactory.createAbilities())
                .setLootTable(fireFactory.createLootTable())
                .setAI(fireFactory.createAIBehavior())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 10000)
                .setCanFly(true)
                .setBreathAttack(true)
                .setWingspan(20)
                .build(); // Factory Method

        System.out.println("\n=== Fire Dragon ===");
        fireDragon.displayInfo();

        EnemyRegistry registry = new EnemyRegistry();
        registry.registerTemplate("fire-dragon", fireDragon);

        Enemy eliteDragon = registry.createFromTemplate("fire-dragon");
        eliteDragon.multiplyStats(2.0); // 2x stronger
        System.out.println("\n=== Elite Dragon ===");
        eliteDragon.displayInfo();

        Enemy ancientDragon = registry.createFromTemplate("fire-dragon");
        ancientDragon.multiplyStats(5.0); // 5x stronger
        System.out.println("\n=== Ancient Dragon ===");
        ancientDragon.displayInfo();

        BasicEnemyBuilder goblinBuilder = new BasicEnemyBuilder();
        EnemyDirector director = new EnemyDirector(goblinBuilder);

        Enemy minion = director.createMinion();
        System.out.println("\n=== Minion Goblin ===");
        minion.displayInfo();

        Enemy customGoblin = goblinBuilder
                .setName("Champion Goblin")
                .setHealth(300)
                .setDamage(50)
                .setDefense(20)
                .setSpeed(40)
                .addAbility(new FireShield())
                .build();
        System.out.println("\n=== Custom Goblin ===");
        customGoblin.displayInfo();


        EnemyComponentFactory iceFactory = new IceComponentFactory();

        DragonBoss iceDragon = new DragonBoss.Builder()
                .setName("Ice Dragon")
                .setHealth(45000)
                .setDamage(450)
                .setDefense(180)
                .setSpeed(45)
                .setElement("ICE")
                .setAbilities(iceFactory.createAbilities())
                .setLootTable(iceFactory.createLootTable())
                .setAI(iceFactory.createAIBehavior())
                .addPhase(1, 45000)
                .addPhase(2, 25000)
                .setCanFly(true)
                .setBreathAttack(true)
                .setWingspan(18)
                .build();

        System.out.println("\n=== Ice Dragon ===");
        iceDragon.displayInfo();
    }
}