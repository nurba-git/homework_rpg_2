package com.narxoz.rpg.combat;

public class BasicAbility implements Ability {

    private String name;
    private int damage;
    private String description;
    private AbilityType type;

    public BasicAbility(String name, int damage, String description, AbilityType type) {
        this.name = name;
        this.damage = damage;
        this.description = description;
        this.type = type;
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getDamage() { return damage; }

    @Override
    public String getDescription() { return description; }

    @Override
    public AbilityType getType() { return type; }

    @Override
    public Ability clone() {

        return new BasicAbility(name, damage, description, type);
    }
}
