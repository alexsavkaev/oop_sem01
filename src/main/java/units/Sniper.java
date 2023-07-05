package units;

import java.util.Random;

public class Sniper extends BaseClass{
    private final int dodgeMultiplier;
    boolean visible;
    @Override
    public int Dodge(){
        int chance = new Random().nextInt(0, 100)+(dodgeMultiplier^2);
        if (chance > 75) return this.agility;
        else return 0;
    }
    @Override
    public void UseAccessory(BaseClass target){
        System.out.println(this.name + " использует " + this.accessory
                + "и исчезает с поля зрения всех врагов");
        visible = false;
    }
    public Sniper(){
        super();
        this.accessory = "Камуфляж";
        this.agility = super.agility+2;
        this.health = super.health-2;
        this.damage = super.damage+5;
        this.type = "Снайпер";
        this.weapon = "Длинный лук";
        this.resource = "Стрелы";
        this.distance = 15;
        this.visible = true;
        this.dodgeMultiplier = 3;
    }
    public Sniper(String name){
        this();
        this.name = name;
    }
}
