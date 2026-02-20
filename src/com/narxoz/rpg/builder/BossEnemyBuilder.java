package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BossEnemyBuilder implements EnemyBuilder {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities = new ArrayList<>();
    private Map<Integer,Integer> phases = new HashMap<>();
    private LootTable lootTable;
    private String aiBehavior;
    private boolean canFly = false;
    private boolean hasBreathAttack = false;
    private int wingspan = 0;

    public BossEnemyBuilder setName(String name) { this.name = name; return this; }
    public BossEnemyBuilder setHealth(int health) { this.health = health; return this; }
    public BossEnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    public BossEnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    public BossEnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }
    public BossEnemyBuilder setElement(String element) { this.element = element; return this; }
    public BossEnemyBuilder addAbility(Ability ability) { abilities.add(ability); return this; }
    public BossEnemyBuilder addPhase(int phase, int threshold) { phases.put(phase, threshold); return this; }
    public BossEnemyBuilder setLootTable(LootTable lootTable) { this.lootTable = lootTable; return this; }
    public BossEnemyBuilder setAI(String ai) { this.aiBehavior = ai; return this; }
    public BossEnemyBuilder setCanFly(boolean canFly) { this.canFly = canFly; return this; }
    public BossEnemyBuilder setBreathAttack(boolean hasBreathAttack) { this.hasBreathAttack = hasBreathAttack; return this; }
    public BossEnemyBuilder setWingspan(int wingspan) { this.wingspan = wingspan; return this; }

    @Override
    public Enemy build() {
        if (name == null || health <= 0) {
            throw new IllegalStateException("Boss must have name and health!");
        }

        // Use DragonBoss.Builder internally
        return new DragonBoss.Builder()
                .setName(name)
                .setHealth(health)
                .setDamage(damage)
                .setDefense(defense)
                .setSpeed(speed)
                .setElement(element)
                .setAbilities(abilities)
                .setLootTable(lootTable)
                .setAI(aiBehavior)
                .setCanFly(canFly)
                .setBreathAttack(hasBreathAttack)
                .setWingspan(wingspan)
                .build();
    }
}