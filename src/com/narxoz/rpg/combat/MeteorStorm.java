package com.narxoz.rpg.combat;

public class MeteorStorm implements Ability {
    private String name = "Meteor Storm";
    private int damage = 100;

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
        return "Calls down a storm of meteors, causing massive " + damage + " damage to all enemies.";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.ULTIMATE;
    }

    @Override
    public Ability clone() {
        return new MeteorStorm();
    }
}
