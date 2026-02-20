package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class ShadowLootTable implements LootTable {

    private List<String> items;
    private int gold;
    private int experience;

    public ShadowLootTable() {
        this.items = new ArrayList<>();
        items.add("Shadow Gem");
        items.add("Dark Essence");
        items.add("Shadow Rune");

        this.gold = 550;
        this.experience = 1300;
    }

    private ShadowLootTable(ShadowLootTable other) {
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
        System.out.println("=== Shadow Loot ===");
        System.out.println("Gold: " + gold);
        System.out.println("XP: " + experience);
        for (String item : items) {
            System.out.println(" - " + item);
        }
    }

    @Override
    public LootTable clone() {
        return new ShadowLootTable(this);
    }
}
