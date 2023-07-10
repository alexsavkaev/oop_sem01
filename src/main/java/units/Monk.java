package units;
import java.util.ArrayList;
import java.util.Random;

public class Monk extends Mage{
    int statsMultiplier;
    int dodgeMultiplier;

    @Override
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam) {
    }
    @Override
    public void useAccessory(BaseClass target){
        System.out.println(this.name + " использует " + this.accessory +
                " и увеличивает свои характеристики на " + statsMultiplier);
        this.armor = this.armor+statsMultiplier;
        this.agility = this.agility+statsMultiplier;
        this.attack[0] = super.attack[0]+statsMultiplier;
        this.attack[1] = super.attack[1]+statsMultiplier;
        this.currentHp = this.currentHp+statsMultiplier;
        if(this.currentHp>this.health) this.currentHp=this.health;
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
