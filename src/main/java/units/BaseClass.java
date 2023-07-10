package units;


import java.util.ArrayList;
import java.util.Random;
public abstract class BaseClass implements InGameInterface {
    protected String name;
    protected Location location;
    protected String weapon;
    protected String type;


    protected int[] attack = new int[2];
    protected int health;
    protected int currentHp;
    protected int agility;
    private int initiative;
    protected String resource;
    protected int currentResource;
    protected int distance;
    protected int armor;
    protected int armorPenetration;
    protected String accessory;
    protected boolean alive;
    protected boolean visible = true;

    public void attack(BaseClass target) {
        if (!target.dodge()){
            int damage = (this.getAverageDamage(this.attack) - target.armor/3);
            System.out.printf("%s атакует %s, и наносит %d урона.\n", this.name, target.name, damage);
            target.currentHp -= damage;
            if(target.currentHp<=0) target.alive = false;
        }
        else if(target.dodge()){
            System.out.printf("%s атакует %s, и промахивается.\n", this.name, target.name);
        }
    }

    public boolean dodge() {
        int chance = new Random().nextInt(0, 100) + this.agility;
        return chance > 85;
    }

    public void useAccessory(BaseClass target) {
        System.out.println(this.name + " использует " + this.accessory);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getInfo() {
        return name +" ("+type + ") - " + "hp: "+this.currentHp+"/"+this.health+", init: "+this.initiative;
    }
    public Location getCoordinates() {
        return location;
    }
    /**
     * Ищет ближайшего врага на поле боя, и выводит в консоль результат
     * @param team  целевая команда врагов
     */
    public void lookAround(ArrayList<BaseClass> team) {
        BaseClass nearestFoe = findNearest(team);
        System.out.printf("%s оглядывается и замечает %s на расстоянии %d\n",this.name, nearestFoe.toString(),
                location.getDistance(nearestFoe.getCoordinates()));
    }
    public boolean findPeasant(ArrayList<BaseClass> team) {
        boolean result = true;
        for (BaseClass person : team) {
            result = person.type.equals("Крестьянин");
        }
        return result;
    }
    public BaseClass() {
        this("Мужичок", "Энергия", 10, 1,
                5, new Random().nextInt(13, 17),
                new Random().nextInt(2, 6), 5,
                5, 0, "Пустой карман", true, 1, 1);
    }

    private BaseClass(String type, String resource, int currentResource,
                      int minAttack, int maxAttack, int health, int agility, int distance,
                      int armor, int armorPenetration, String accessory, boolean alive, int x, int y) {
        this.alive = alive;
        this.name = String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
        this.type = type;
        this.currentHp = health;
        this.resource = resource;
        this.currentResource = currentResource;
        this.attack[0] = minAttack;
        this.attack[1] = maxAttack;
        this.health = health;
        this.agility = agility;
        this.distance = distance;
        this.armor = armor;
        this.armorPenetration = armorPenetration;
        this.accessory = accessory;
        this.location = new Location(x, y);
        this.initiative = new Random().nextInt(20, 50);
    }


    /**
     *
     * Вычисляет средний урон
     * @param attack массив int с min и max атакой
     * @return int средний урон
     */
    public int getAverageDamage(int[] attack){
        return (attack[0]+attack[1])/2;
    }

    /**
     * Находит ближайшего врага в целевой команде
     * @param team целевая команда
     * @return ближайший экземпляр класса BaseClass в целевой команде
     */
    protected BaseClass findNearest(ArrayList<BaseClass> team) {
        BaseClass nearest = team.get(0);
        for (BaseClass person : team) {
            if(person.visible && person.alive) {
                if (location.getDistance(person.getCoordinates()) < location.getDistance(nearest.getCoordinates())) {
                    nearest = person;
                }
            }
        }
        return nearest;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }
}



