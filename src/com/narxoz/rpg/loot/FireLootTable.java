package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class FireLootTable implements LootTable {

    private List<String> items;
    private int gold;
    private int experience;

    public FireLootTable() {
        this.items = new ArrayList<>();
        items.add("Fire Gem");
        items.add("Dragon Scale");
        items.add("Flame Rune");

        this.gold = 500;
        this.experience = 1200;
    }


    private FireLootTable(FireLootTable other) {
        this.items = new ArrayList<>(other.items);
        this.gold = other.gold;
        this.experience = other.experience;
    }

    @Override
    public List<String> getItems() {
        return new ArrayList<>(items); // defensive copy
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
        System.out.println("=== Fire Loot ===");
        System.out.println("Gold: " + gold);
        System.out.println("XP: " + experience);
        for (String item : items) {
            System.out.println(" - " + item);
        }
    }

    @Override
    public LootTable clone() {
        return new FireLootTable(this);
    }
}
