package units;
import java.util.ArrayList;
import java.util.Random;

public class Crossbowman extends BaseClass {
    int armorPenetration;

    @Override
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam) {  }


    @Override
    public void useAccessory (BaseClass target){
        System.out.println(this.name + " использует " + this.accessory);
        this.armor = this.armor + new Random().nextInt(3, 5);
    }
    public Crossbowman() {
            super();
            this.accessory = ("Щит");
            this.health = super.health - 2;
            this.attack[0] = super.attack[0] + 5;
            this.attack[1] = super.attack[1] + 5;
            this.type = "Арбалетчик";
            this.weapon = "Арбалет";
            this.resource = "Болты";
            this.distance = 15;
            this.armorPenetration = 5;
            this.setInitiative(super.getInitiative() + 10);
            this.currentHp = this.health;

        }

    /**
     * Создаёт арбалетчика с заданными координатами
     * @param x x
     * @param y y
     */
    public Crossbowman( int x, int y){
            this();
            this.location = new Location(x, y);
        }
    }

