package com.narxoz.rpg.combat;

public class FlameBreath implements Ability {
    private String name = "Flame Breath";
    private int damage = 50;

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
        return "Breathes fire on the enemy, causing " + damage + " damage.";
    }

    @Override
    public AbilityType getType() {
        return AbilityType.DAMAGE;
    }

    @Override
    public Ability clone() {
        return new FlameBreath();
    }
}
