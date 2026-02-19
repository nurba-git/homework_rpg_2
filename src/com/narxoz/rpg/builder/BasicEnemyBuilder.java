package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DragonBoss implements Enemy {

    private final String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;
    private final String element;
    private final List<Ability> abilities;
    private final Map<Integer, Integer> phases;
    private LootTable lootTable;
    private final String aiBehavior;
    private final boolean canFly;
    private final boolean hasBreathAttack;
    private final int wingspan;

    public DragonBoss(String name, int health, int damage, int defense, int speed,
                      String element, List<Ability> abilities, Map<Integer, Integer> phases,
                      LootTable lootTable, String aiBehavior,
                      boolean canFly, boolean hasBreathAttack, int wingspan) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.abilities = new ArrayList<>(abilities);  // deep copy list reference
        this.phases = phases;
        this.lootTable = lootTable;
        this.aiBehavior = aiBehavior;
        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
    }

    @Override
    public String getName() { return name; }
    @Override
    public int getHealth() { return health; }
    @Override
    public int getDamage() { return damage; }
    @Override
    public int getDefense() { return defense; }
    @Override
    public int getSpeed() { return speed; }
    @Override
    public String getElement() { return element; }
    @Override
    public List<Ability> getAbilities() { return new ArrayList<>(abilities); }
    @Override
    public LootTable getLootTable() { return lootTable; }
    @Override
    public String getAIBehavior() { return aiBehavior; }

    @Override
    public Enemy clone() {
        List<Ability> clonedAbilities = new ArrayList<>();
        for (Ability ability : abilities) {
            clonedAbilities.add(ability.clone());
        }
        LootTable clonedLoot = lootTable != null ? lootTable.clone() : null;
        return new DragonBoss(name, health, damage, defense, speed, element,
                clonedAbilities, phases, clonedLoot, aiBehavior,
                canFly, hasBreathAttack, wingspan);
    }

    @Override
    public void multiplyStats(double factor) {
        health *= factor;
        damage *= factor;
        defense *= factor;
        speed *= factor;
    }
}
