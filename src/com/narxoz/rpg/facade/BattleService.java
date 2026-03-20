package com.narxoz.rpg.facade;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.hero.HeroProfile;

import java.util.Random;

public class BattleService {
    private Random random = new Random(1L);
    private static final int MAX_ROUNDS = 10;

    public BattleService setRandomSeed(long seed) {
        this.random = new Random(seed);
        return this;
    }

    public AdventureResult battle(HeroProfile hero, BossEnemy boss, AttackAction action) {
        AdventureResult result = new AdventureResult();

        if (hero == null || boss == null || action == null) {
            result.setWinner("No one");
            result.setRounds(0);
            result.addLine("Battle could not start: invalid participants or action.");
            return result;
        }

        result.addLine("Battle started: " + hero.getName() + " vs " + boss.getName());

        int round = 0;

        while (hero.isAlive() && boss.isAlive() && round < MAX_ROUNDS) {
            round++;
            result.addLine("Round " + round + ":");

            int heroDamage = action.getDamage() + random.nextInt(5); // 0..4
            boss.takeDamage(heroDamage);
            result.addLine("  " + hero.getName() + " uses " + action.getActionName()
                    + " and deals " + heroDamage + " damage. "
                    + boss.getName() + " HP: " + boss.getHealth());

            if (!boss.isAlive()) {
                break;
            }

            int bossDamage = boss.getAttackPower() + random.nextInt(4); // 0..3
            hero.takeDamage(bossDamage);
            result.addLine("  " + boss.getName() + " strikes back for " + bossDamage
                    + " damage. " + hero.getName() + " HP: " + hero.getHealth());
        }

        result.setRounds(round);

        if (hero.isAlive() && !boss.isAlive()) {
            result.setWinner(hero.getName());
            result.addLine("Battle finished: hero victory.");
        } else if (!hero.isAlive() && boss.isAlive()) {
            result.setWinner(boss.getName());
            result.addLine("Battle finished: boss victory.");
        } else if (!hero.isAlive() && !boss.isAlive()) {
            result.setWinner("Draw");
            result.addLine("Battle finished: both sides fell.");
        } else {
            if (hero.getHealth() >= boss.getHealth()) {
                result.setWinner(hero.getName());
                result.addLine("Battle reached round limit. Winner decided by remaining HP: hero.");
            } else {
                result.setWinner(boss.getName());
                result.addLine("Battle reached round limit. Winner decided by remaining HP: boss.");
            }
        }

        return result;
    }
}