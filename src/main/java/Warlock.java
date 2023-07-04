import org.jetbrains.annotations.NotNull;

import java.util.Random;

public class Warlock extends BaseClass{
    int armorShred;
    int reduceDamage;
    @Override
    public void Attack(@NotNull BaseClass target){
        int damage = this.getDamage();
        if (damage <0) damage = 0;
        System.out.println(this.getName()+ " атакует " +target.getName() + ", и наносит "
                + damage + " урона. И снижает броню "+target.getName()+ " на " + armorShred + " единиц.");
        target.setHealth(target.getHealth()-damage);
        target.setArmor(target.getArmor()-armorShred);
        int chance = new Random().nextInt(0,100);
        if (chance > 80) target.setDamage(target.getDamage()-reduceDamage);
    }
    @Override
    public void UseAccessory(BaseClass target){
        int soak = new Random().nextInt(0,4);
        System.out.println(this.getName() + " использует " + this.getAccessory()+
                " и высасывает у " + target.getName() + soak + " здоровья.");
        target.setHealth(target.getHealth() - soak);
        this.setHealth(this.getHealth() + soak);
    }
    public Warlock(){
        super();
        this.setAccessory("Жертвенная чаша");
        this.setHealth(super.getHealth()-2);
        this.setType("Колдун");
        this.setWeapon("Гримуар");
        this.setDistance(15);
        this.setResource("Мана");
        this.armorShred = 3;
        this.reduceDamage = 3;
        this.setDamage(3);
    }
    public Warlock(String name){
        this();
        this.setName(name);
    }
}
