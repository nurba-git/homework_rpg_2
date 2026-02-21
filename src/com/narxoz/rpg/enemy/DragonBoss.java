package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;
import java.util.*;

public class DragonBoss implements Enemy {

    private final String name;
    private int health, damage, defense, speed;
    private final String element;
    private final List<Ability> abilities;
    private final Map<Integer,Integer> phases;
    private final LootTable lootTable;
    private final String aiBehavior;
    private final boolean canFly;
    private final boolean hasBreathAttack;
    private final int wingspan;


    private DragonBoss(Builder builder) {
        this.name = builder.name;
        this.health = builder.health;
        this.damage = builder.damage;
        this.defense = builder.defense;
        this.speed = builder.speed;
        this.element = builder.element;

        this.abilities = new ArrayList<>();
        for (Ability a : builder.abilities)
            this.abilities.add(a.clone());

        this.phases = new HashMap<>(builder.phases);
        this.lootTable = builder.lootTable != null ? builder.lootTable.clone() : null;

        this.aiBehavior = builder.aiBehavior;
        this.canFly = builder.canFly;
        this.hasBreathAttack = builder.hasBreathAttack;
        this.wingspan = builder.wingspan;
    }


    public static class Builder {
        private String name;
        private int health, damage, defense, speed;
        private String element;
        private List<Ability> abilities = new ArrayList<>();
        private Map<Integer,Integer> phases = new HashMap<>();
        private LootTable lootTable;
        private String aiBehavior;
        private boolean canFly = false;
        private boolean hasBreathAttack = false;
        private int wingspan = 0;

        public Builder setName(String name) { this.name = name; return this; }
        public Builder setHealth(int health) { this.health = health; return this; }
        public Builder setDamage(int damage) { this.damage = damage; return this; }
        public Builder setDefense(int defense) { this.defense = defense; return this; }
        public Builder setSpeed(int speed) { this.speed = speed; return this; }
        public Builder setElement(String element) { this.element = element; return this; }
        public Builder addAbility(Ability ability) { this.abilities.add(ability); return this; }
        public Builder setAbilities(List<Ability> abilities) { this.abilities = abilities; return this; }
        public Builder addPhase(int phase, int threshold) { this.phases.put(phase, threshold); return this; }
        public Builder setLootTable(LootTable lootTable) { this.lootTable = lootTable; return this; }
        public Builder setAI(String aiBehavior) { this.aiBehavior = aiBehavior; return this; }
        public Builder setCanFly(boolean canFly) { this.canFly = canFly; return this; }
        public Builder setBreathAttack(boolean breath) { this.hasBreathAttack = breath; return this; }
        public Builder setWingspan(int wingspan) { this.wingspan = wingspan; return this; }

        public DragonBoss build() {
            if(name == null || health <= 0)
                throw new IllegalStateException("DragonBoss must have name and health!");
            return new DragonBoss(this);
        }
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
    public List<Ability> getAbilities() { return Collections.unmodifiableList(abilities); }
    @Override
    public LootTable getLootTable() { return lootTable; }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("HP: " + health + " | DMG: " + damage
                + " | DEF: " + defense + " | SPD: " + speed);
        System.out.println("Element: " + element);
        System.out.println("Abilities: " + abilities.size());
        System.out.println("Phases: " + phases.size());
        System.out.println("AI: " + aiBehavior);
        System.out.println("Fly: " + canFly + " | Breath: " + hasBreathAttack + " | Wingspan: " + wingspan);
    }

    @Override
    public Enemy clone() {
        Builder builder = new Builder()
                .setName(name)
                .setHealth(health)
                .setDamage(damage)
                .setDefense(defense)
                .setSpeed(speed)
                .setElement(element)
                .setAbilities(this.abilities)
                .setLootTable(lootTable)
                .setAI(aiBehavior)
                .setCanFly(canFly)
                .setBreathAttack(hasBreathAttack)
                .setWingspan(wingspan);

        for(Map.Entry<Integer,Integer> e : phases.entrySet())
            builder.addPhase(e.getKey(), e.getValue());

        return builder.build();
    }

    @Override
    public void multiplyStats(double multiplier) {
        this.health = (int)(health*multiplier);
        this.damage = (int)(damage*multiplier);
        this.defense = (int)(defense*multiplier);
        this.speed = (int)(speed*multiplier);
    }
}