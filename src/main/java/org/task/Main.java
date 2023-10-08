package org.task;

import org.task.scenario.ScenarioLogic;
import org.task.scenario.impl.FirstScenarioImpl;
import org.task.scenario.impl.SecondScenarioImpl;
import org.task.scenario.impl.ThirdScenarioImpl;

import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<ScenarioLogic> scenarioLogics = List.of(
                new FirstScenarioImpl(),
                new SecondScenarioImpl(),
                new ThirdScenarioImpl()
        );
        ScenarioLogic scenarioLogic = scenarioLogics.get(new Random().nextInt(scenarioLogics.size()));
        System.out.println("Current scenario: " + scenarioLogic.getNameScenario());
        System.out.println("Fight STARTED!" + System.lineSeparator());
        scenarioLogic.fight();
    }
}