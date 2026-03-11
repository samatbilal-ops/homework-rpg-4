package com.narxoz.rpg.bridge;

import com.narxoz.rpg.composite.CombatNode;

public abstract class Skill {
    protected String name;
    protected int basePower;
    protected EffectImplementor effect;

    public Skill(String name, int basePower, EffectImplementor effect) {
        this.name = name;
        this.basePower = basePower;
        this.effect = effect;
    }

    public abstract void cast(CombatNode target);
    public String getSkillName() { return name; }
    public String getEffectName() { return effect.getEffectName(); }
}