package com.narxoz.rpg.combat;

public class FrostBreath implements Ability {
    private String name = "Frost Breath";
    private int damage = 40;

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
        return "Breathes icy frost, causing " + damage + " damage and slowing enemies.";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.DAMAGE;
    }

    @Override
    public Ability clone() {
        return new FrostBreath();
    }
}
