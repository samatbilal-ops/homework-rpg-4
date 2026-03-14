package com.narxoz.rpg.composite;

import java.util.Collections;
import java.util.List;

public abstract class UnitLeaf implements CombatNode {
    private final String name;
    private int health;
    private final int attackPower;

    protected UnitLeaf(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    @Override public void takeDamage(int amount) { this.health = Math.max(0, this.health - amount); }
    @Override public boolean isAlive() { return this.health > 0; }
    @Override public int getHealth() { return this.health; }
    @Override public int getAttackPower() { return isAlive() ? attackPower : 0; }
    @Override public String getName() { return name; }
    @Override public List<CombatNode> getChildren() { return Collections.emptyList(); }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + "- " + name + " [HP: " + health + ", ATK: " + attackPower + "]");
    }
}