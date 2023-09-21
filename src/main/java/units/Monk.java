package units;
import java.util.ArrayList;
import java.util.Random;

public class Monk extends Melee{
    int statsMultiplier;
    int dodgeMultiplier;
    @Override
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam) {
        if(!this.alive) return;
        BaseClass target = this.findNearest(enemyTeam);
        if(this.currentHp < this.health/2 && !this.usedAccessory){
            useAccessory(this);
            this.usedAccessory = true;
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
        if(!this.usedAccessory) {
            System.out.println(this.name + " использует " + this.accessory +
                    " и увеличивает свои характеристики на " + statsMultiplier);
            this.armor = this.armor + statsMultiplier;
            this.agility = this.agility + statsMultiplier;
            this.attack[0] = this.attack[0] + statsMultiplier;
            this.attack[1] = this.attack[1] + statsMultiplier;
            this.currentHp = this.currentHp + statsMultiplier;
            if (this.currentHp > this.health) this.currentHp = this.health;
            this.usedAccessory = true;
        }
    }
    @Override
    public boolean dodge(){
        int chance = new Random().nextInt(0, 100)+(dodgeMultiplier^2);
        if (chance > 95) {
            this.health=this.health+2;
            return true;
        }
        else return chance > 85 && chance < 95;
    }
    public Monk(){
        super();
        this.armor = 5;
        this.accessory = "Чётки";
        this.agility = super.agility +4;
        this.type = "Монах";
        this.weapon = "Посох";
        this.statsMultiplier = 2;
        this.dodgeMultiplier = 2;
        this.setInitiative(super.getInitiative() -5);
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
