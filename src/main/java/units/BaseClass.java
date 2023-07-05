package units;

import org.jetbrains.annotations.NotNull;

import java.util.Random;

public abstract class BaseClass {
    protected String name;
    protected String weapon;
    protected String type;
    protected int level;
    protected int damage;
    protected int health;
    protected int agility;
    protected String resource;
    protected int distance;
    protected int armor;
    protected int armorPenetration;
    protected String accessory;
    protected boolean state;
    public void Attack(@NotNull BaseClass target){

        int damage = ((this.damage-target.armor/2)+target.Dodge());
        if (damage < 0) damage = 0;
        if (target.health-damage <= 0) {
            System.out.println(this.name+ " атакует " + target.name
                    + ", и наносит " + damage + " урона. И убивает его.");
        }
        else System.out.println(this.name+ " атакует " + target.name
        + ", и наносит " + damage + " урона.");
        target.health = target.health-damage;
        if(target.health-damage <= 0) target.state = false;
    }
    public int Dodge(){
        int chance = new Random().nextInt(0, 100);
        if (chance > 75) return agility;
        else return 0;
    }
    public void UseAccessory(BaseClass target){
        System.out.println(this.name + " использует " + this.accessory);
    }
public void getStats(){
    System.out.println("Имя: "+ name + ", Здоровье: " + health+", Урон: "+ damage +", Броня: "+ armor);
}
    public void getAllStats() {
        System.out.println("Имя: "+ name + ", Уровень: " + level +", Здоровье: " + health
                +", Класс: "+ type +", Оружие: " +weapon+
                ", Урон: "+ damage +", Ловкость: "+ agility +", Ресурс: " + resource
                +", Дистанция: " + distance +", Броня: "+ armor
                +", Пробивание брони: "+ armorPenetration + ", Аксессуар: " + accessory);
    }
    public BaseClass(){
        this("Безымянный", "Мужичок", "Энергия",0,
                new Random().nextInt(6,8), new Random().nextInt(13,17),
                new Random().nextInt(4,7), 5,
                5, 0, "Пустой карман", true);
    }

    private BaseClass(String name, String type, String resource, int level,
                      int damage, int health, int agility, int distance,
                      int armor, int armorPenetration, String accessory, boolean state) {
        this.name = name;
        this.type = type;
        this.resource = resource;
        this.level = level;
        this.damage = damage;
        this.health = health;
        this.agility = agility;
        this.distance = distance;
        this.armor = armor;
        this.armorPenetration = armorPenetration;
        this.accessory = accessory;
        this.state = true;
    }
}


