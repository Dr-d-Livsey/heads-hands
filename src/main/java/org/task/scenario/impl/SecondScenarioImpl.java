package org.task.scenario.impl;

import org.task.entity.MonsterEntity;
import org.task.entity.PlayerEntity;
import org.task.scenario.ScenarioLogic;

import java.util.List;
import java.util.Random;

public class SecondScenarioImpl implements ScenarioLogic {
    @Override
    public String getNameScenario() {
        return "Two monsters brutally destroy Stepan";
    }

    @Override
    public void fight() {
        PlayerEntity stepanPlayer = new PlayerEntity("MrStepan", 30, 25, 1, 23, 100);
        MonsterEntity mathanalysisMonster = new MonsterEntity("Matan", 30, 20, 30, 69, 50);
        MonsterEntity linalMonster = new MonsterEntity("LinealAlgebra", 23, 25, 45, 60, 20);

        Random random = new Random();
        List<MonsterEntity> listOfMonster = List.of(mathanalysisMonster, linalMonster);

        for (int i = 0; i < 4; i++) {
            stepanPlayer.attack(listOfMonster.get(random.nextInt(0, listOfMonster.size() - 1)));
            mathanalysisMonster.attack(stepanPlayer);
            linalMonster.attack(stepanPlayer);
            stepanPlayer.healPlayer();
        }
    }
}
