package units;

public abstract class Melee extends BaseClass{
    public Melee(){
        super();
        this.health = super.health+5;
        this.currentHp = this.health;
        this.attack[0] = super.attack[0]+3;
        this.attack[1] = super.attack[1]+3;
        this.distance = 1;
        this.armor = super.armor + 10;
    }
}
