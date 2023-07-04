import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Crossbowman extends BaseClass{
    int armorPenetration;
    @Override
    public void Attack(@NotNull BaseClass target){
        int chance = new Random().nextInt(0,100);
        int damage = (this.getDamage()+this.armorPenetration)-(target.getArmor()/2+target.Dodge());
        if(damage <0) damage = 0;
        if (chance > 95)
        System.out.println(this.getName()+ " стреляет в " + target.getName()
                + ", и наносит " + damage + " урона.");
        target.setHealth(target.getHealth() - damage);

    }
    @Override
    public void UseAccessory(BaseClass target){
        System.out.println(this.getName() + " использует " + this.getAccessory());
        this.setArmor(this.getArmor()+new Random().nextInt(3,5));
    }
    public Crossbowman(){
        super();
        this.setAccessory("Щит");
        this.setHealth(super.getHealth()-2);
        this.setDamage(super.getDamage()+5);
        this.setType("Арбалетчик");
        this.setWeapon("Арбалет");
        this.setResource("Болты");
        this.setDistance(15);
        this.armorPenetration = 5;

    }
    public Crossbowman(String name){
        this();
        this.setName(name);
    }
}
