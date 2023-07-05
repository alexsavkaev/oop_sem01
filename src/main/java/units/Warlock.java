package units;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class Warlock extends BaseClass{
    int armorShred;
    int reduceDamage;

    @Override
    public void step(ArrayList<BaseClass> team) {    }
    @Override
    public void attack(@NotNull BaseClass target){
        int damage = this.damage;
        if (damage <0) damage = 0;
        System.out.println(this.name+ " атакует " +target.name + ", и наносит "
                + damage + " урона. И снижает броню "+target.name+ " на " + armorShred + " единиц.");
        target.health = target.health-damage;
        target.armor = target.armor-armorShred;
        int chance = new Random().nextInt(0,100);
        if (chance > 80) target.damage = target.damage-reduceDamage;
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
        this.damage = 3;
    }
    public Warlock(int x, int y) {
        this();
        this.location = new Location(x,y);
    }
}
