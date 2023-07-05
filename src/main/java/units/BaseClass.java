package units;


import java.util.ArrayList;
import java.util.Random;
public abstract class BaseClass implements InGameInterface {
    protected String name;
    protected Location location;
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

    public void attack(BaseClass target) {
        int damage = ((this.damage - (target.armor / 2)) + target.dodge());
        if (damage < 0) damage = 0;
        if (target.health - damage <= 0) {
            System.out.println(this.name + " атакует " + target.name
                    + ", и наносит " + damage + " урона. И убивает его.");
        } else System.out.println(this.name + " атакует " + target.name
                + ", и наносит " + damage + " урона.");
        target.health = target.health - damage;
        if (target.health - damage <= 0) target.state = false;
    }

    public int dodge() {
        int chance = new Random().nextInt(0, 100);
        if (chance > 75) return agility;
        else return 0;
    }

    public void useAccessory(BaseClass target) {
        System.out.println(this.name + " использует " + this.accessory);
    }

    @Override
    public String toString() {
        return this.name;
    }

    public String getInfo() {
        return type + " - " + location.toString();
    }
    public Location getCoordinates() {
        return location;
    }
    /**
     * Ищет ближайшего врага на поле боя
     * @param team  целевая команда врагов
     */
    public void lookAround(ArrayList<BaseClass> team) {
        BaseClass nearestFoe = findNearest(team);
        System.out.printf("%s оглядывается и замечает %s на расстоянии %d\n",this.name, nearestFoe.toString(),
                location.getDistance(nearestFoe.getCoordinates()));
    }
    public BaseClass() {
        this("Мужичок", "Энергия", 0,
                new Random().nextInt(6, 8), new Random().nextInt(13, 17),
                new Random().nextInt(4, 7), 5,
                5, 0, "Пустой карман", true, 1, 1);
    }

    private BaseClass(String type, String resource, int level,
                      int damage, int health, int agility, int distance,
                      int armor, int armorPenetration, String accessory, boolean state, int x, int y) {
        this.name = String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
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
        this.location = new Location(x, y);
    }

    protected BaseClass findNearest(ArrayList<BaseClass> team) {
        BaseClass nearest = team.get(0);
        for (BaseClass character : team) {
            if (location.getDistance(character.getCoordinates()) < location.getDistance(nearest.getCoordinates())) {
                nearest = character;
            }
        }
        return nearest;
    }

}



