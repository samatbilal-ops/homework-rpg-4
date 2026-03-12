package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

public class SingleTargetSkill extends Skill {
    public SingleTargetSkill(String name, int power, EffectImplementor effect) {
        super(name, power, effect);
    }

    @Override
    public void cast(CombatNode target) {
        target.takeDamage(effect.computeDamage(basePower));
    }
}