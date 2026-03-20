HeroProfile
--------------------------------
- name : String
- health : int
--------------------------------
+ HeroProfile(name : String, health : int)
+ getName() : String
+ getHealth() : int
+ takeDamage(amount : int) : void
+ isAlive() : boolean


BossEnemy
--------------------------------
- name : String
- health : int
- attackPower : int
--------------------------------
+ BossEnemy(name : String, health : int, attackPower : int)
+ getName() : String
+ getHealth() : int
+ getAttackPower() : int
+ takeDamage(amount : int) : void
+ isAlive() : boolean


AdventureResult
--------------------------------
- winner : String
- rounds : int
- reward : String
- log : List<String>
--------------------------------
+ getWinner() : String
+ setWinner(winner : String) : void
+ getRounds() : int
+ setRounds(rounds : int) : void
+ getReward() : String
+ setReward(reward : String) : void
+ addLine(line : String) : void
+ getLog() : List<String>


PreparationService
--------------------------------
+ prepare(hero : HeroProfile, boss : BossEnemy, action : AttackAction) : String


BattleService
--------------------------------
- random : Random
--------------------------------
+ setRandomSeed(seed : long) : BattleService
+ battle(hero : HeroProfile, boss : BossEnemy, action : AttackAction) : AdventureResult


RewardService
--------------------------------
+ determineReward(battleResult : AdventureResult) : String


DungeonFacade
--------------------------------
- preparationService : PreparationService
- battleService : BattleService
- rewardService : RewardService
--------------------------------
+ setRandomSeed(seed : long) : DungeonFacade
+ runAdventure(hero : HeroProfile, boss : BossEnemy, action : AttackAction) : AdventureResult