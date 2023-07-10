package units;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class Warlock extends BaseClass{
    int armorShred;
    int reduceDamage;

    @Override
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam){    }
    @Override
    public void attack(@NotNull BaseClass target){
        int damage = this.getAverageDamage(this.attack);
        if (damage <0) damage = 0;
        System.out.println(this.name+ " атакует " +target.name + ", и наносит "
                + damage + " урона. И снижает броню "+target.name+ " на " + armorShred + " единиц.");
        target.health = target.health-damage;
        target.armor = target.armor-armorShred;
        int chance = new Random().nextInt(0,100);
        if (chance > 80) {
            target.attack[0] = target.attack[0] - reduceDamage;
            target.attack[1] = target.attack[1] - reduceDamage;
        }
    }
    @Override
    public void useAccessory(BaseClass target){
        int soak = new Random().nextInt(0,4);
        System.out.println(this.name + " использует " + this.accessory+
                " и высасывает у " + target.name + soak + " здоровья.");
        target.health = target.health - soak;
        this.health = this.health + soak;
    }

    public Warlock(){
        super();
        this.accessory = "Жертвенная чаша";
        this.health = super.health-2;
        this.type = "Колдун";
        this.weapon = "Гримуар";
        this.distance = 15;
        this.resource = "Мана";
        this.armorShred = 3;
        this.reduceDamage = 3;
        this.setInitiative(super.getInitiative() -5);
        this.attack[0] = super.attack[0]-3;
        this.attack[1] = super.attack[1]-3;
        this.currentHp = this.health;
    }
    /**
     * Создаёт колдуна с заданными координатами:
     * @param x x
     * @param y y
     */
    public Warlock(int x, int y) {
        this();
        this.location = new Location(x,y);
    }
}
