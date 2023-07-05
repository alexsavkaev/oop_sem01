package units;

import java.util.ArrayList;
import java.util.Random;

public class Peasant extends BaseClass{
    public Peasant(){
        super();
        this.accessory = "Крынка молока";
        this.agility = super.agility-2;
        this.health = super.health+5;
        this.damage = super.damage-2;
        this.type = "Крестьянин";
        this.weapon = "Вилы";
    }
    public Peasant(int x, int y) {
        this();
        this.location = new Location(x,y);
    }


    @Override
    public void step(ArrayList<BaseClass> team) {   }

    @Override
    public void useAccessory(BaseClass target) {
        int effect = new Random().nextInt(2,4);
        System.out.println(this.name + " использует " + this.accessory
                + " и увеличивает своё здоровье на "+effect);
        this.health = this.health+effect;
    }
}
