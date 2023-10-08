package org.task.entity;

public class MonsterEntity extends EssenceEntity {
    public MonsterEntity(String name, int attack, int defence, int minDamage, int maxDamage, int maxHealth) {
        super(name, attack, defence, minDamage, maxDamage, maxHealth, EssenceEntityType.MONSTER);
    }
}
