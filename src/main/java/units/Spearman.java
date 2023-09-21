package units;
import java.util.ArrayList;
import java.util.Random;
public class Spearman extends Melee{
    int armorPenetration;
    @Override
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam) {
        if(!this.alive) return;
        BaseClass target = this.findNearest(enemyTeam);
        if(this.currentHp < this.health && !this.usedAccessory){
            useAccessory(this);
            this.usedAccessory = true;
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
    public void useAccessory(BaseClass target){
        int effect = new Random().nextInt(2,4);
        System.out.println(this.name + " использует " + this.accessory
                + " и увеличивает свою броню на "+effect);
        this.armor = this.armor+effect;
        this.usedAccessory = true;
    }
    public Spearman(){
        super();
        this.armor = super.armor + 5;
        this.accessory = "Баклер";
        this.type = "Копейщик";
        this.weapon = "Копьё";
        this.armorPenetration = 2;
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

