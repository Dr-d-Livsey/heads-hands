package org.task.entity;

public class PlayerEntity extends EssenceEntity {

    private short countHeal = 4;

    public PlayerEntity(String name, int attack, int defence, int minDamage, int maxDamage, int maxHealth) {
        super(name, attack, defence, minDamage, maxDamage, maxHealth, EssenceEntityType.PLAYER);

    }

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
}
