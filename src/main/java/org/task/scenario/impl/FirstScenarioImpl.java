package org.task.scenario.impl;

import org.task.entity.MonsterEntity;
import org.task.entity.PlayerEntity;
import org.task.scenario.ScenarioLogic;

public class FirstScenarioImpl implements ScenarioLogic {

    @Override
    public String getNameScenario() {
        return "Players are trying to destroy the monster";
    }

    @Override
    public void fight() {
        PlayerEntity artemPlayer = new PlayerEntity("Artem", 10, 20, 1, 40, 100);
        PlayerEntity stepanPlayer = new PlayerEntity("Stepan", 15, 30, 20, 40, 100);
        MonsterEntity kirillMonster = new MonsterEntity("Kirill",30, 20, 2, 50, 200);

        for (int i = 0; i < 4; i++) artemPlayer.attack(kirillMonster);

        kirillMonster.attack(artemPlayer);
        for (int i = 0; i < 4; i++) artemPlayer.attack(kirillMonster);

        for (int i = 0; i < 2; i++) kirillMonster.attack(stepanPlayer);
        stepanPlayer.healPlayer();

        for (int i = 0; i < 2; i++) kirillMonster.attack(artemPlayer);
        artemPlayer.healPlayer();

        for (int i = 0; i < 10; i++) stepanPlayer.attack(kirillMonster);
    }
}
