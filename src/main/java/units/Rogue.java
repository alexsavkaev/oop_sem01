package units;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class Rogue extends BaseClass{
    private final int dodgeMultiplier;
    @Override
    public boolean dodge(){
        int chance = new Random().nextInt(0, 100)+(dodgeMultiplier^2);
        return chance > 75;
    }

    @Override
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam){   }

    public void useAccessory(@NotNull BaseClass target){
        int damage = this.getAverageDamage(this.attack)/3;
        System.out.println(this.name + " бросает " + this.accessory + ", и наносит "
                + target.name +" "+ damage + " урона.");
        target.health = target.health-damage;
    }
    public Rogue(){
        super();
        this.armor = 10;
        this.accessory = "Метательный нож";
        this.agility = super.agility+2;
        this.health = super.health-2;
        this.attack[0] = super.attack[0]+4;
        this.attack[1] = super.attack[1]+4;
        this.type = "Разбойник";
        this.weapon = "Ножи";
        this.dodgeMultiplier = 3;
        this.setInitiative(super.getInitiative() + 5);
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
