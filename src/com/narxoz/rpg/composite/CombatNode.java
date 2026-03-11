package com.narxoz.rpg.composite;

import java.util.List;

public interface CombatNode {
    void takeDamage(int amount);
    boolean isAlive();
    List<CombatNode> getChildren();
    void printTree(String indent);
    String getName();
    int getHealth();
    int getAttackPower();
}