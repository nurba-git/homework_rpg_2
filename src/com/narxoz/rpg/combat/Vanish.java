package com.narxoz.rpg.combat;

public class Vanish implements Ability {
    private String name = "Vanish";
    private int damage = 0;

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
        return "Disappears from sight, avoiding attacks for a short duration.";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.BUFF;
    }

    @Override
    public Ability clone() {
        return new Vanish();
    }
}
