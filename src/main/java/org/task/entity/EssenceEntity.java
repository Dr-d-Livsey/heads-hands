package org.task.entity;


import org.task.exception.BadArgumentEssenceException;

import java.util.Random;

public class EssenceEntity {

    protected EssenceEntityType type;
    protected String name;

    protected int attack;
    protected int defence;

    protected int health;

    protected final int minDamage;
    protected final int maxDamage;
    protected final int maxHealth;

    public EssenceEntity(
            String name,
            int attack,
            int defence,
            int minDamage,
            int maxDamage,
            int maxHealth,
            EssenceEntityType type
    ) {
        if (maxHealth < 0)
            throw new BadArgumentEssenceException("Heal point cannot be negative!");

        if (attack < 1 || attack > 30)
            throw new BadArgumentEssenceException("Value attack only from 1 to 30");

        if (defence < 1 || defence > 30)
            throw new BadArgumentEssenceException("Value defence only from 1 to 30");

        if (minDamage < 1 || maxDamage < minDamage)
            throw new BadArgumentEssenceException("Not correct value damage!");

        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.maxHealth = maxHealth;
        this.health = maxHealth;

        this.type = type;

        this.attack = attack;
        this.defence = defence;

        this.name = name;
    }

    public int getHealth(){
        return this.health;
    }

    public int getMaxHealth(){
        return this.maxHealth;
    }

    public void attack(EssenceEntity target) {

        if (this.type == target.type || this.health <= 0 || target.health <= 0){
            return;
        }

        boolean isSuccessful = false;
        Random random = new Random();

        for (int i = 0; i < Math.abs(attack - target.defence) + 1; i++) {

            int result = random.nextInt(1, 6);
            if (result == 5 || result == 6){
                isSuccessful = true;
                break;
            }

        }

        if (!isSuccessful) {

            System.out.printf("%s %s didn't attack!%n",
                    type == EssenceEntityType.PLAYER ? "Player" : "Monster",
                    this.name
            );
            return;
        }

        int damage = random.nextInt(this.minDamage, this.maxDamage);
        target.health -= damage;
        System.out.printf("%s %s made a successful attack %s %s | Damage: %d | Target HP: %d%n",
                type == EssenceEntityType.PLAYER ? "Player" : "Monster",
                this.name,
                target.type == EssenceEntityType.PLAYER ? "Player" : "Monster",
                target.name,
                damage,
                target.health
        );

        if (target.health <= 0){
            target.health = 0;
            System.out.printf("%s %s is dead!%n",
                    target.type == EssenceEntityType.PLAYER ? "Player" : "Monster",
                    target.name
            );
        }

    }
}
