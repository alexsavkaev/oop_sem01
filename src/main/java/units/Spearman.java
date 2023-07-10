package units;

import java.util.ArrayList;
import java.util.Random;
public class Spearman extends BaseClass{
    int armorPenetration;
    @Override
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam) {    }
    @Override
    public void useAccessory(BaseClass target){
        int effect = new Random().nextInt(2,4);
        System.out.println(this.name + " использует " + this.accessory
                + " и увеличивает свою броню на "+effect);
        this.armor = this.armor+effect;
    }
    public Spearman(){
        super();
        this.armor = 15;
        this.accessory = "Баклер";
        this.health = super.health+3;
        this.attack[0] = super.attack[0]+3;
        this.attack[1] = super.attack[1]+3;
        this.type = "Копейщик";
        this.weapon = "Копьё";
        this.armorPenetration = 2;
        this.currentHp = this.health;
    }
    /**
     * Создаёт копейщика с заданными координатами:
     * @param x x
     * @param y y
     */
    public Spearman(int x, int y) {
        this();
        this.location = new Location(x,y);
    }
}

