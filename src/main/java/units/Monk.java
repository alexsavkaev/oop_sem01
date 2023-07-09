package units;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class Monk extends BaseClass{
    int statsMultiplier;
    int dodgeMultiplier;

    @Override
    public void step(ArrayList<BaseClass> team) {
    }
    @Override
    public void attack(@NotNull BaseClass target) {
    }
    @Override
    public void useAccessory(BaseClass target){
        System.out.println(this.name + " использует " + this.accessory +
                " и увеличивает свои характеристики на " + statsMultiplier);
        this.armor = this.armor+statsMultiplier;
        this.agility = this.agility+statsMultiplier;
        this.damage = this.damage+statsMultiplier;
        this.health = this.health+statsMultiplier;
    }
    @Override
    public int dodge(){
        int chance = new Random().nextInt(0, 100)+(dodgeMultiplier^2);
        if (chance > 90) {
            this.health=this.health+2;
            return this.agility+100;
        }
        else if (chance > 75 && chance < 90){
            return this.agility;
        }
        else return 0;
    }
    public Monk(){
        super();
        this.armor = 5;
        this.accessory = "Чётки";
        this.health = super.health+5;
        this.damage = super.damage +4;
        this.agility = super.agility +4;
        this.type = "Монах";
        this.weapon = "Посох";
        this.statsMultiplier = 3;
        this.dodgeMultiplier = 3;


    }

    /**
     * Создаёт монаха с заданными координатами:
     * @param x x
     * @param y y
     */
    public Monk(int x, int y) {
        this();
        this.location = new Location(x,y);
    }
}
