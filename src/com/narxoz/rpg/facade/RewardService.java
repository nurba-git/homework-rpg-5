package com.narxoz.rpg.facade;

public class RewardService {
    public String determineReward(AdventureResult battleResult) {
        if (battleResult == null) {
            return "No reward";
        }

        if ("Draw".equalsIgnoreCase(battleResult.getWinner())) {
            return "Broken relic shard";
        }

        if (battleResult.getWinner() == null || "No one".equalsIgnoreCase(battleResult.getWinner())) {
            return "No reward";
        }

        if (battleResult.getRounds() <= 3) {
            return "Legendary chest";
        } else if (battleResult.getRounds() <= 6) {
            return "Epic weapon";
        } else if (battleResult.getWinner().equals("Shadow Dragon")) {
            return "Consolation potion";
        } else {
            return "Gold and crafting materials";
        }
    }
}