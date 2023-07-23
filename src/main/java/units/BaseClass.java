package units;
import java.util.ArrayList;
import java.util.Random;
public abstract class BaseClass implements InGameInterface {
    protected String name;
    protected Location location;
    protected String weapon;
    protected String type;
    protected int maxResource;
    protected boolean free = true;
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
    protected boolean usedAccessory = false;

    public void attack(BaseClass target) {
        if (!target.dodge() && this.isInRange(target)) {
            int damage = (this.getAverageDamage(this.attack) - target.armor / 3);
            System.out.printf("%s(%s) атакует %s, и наносит %d урона.\n",
                    this.name, this.type.charAt(0), target.name, damage);
            target.currentHp -= damage;
            if (target.currentHp <= 0) target.alive = false;
        } else if (target.dodge()) {
            System.out.printf("%s(%s) атакует %s, и промахивается.\n",
                    this.name, this.type.charAt(0), target.name);
        }
    }
    public boolean isInRange(BaseClass target) {
        return this.location.getDistance(target.location) < this.distance;
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
        return this.type;
    }
    public String getInfo() {
        return name + " (" + type + ") - " + "\uD83E\uDDE1" + this.currentHp + "/" + this.health
                + ", \uD83D\uDDF2" + this.initiative +", ⚔"+this.attack[0]+"/"+this.attack[1];
    }
    public Location getCoordinates() {
        return location;
    }
    public int[] getCoords(){
        return location.getPosition();
    }
    /**
     * Ищет ближайшего врага на поле боя, и выводит в консоль результат
     *
     * @param team целевая команда врагов
     */
    public void lookAround(ArrayList<BaseClass> team) {
        BaseClass nearestFoe = findNearest(team);
        System.out.printf("%s оглядывается и замечает %s на расстоянии %d\n", this.name, nearestFoe.toString(),
                location.getDistance(nearestFoe.getCoordinates()));
    }
//    public boolean findPeasant(ArrayList<BaseClass> team) {
//        boolean result = false;
//        for (BaseClass person : team) {
//            if (person.type.equals("Холоп") && person.free) {
//                person.free = false;
//                result = true;
//                break;
//            }
//        }
//        return result;
//    }
    /**
     * Вычисляет средний урон
     *
     * @param attack массив int с min и max атакой
     * @return int средний урон
     */
    public int getAverageDamage(int[] attack) {
        return (attack[0] + attack[1]) / 2;
    }

    /**
     * Находит ближайшего врага в целевой команде
     *
     * @param team целевая команда
     * @return ближайший экземпляр класса BaseClass в целевой команде
     */
    protected BaseClass findNearest(ArrayList<BaseClass> team) {
        BaseClass nearest = team.get(0);
        for (BaseClass person : team) {
            if (person.visible && person.alive) {
                if (location.getDistance(person.getCoordinates()) < location.getDistance(nearest.getCoordinates())) {
                    if(!person.equals(this)){
                    nearest = person;
                    }
                }
            }
        }
        return nearest;
    }
    public boolean isWounded(){
        return this.currentHp < this.health;
    }
    public int getHp(){
        return this.currentHp;
    }
    public boolean isCritical() {
        return this.agility + new Random().nextInt(1, 5) > 10;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public BaseClass() {
        this("Мужичок", "Энергия", 10, 4,
                7, new Random().nextInt(13, 17),
                new Random().nextInt(2, 5), 5,
                5, 0, "Пустой карман", true, 1, 1);
    }

    private BaseClass(String type, String resource, int maxResource,
                      int minAttack, int maxAttack, int health, int agility, int distance,
                      int armor, int armorPenetration, String accessory, boolean alive, int x, int y) {
        this.alive = alive;
        this.name = String.valueOf(Names.values()[new Random().nextInt(Names.values().length)]);
        this.type = type;
        this.currentHp = health;
        this.resource = resource;
        this.currentResource = maxResource;
        this.maxResource = maxResource;
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
}



