package com.narxoz.rpg.combat;

public class DarkNova implements Ability {
    private String name = "Dark Nova";
    private int damage = 90;

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
        return "Unleashes a dark explosion, dealing " + damage + " damage to all enemies nearby.";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.ULTIMATE;
    }

    @Override
    public Ability clone() {
        return new DarkNova();
    }
}
