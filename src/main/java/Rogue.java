import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Rogue extends BaseClass{
    private final int dodgeMultiplier;
    @Override
    public int Dodge(){
        int chance = new Random().nextInt(0, 100)+(dodgeMultiplier^2);
        if (chance > 75) return getAgility();
        else return 0;
    }

    public void UseAccessory(@NotNull BaseClass target){
        int damage = this.getDamage()/2- target.Dodge();
        System.out.println(this.getName() + " бросает " + this.getAccessory() + ", и наносит "
                + target.getName() +" "+ damage + " урона.");
        target.setHealth(target.getHealth()-damage);
    }
    public Rogue(){
        super();
        this.setArmor(10);
        this.setAccessory("Метательный нож");
        this.setAgility(super.getAgility()+2);
        this.setHealth(super.getHealth()-2);
        this.setDamage(super.getDamage()+4);
        this.setType("Разбойник");
        this.setWeapon("Ножи");
        this.dodgeMultiplier = 3;
    }
    public Rogue(String name){
        this();
        this.setName(name);
    }
}
