package com.narxoz.rpg.bridge;

public class FireEffect implements EffectImplementor {
    @Override
    public int computeDamage(int basePower) {
        return (int) (basePower * 1.5);
    }

    @Override
    public String getEffectName() {
        return "Fire";
    }
}