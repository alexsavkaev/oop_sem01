package units;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Crossbowman extends BaseClass{
    int armorPenetration;
    @Override
    public void Attack(@NotNull BaseClass target){
        int chance = new Random().nextInt(0,100);
        int damage = (this.damage+this.armorPenetration)-(target.armor/2+target.Dodge());
        if(damage <0) damage = 0;
        if (chance > 95) {
            System.out.println(this.name + " стреляет в " + target.name
                    + ", и наносит " + damage + " урона.");
            target.health = target.health - damage;
        }

    }
    @Override
    public void UseAccessory(BaseClass target){
        System.out.println(this.name + " использует " + this.accessory);
        this.armor = this.armor+new Random().nextInt(3,5);
    }
    public Crossbowman(){
        super();
        this.accessory = ("Щит");
        this.health = super.health-2;
        this.damage = super.damage+5;
        this.type = "Арбалетчик";
        this.weapon = "Арбалет";
        this.resource = "Болты";
        this.distance = 15;
        this.armorPenetration = 5;

    }
    public Crossbowman(String name){
        this();
        this.name = name;
    }
}
