package units;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Rogue extends BaseClass{
    private final int dodgeMultiplier;
    @Override
    public int Dodge(){
        int chance = new Random().nextInt(0, 100)+(dodgeMultiplier^2);
        if (chance > 75) return this.agility;
        else return 0;
    }

    public void UseAccessory(@NotNull BaseClass target){
        int damage = this.damage/2- target.Dodge();
        System.out.println(this.name + " бросает " + this.accessory + ", и наносит "
                + target.name +" "+ damage + " урона.");
        target.health = target.health-damage;
    }
    public Rogue(){
        super();
        this.armor = 10;
        this.accessory = "Метательный нож";
        this.agility = super.agility+2;
        this.health = super.health-2;
        this.damage = super.damage+4;
        this.type = "Разбойник";
        this.weapon = "Ножи";
        this.dodgeMultiplier = 3;
    }
    public Rogue(String name){
        this();
        this.name = name;
    }
}
