package org.task.scenario.impl;

import org.task.entity.MonsterEntity;
import org.task.entity.PlayerEntity;
import org.task.scenario.ScenarioLogic;

public class ThirdScenarioImpl implements ScenarioLogic {
    @Override
    public String getNameScenario() {
        return "Hard brutal one-on-one fight";
    }

    @Override
    public void fight() {
        PlayerEntity playerEntity = new PlayerEntity("Khabib", 15, 30, 1, 15, 350);
        MonsterEntity monsterEntity = new MonsterEntity("Conor", 30, 1, 10, 200, 69);

        while (playerEntity.getHealth() > 0 && monsterEntity.getHealth() > 0) {
            playerEntity.attack(monsterEntity);
            monsterEntity.attack(playerEntity);
            if (playerEntity.getMaxHealth() / 2 >= playerEntity.getHealth()){
                playerEntity.healPlayer();
            }
        }

    }
}
