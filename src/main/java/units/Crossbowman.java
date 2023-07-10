package units;
import java.util.ArrayList;
import java.util.Random;

public class Crossbowman extends Ranged {
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
            this.type = "Арбалетчик";
            this.weapon = "Арбалет";
            this.resource = "Болты";
            this.armorPenetration = 5;
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

