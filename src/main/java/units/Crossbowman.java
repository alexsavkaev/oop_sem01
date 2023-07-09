package units;
import java.util.ArrayList;
import java.util.Random;

public class Crossbowman extends BaseClass {
    int armorPenetration;

    @Override
    public void step(ArrayList<BaseClass> team) {  }
        @Override
        public void attack (BaseClass target){
            int chance = new Random().nextInt(0, 100);
            int damage = (this.damage + this.armorPenetration) - (target.armor / 2 + target.dodge());
            if (damage < 0) damage = 0;
            if (chance > 95) {
                System.out.println(this.name + " стреляет в " + target.name
                        + ", и наносит " + damage + " урона.");
                target.health = target.health - damage;
            }

        }
        @Override
        public void useAccessory (BaseClass target){
            System.out.println(this.name + " использует " + this.accessory);
            this.armor = this.armor + new Random().nextInt(3, 5);
        }
    public Crossbowman() {
            super();
            this.accessory = ("Щит");
            this.health = super.health - 2;
            this.damage = super.damage + 5;
            this.type = "Арбалетчик";
            this.weapon = "Арбалет";
            this.resource = "Болты";
            this.distance = 15;
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

