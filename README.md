# Тестовое задание - Heads&&Hands
## Телеграм: @Dr_d_Livsey

> Тестовое задание для поступления на обучение.
В данном задании было реализовано три основных класса:
> 1. [Сущность](src/main/java/org/task/entity/EssenceEntity.java)
> 2. [Игрок](src/main/java/org/task/entity/PlayerEntity.java)
> 3. [Монстр](src/main/java/org/task/entity/MonsterEntity.java)

Класс [Сущность](src/main/java/org/task/entity/EssenceEntity.java) используется для реализации базового функционала для избежания дубликата кода.
> Функция атаки: `entity.attack(target.entity)`
> 1. Нельзя атаковать своих же
> 2. Нельзя атаковать будучи мертвым
> 3. Нельзя атаковать мертвого

От класса [Сущность](src/main/java/org/task/entity/EssenceEntity.java) наследуются [Игрок](src/main/java/org/task/entity/PlayerEntity.java), [Монстр](src/main/java/org/task/entity/MonsterEntity.java).

У класса [Игрок](src/main/java/org/task/entity/PlayerEntity.java) реализован функционал лечения. Лечение можно использовать ограниченное кол-во.
```java
public void healPlayer() {
        if (this.health == 0 || this.countHeal == 0) {
            return;
        }

        this.countHeal--;

        final short healPercentage = 30;
        this.health += (this.maxHealth * healPercentage) / 100;
        if (this.health > this.maxHealth) this.health = maxHealth;

        System.out.printf("Player %s use heal | Current HP: %d | %d heal left%n",
                this.name,
                this.health,
                this.countHeal
        );
    }
```
где `countHeal` имеет по стандарту число 4.

Также реализовано несколько сценариев для демонстрации функционала классов.
Реализован интерфейс [ScenarioLogic](src/main/java/org/task/scenario/ScenarioLogic.java)
От него имплиментируются три сценария:
> 1. [Первый сценарий](src/main/java/org/task/scenario/impl/FirstScenarioImpl.java)
> 2. [Второй сценарий](src/main/java/org/task/scenario/impl/SecondScenarioImpl.java)
> 3. [Третий сценарий](src/main/java/org/task/scenario/impl/ThirdScenarioImpl.java)

Сценарии выбираются рандомно в главном классе [Main](src/main/java/org/task/Main.java)
```java
List<ScenarioLogic> scenarioLogics = List.of(
                new FirstScenarioImpl(),
                new SecondScenarioImpl(),
                new ThirdScenarioImpl()
        );
ScenarioLogic scenarioLogic = scenarioLogics.get(new Random().nextInt(scenarioLogics.size()));
```

После выбранного сценария вызывается функции `getNameScenario`, `fight`,
где `getNameScenario` - название сценария, `fight` - старт сценария# heads-hands
