import org.jetbrains.annotations.NotNull;

import java.util.Random;

public abstract class BaseClass {
    private String name;
    private String weapon;
    private String type;
    private int level;
    private int damage;
    private int health;
    private int agility;
    private String resource;
    private int distance;
    private int armor;
    private int armorPenetration;
    private String accessory;
    private boolean state;
    public void Attack(@NotNull BaseClass target){

        int damage = ((this.getDamage()-target.getArmor()/2)+target.Dodge());
        if (damage < 0) damage = 0;
        if (target.getHealth()-damage <= 0) {
            System.out.println(this.getName()+ " атакует " + target.getName()
                    + ", и наносит " + damage + " урона. И убивает его.");
        }
        else System.out.println(this.getName()+ " атакует " + target.getName()
        + ", и наносит " + damage + " урона.");
        target.setHealth(target.getHealth()-damage);
        if(target.getHealth()-damage <= 0) target.setState(false);
    }
    public int Dodge(){
        int chance = new Random().nextInt(0, 100);
        if (chance > 75) return getAgility();
        else return 0;
    }
    public String getState(){
        if (this.state) return "Живой";
        else return "Мёртв";
    }
    public void setState(boolean state){
        this.state = state;
    }
    public void UseAccessory(BaseClass target){
        System.out.println(this.getName() + " использует " + this.getAccessory());
    }
    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setAgility(int agility) {
        this.agility = agility;
    }
    public void setResource(String resource){
        this.resource = resource;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }
    public void setArmorPenetration(int armorPenetration) {
        this.armorPenetration = armorPenetration;
    }
    public void setAccessory(String accessory) {
        this.accessory = accessory;
    }

    public String getType() {
        return type;
    }


    public int getDamage() {
        return damage;
    }

    public int getHealth() {
        return health;
    }

    public int getAgility() {
        return agility;
    }

    public int getDistance() {
        return distance;
    }

    public int getArmor() {
        return armor;
    }

    public int getArmorPenetration() {
        return armorPenetration;
    }

    public String getAccessory() {
        return accessory;
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

    public BaseClass(String name, int level) {
        this(name, "Мужичок", "Энергия", level, 7, 15,
                5, 5, 5, 0, "", true);
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


