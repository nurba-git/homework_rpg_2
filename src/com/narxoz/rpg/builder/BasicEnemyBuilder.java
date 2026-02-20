package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {

    protected String name;
    protected int health;
    protected int damage;
    protected int defense;
    protected int speed;
    protected List<Ability> abilities = new ArrayList<>();
    protected LootTable lootTable;

    public BasicEnemyBuilder() {
        // default constructor
    }

    @Override
    public BasicEnemyBuilder setName(String name) { this.name = name; return this; }
    @Override
    public BasicEnemyBuilder setHealth(int health) { this.health = health; return this; }
    @Override
    public BasicEnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    @Override
    public BasicEnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    @Override
    public BasicEnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }
    @Override
    public BasicEnemyBuilder setAbilities(List<Ability> abilities) { this.abilities = abilities; return this; }
    @Override
    public BasicEnemyBuilder addAbility(Ability ability) { this.abilities.add(ability); return this; }
    @Override
    public BasicEnemyBuilder setLootTable(LootTable lootTable) { this.lootTable = lootTable; return this; }

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        return null;
    }

    @Override
    public EnemyBuilder setAI(String aiBehavior) {
        return null;
    }

    @Override
    public Enemy build() {
        if (name == null || health <= 0) {
            throw new IllegalStateException("Enemy must have name and health!");
        }
        return new Goblin(name, health, damage, defense, speed, abilities, lootTable);
    }
}