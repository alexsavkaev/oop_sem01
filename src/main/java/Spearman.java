import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Spearman extends BaseClass{
    int armorPenetration;
    @Override
    public void Attack(@NotNull BaseClass target){
        int damage = (this.getDamage()+this.armorPenetration)-(target.getArmor()/2+target.Dodge());
        if (damage < 0) damage = 0;
        int chance = new Random().nextInt(0,100);
        System.out.println(this.getName()+ " стреляет в " + target.getName()
                + ", и наносит " + damage + " урона.");
        target.setHealth(target.getHealth()-damage);
        if(chance>80) this.Attack(target);
    }

    @Override
    public void UseAccessory(BaseClass target){
        int effect = new Random().nextInt(2,4);
        System.out.println(this.getName() + " использует " + this.getAccessory()
                + " и увеличивает свою броню на "+effect);
        this.setArmor(this.getArmor()+effect);
    }
    public Spearman(){
        super();
        this.setArmor(15);
        this.setAccessory("Баклер");
        this.setHealth(super.getHealth()+3);
        this.setDamage(super.getDamage()+3);
        this.setType("Копейщик");
        this.setWeapon("Копьё");
        this.armorPenetration = 2;

    }
    public Spearman(String name){
        this();
        this.setName(name);
    }
}
