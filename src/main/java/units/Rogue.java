package units;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class Rogue extends Melee{
    private final int dodgeMultiplier;
    @Override
    public boolean dodge(){
        int chance = new Random().nextInt(0, 100)+(dodgeMultiplier^2);
        return chance > 75;
    }
    @Override
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam) {
        if(!this.alive) return;
        BaseClass target = this.findNearest(enemyTeam);
        if(!this.isInRange(target)&& !usedAccessory &&
                this.location.getDistanceTo(target.location) < 5){
            useAccessory(target);
            return;
        }
        if(!this.isInRange(target)) {
            Location setback = this.location;
            this.location.moveTowards(target);
            System.out.printf("%s движется в сторону %s.\n", this.name, target.name);
            if(this.location.isTaken(allyTeam)) this.location = setback;
        }
        else {
            this.attack(target);
        }

    }

    @Override
    public void useAccessory(@NotNull BaseClass target){
        int damage = this.getAverageDamage(this.attack)/3;
        System.out.println(this.name + " бросает " + this.accessory + ", и наносит "
                + target.name +" "+ damage + " урона.");
        target.health = target.health-damage;
        this.usedAccessory = true;
    }
    public Rogue(){
        super();
        this.accessory = "Метательный нож";
        this.agility = super.agility+2;
        this.health = super.health-5;
        this.type = "Разбойник";
        this.weapon = "Ножи";
        this.dodgeMultiplier = 3;
        this.setInitiative(super.getInitiative() - 15);
        this.currentHp = this.health;
    }
    /**
     * Создаёт бандита с заданными координатами:
     * @param x x
     * @param y y
     */
    public Rogue(int x, int y) {
        this();
        this.location = new Location(x,y);
    }
}
