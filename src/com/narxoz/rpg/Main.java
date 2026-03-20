package com.narxoz.rpg;

import com.narxoz.rpg.decorator.AttackAction;
import com.narxoz.rpg.decorator.BasicAttack;
import com.narxoz.rpg.decorator.CriticalFocusDecorator;
import com.narxoz.rpg.decorator.FireRuneDecorator;
import com.narxoz.rpg.decorator.PoisonCoatingDecorator;
import com.narxoz.rpg.enemy.BossEnemy;
import com.narxoz.rpg.facade.AdventureResult;
import com.narxoz.rpg.facade.DungeonFacade;
import com.narxoz.rpg.hero.HeroProfile;

public class Main {

    private static void printActionPreview(String label, AttackAction action) {
        System.out.println(label);
        System.out.println("Name   : " + action.getActionName());
        System.out.println("Damage : " + action.getDamage());
        System.out.println("Effects: " + action.getEffectSummary());
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("=== Homework 5 Demo: Decorator + Facade ===\n");

        AttackAction basic = new BasicAttack("Sword Slash", 12);
        AttackAction fireAttack = new FireRuneDecorator(basic);
        AttackAction poisonAttack = new PoisonCoatingDecorator(basic);
        AttackAction criticalAttack = new CriticalFocusDecorator(basic);

        AttackAction comboOne = new FireRuneDecorator(
                new PoisonCoatingDecorator(basic)
        );

        AttackAction comboTwo = new CriticalFocusDecorator(
                new FireRuneDecorator(
                        new PoisonCoatingDecorator(basic)
                )
        );

        AttackAction comboThree = new PoisonCoatingDecorator(
                new CriticalFocusDecorator(
                        new FireRuneDecorator(basic)
                )
        );

        System.out.println("--- Decorator Preview ---");
        printActionPreview("Base action", basic);
        printActionPreview("Fire version", fireAttack);
        printActionPreview("Poison version", poisonAttack);
        printActionPreview("Critical version", criticalAttack);
        printActionPreview("Combo 1: Fire + Poison", comboOne);
        printActionPreview("Combo 2: Critical + Fire + Poison", comboTwo);
        printActionPreview("Combo 3: Poison + Critical + Fire", comboThree);

        System.out.println("--- Facade Preview ---");

        HeroProfile hero = new HeroProfile("Arthas", 95);
        BossEnemy boss = new BossEnemy("Shadow Dragon", 90, 13);

        DungeonFacade facade = new DungeonFacade().setRandomSeed(42L);
        AdventureResult result = facade.runAdventure(hero, boss, comboTwo);

        System.out.println("Winner: " + result.getWinner());
        System.out.println("Rounds: " + result.getRounds());
        System.out.println("Reward: " + result.getReward());
        System.out.println("\nBattle log:");
        for (String line : result.getLog()) {
            System.out.println(line);
        }

        System.out.println("\n=== Demo Complete ===");
    }
}