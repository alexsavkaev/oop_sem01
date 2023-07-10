package units;

public abstract class Mage extends BaseClass{
    public Mage(){
        super();
        this.resource = "Мана";
        this.attack[0] = super.attack[0]-3;
        this.attack[1] = super.attack[1]-3;
    }
}
