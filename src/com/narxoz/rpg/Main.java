package com.narxoz.rpg;

import com.narxoz.rpg.battle.RaidEngine;
import com.narxoz.rpg.battle.RaidResult;
import com.narxoz.rpg.bridge.AreaSkill;
import com.narxoz.rpg.bridge.EffectImplementor;
import com.narxoz.rpg.bridge.FireEffect;
import com.narxoz.rpg.bridge.IceEffect;
import com.narxoz.rpg.bridge.ShadowEffect;
import com.narxoz.rpg.bridge.SingleTargetSkill;
import com.narxoz.rpg.bridge.Skill;
import com.narxoz.rpg.composite.EnemyUnit;
import com.narxoz.rpg.composite.HeroUnit;
import com.narxoz.rpg.composite.PartyComposite;
import com.narxoz.rpg.composite.RaidGroup;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== RPG Battle Simulator: Advanced Demo ===\n");

        PartyComposite alliance = new PartyComposite("Alliance Forces");

        PartyComposite knightSquad = new PartyComposite("Knight Squad");
        knightSquad.add(new HeroUnit("Arthur", 120, 35));
        knightSquad.add(new HeroUnit("Galahad", 110, 30));

        alliance.add(knightSquad);
        alliance.add(new HeroUnit("Merlin", 80, 60));

        RaidGroup hordeRaid = new RaidGroup("Horde Invasion");

        PartyComposite orcWarriors = new PartyComposite("Orc Warriors");
        orcWarriors.add(new EnemyUnit("Orc Grunt 1", 100, 25));
        orcWarriors.add(new EnemyUnit("Orc Grunt 2", 100, 25));

        hordeRaid.add(orcWarriors);
        hordeRaid.add(new EnemyUnit("Troll Shaman", 90, 45));

        System.out.println("Team Structures:");
        alliance.printTree("");
        hordeRaid.printTree("");
        System.out.println();

        EffectImplementor fire = new FireEffect();
        EffectImplementor shadow = new ShadowEffect();
        EffectImplementor ice = new IceEffect();

        Skill heavySlash = new SingleTargetSkill("Heavy Slash", 40, fire);
        Skill darkNova = new AreaSkill("Dark Nova", 25, shadow);
        Skill blizzard = new AreaSkill("Blizzard", 20, ice);

        RaidEngine engine = new RaidEngine();
        engine.setRandomSeed(99L);

        System.out.println("--- Battle Start ---");
        RaidResult result = engine.runRaid(alliance, hordeRaid, blizzard, heavySlash);

        System.out.println("\n--- Battle Summary ---");
        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds Played: " + result.getRounds());

        System.out.println("\nBattle Log:");
        for (String event : result.getLog()) {
            System.out.println(event);
        }

        System.out.println("\nFinal State:");
        alliance.printTree("");
        hordeRaid.printTree("");
    }
}