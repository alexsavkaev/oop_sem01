package units;

import java.util.ArrayList;
import java.util.Random;

public class Peasant extends Melee{
    public Peasant(){
        super();
        this.accessory = "Крынка молока";
        this.agility = super.agility-2;
        this.type = "Крестьянин";
        this.weapon = "Вилы";
        this.setInitiative(super.getInitiative() -5);
        this.currentHp = this.health;
    }
    /**
     * Создаёт крестьянина с заданными координатами:
     * @param x x
     * @param y y
     */
    public Peasant(int x, int y) {
        this();
        this.location = new Location(x,y);
    }


    @Override
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam) {   }

    @Override
    public void useAccessory(BaseClass target) {
        int effect = new Random().nextInt(2,4);
        System.out.println(this.name + " использует " + this.accessory
                + " и увеличивает своё здоровье на "+effect);
        this.health = this.health+effect;
    }
}
