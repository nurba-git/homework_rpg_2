package com.narxoz.rpg.combat;

public class Blizzard implements Ability {
    private String name = "Blizzard";
    private int damage = 80;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public String getDescription() {
        return "Summons a blizzard, dealing " + damage + " damage to all enemies.";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.ULTIMATE;
    }

    @Override
    public Ability clone() {
        return new Blizzard();
    }
}
