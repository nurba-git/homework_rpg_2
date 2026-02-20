package com.narxoz.rpg.combat;

public class IceShield implements Ability {
    private String name = "Ice Shield";
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
        return "Casts a protective ice shield, reducing incoming damage.";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.BUFF;
    }

    @Override
    public Ability clone() {
        return new IceShield();
    }
}
