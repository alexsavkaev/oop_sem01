package units;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class Monk extends BaseClass{
    int statsMultiplier;
    int dodgeMultiplier;

    @Override
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam) {
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
        this.attack[0] = super.attack[0]+statsMultiplier;
        this.attack[1] = super.attack[1]+statsMultiplier;
        this.health = this.health+statsMultiplier;
    }
    @Override
    public boolean dodge(){
        int chance = new Random().nextInt(0, 100)+(dodgeMultiplier^2);
        if (chance > 98) {
            this.health=this.health+2;
            return true;
        }
        else return chance > 85 && chance < 94;
    }
    public Monk(){
        super();
        this.armor = 5;
        this.accessory = "Чётки";
        this.health = super.health+5;
        this.attack[0] = super.attack[0]+4;
        this.attack[1] = super.attack[1]+4;
        this.agility = super.agility +4;
        this.type = "Монах";
        this.weapon = "Посох";
        this.statsMultiplier = 3;
        this.dodgeMultiplier = 3;
        this.setInitiative(super.getInitiative() +5);
        this.currentHp = this.health;
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
