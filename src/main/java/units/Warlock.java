package units;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Random;

public class Warlock extends Mage{
    int armorShred;
    int reduceDamage;

    @Override
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam){    }
    @Override
    public void attack(@NotNull BaseClass target){
        int damage = this.getAverageDamage(this.attack);
        int chance = new Random().nextInt(0,100);
        if (damage <0) damage = 0;
        System.out.println(this.name+ " атакует " +target.name + ", и наносит "
                + damage + " урона. ");
        target.currentHp -= damage;
        if (chance > 80) {
            target.attack[0] -= reduceDamage;
            target.attack[1] -= reduceDamage;
            target.armor -= armorShred;
            System.out.printf("И снижает броню на %d, а атаку на %d", armorShred, reduceDamage);
        }
    }
    @Override
    public void useAccessory(BaseClass target){
        int soak = new Random().nextInt(0,4);
        System.out.println(this.name + " использует " + this.accessory+
                " и высасывает у " + target.name + soak + " здоровья.");
        target.currentHp -= soak;
        this.currentHp += soak;
        if(this.currentHp>this.health) this.currentHp=this.health;
    }

    public Warlock(){
        super();
        this.accessory = "Жертвенная чаша";
        this.health = super.health-2;
        this.type = "Чародей";
        this.weapon = "Гримуар";
        this.distance = 15;
        this.armorShred = 3;
        this.reduceDamage = 3;
        this.setInitiative(super.getInitiative() +10);
        this.currentHp = this.health;
    }
    /**
     * Создаёт колдуна с заданными координатами:
     * @param x x
     * @param y y
     */
    public Warlock(int x, int y) {
        this();
        this.location = new Location(x,y);
    }
}
