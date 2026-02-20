package com.narxoz.rpg.combat;

public class ShadowStrike implements Ability {
    private String name = "Shadow Strike";
    private int damage = 45;

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
        return "Strikes from the shadows, causing " + damage + " damage.";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.DAMAGE;
    }

    @Override
    public Ability clone() {
        return new ShadowStrike();
    }
}
