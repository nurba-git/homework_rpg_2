package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.BasicEnemyBuilder;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DragonBossBuilder implements EnemyBuilder {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private String element;
    private List<Ability> abilities = new ArrayList<>();
    private Map<Integer, Integer> phases = new HashMap<>();
    private LootTable lootTable;
    private String aiBehavior;
    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    @Override
    public EnemyBuilder setName(String name) { this.name = name; return this; }
    @Override
    public EnemyBuilder setHealth(int health) { this.health = health; return this; }
    @Override
    public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    @Override
    public EnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    @Override
    public EnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }
    @Override
    public EnemyBuilder setElement(String element) { this.element = element; return this; }
    @Override
    public EnemyBuilder setAbilities(List<Ability> abilities) { this.abilities = abilities; return this; }
    @Override
    public EnemyBuilder addAbility(Ability ability) { this.abilities.add(ability); return this; }
    @Override
    public EnemyBuilder setLootTable(LootTable lootTable) { this.lootTable = lootTable; return this; }
    @Override
    public EnemyBuilder setAI(String aiBehavior) { this.aiBehavior = aiBehavior; return this; }

    public DragonBossBuilder addPhase(int phaseNumber, int threshold) {
        this.phases.put(phaseNumber, threshold);
        return this;
    }

    public DragonBossBuilder setCanFly(boolean canFly) { this.canFly = canFly; return this; }
    public DragonBossBuilder setHasBreathAttack(boolean hasBreathAttack) { this.hasBreathAttack = hasBreathAttack; return this; }
    public DragonBossBuilder setWingspan(int wingspan) { this.wingspan = wingspan; return this; }

    @Override
    public Enemy build() {
        if (name == null || health <= 0) throw new IllegalStateException("Name and health required!");
        return new BasicEnemyBuilder(name, health, damage, defense, speed, element, abilities, phases,
                lootTable, aiBehavior, canFly, hasBreathAttack, wingspan);
    }
}
