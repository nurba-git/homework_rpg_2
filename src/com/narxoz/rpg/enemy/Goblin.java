package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.*;

public class Goblin implements Enemy {

    private final String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private List<Ability> abilities;
    private LootTable lootTable;

    public Goblin(String name, int health, int damage, int defense, int speed, List<Ability> abilities, LootTable lootTable) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.abilities = new ArrayList<>(abilities);
        this.lootTable = lootTable;
    }

    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getDefense() { return defense; }
    public int getSpeed() { return speed; }
    public List<Ability> getAbilities() { return Collections.unmodifiableList(abilities); }
    public LootTable getLootTable() { return lootTable; }

    @Override
    public void displayInfo() {
        System.out.println("Goblin: " + name + " HP:" + health + " DMG:" + damage + " DEF:" + defense + " SPD:" + speed);
    }

    @Override
    public Enemy clone() {
        return new Goblin(name, health, damage, defense, speed, abilities, lootTable);
    }

    @Override
    public void multiplyStats(double multiplier) {
        health = (int)(health * multiplier);
        damage = (int)(damage * multiplier);
        defense = (int)(defense * multiplier);
        speed = (int)(speed * multiplier);
    }
}