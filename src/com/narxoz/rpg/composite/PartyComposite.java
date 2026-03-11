package com.narxoz.rpg.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PartyComposite implements CombatNode {
    private final String name;
    private final List<CombatNode> children = new ArrayList<>();

    public PartyComposite(String name) { this.name = name; }
    public void add(CombatNode node) { children.add(node); }

    @Override
    public int getHealth() {
        int total = 0;
        for (CombatNode child : children) total += child.getHealth();
        return total;
    }

    @Override
    public void takeDamage(int amount) {
        List<CombatNode> alive = new ArrayList<>();
        for (CombatNode c : children) if (c.isAlive()) alive.add(c);

        if (!alive.isEmpty()) {
            int share = amount / alive.size();
            for (CombatNode target : alive) target.takeDamage(share);
        }
    }

    @Override
    public boolean isAlive() {
        for (CombatNode child : children) if (child.isAlive()) return true;
        return false;
    }

    @Override
    public void printTree(String indent) {
        System.out.println(indent + "+ " + name + " [Total HP=" + getHealth() + "]");
        for (CombatNode child : children) child.printTree(indent + "  ");
    }

    @Override
    public String getName() { return name; }
    @Override
    public List<CombatNode> getChildren() { return Collections.unmodifiableList(children); }
    @Override
    public int getAttackPower() {
        int total = 0;
        for (CombatNode child : children) if (child.isAlive()) total += child.getAttackPower();
        return total;
    }
}