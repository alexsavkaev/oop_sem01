package units;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Spearman extends BaseClass{
    int armorPenetration;
    @Override
    public void Attack(@NotNull BaseClass target){
        int damage = (this.damage+this.armorPenetration)-(target.armor/2+target.Dodge());
        if (damage < 0) damage = 0;
        int chance = new Random().nextInt(0,100);
        System.out.println(this.name+ " стреляет в " + target.name
                + ", и наносит " + damage + " урона.");
        target.health = target.health-damage;
        if(chance>80) this.Attack(target);
    }

    @Override
    public void UseAccessory(BaseClass target){
        int effect = new Random().nextInt(2,4);
        System.out.println(this.name + " использует " + this.accessory
                + " и увеличивает свою броню на "+effect);
        this.armor = this.armor+effect;
    }
    public Spearman(){
        super();
        this.armor = 15;
        this.accessory = "Баклер";
        this.health = super.health+3;
        this.damage = super.damage+3;
        this.type = "Копейщик";
        this.weapon = "Копьё";
        this.armorPenetration = 2;

    }
    public Spearman(String name){
        this();
        this.name = name;
    }
}