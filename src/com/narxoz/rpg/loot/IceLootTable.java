package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class IceLootTable implements LootTable {

    private List<String> items;
    private int gold;
    private int experience;

    public IceLootTable() {
        this.items = new ArrayList<>();
        items.add("Ice Gem");
        items.add("Frost Scale");
        items.add("Ice Rune");

        this.gold = 450;
        this.experience = 1100;
    }

    private IceLootTable(IceLootTable other) {
        this.items = new ArrayList<>(other.items);
        this.gold = other.gold;
        this.experience = other.experience;
    }

    @Override
    public List<String> getItems() {
        return new ArrayList<>(items);
    }

    @Override
    public int getGoldDrop() {
        return gold;
    }

    @Override
    public int getExperienceDrop() {
        return experience;
    }

    @Override
    public void displayLoot() {
        System.out.println("=== Ice Loot ===");
        System.out.println("Gold: " + gold);
        System.out.println("XP: " + experience);
        for (String item : items) {
            System.out.println(" - " + item);
        }
    }

    @Override
    public LootTable clone() {
        return new IceLootTable(this);
    }
}
