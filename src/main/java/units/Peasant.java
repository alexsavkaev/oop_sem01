package units;

public class Peasant extends BaseClass{
    public Peasant(){
        super();
        this.accessory = "Крынка молока";
        this.agility = super.agility-2;
        this.health = super.health+5;
        this.damage = super.damage-2;
        this.type = "Крестьянин";
        this.weapon = "Вилы";
    }
    public Peasant(String name) {
        this();
        this.name = name;
    }


}
