package units;

public abstract class Mage extends BaseClass{
    @Override
    public String getInfo() {
        return name + " (" + type + ") - " + "\uD83E\uDDE1" + this.currentHp + "/" + this.health
                + ", \uD83D\uDDF2" + this.getInitiative()+", ⚔"+this.attack[0]+"/"+this.attack[1] + ", \uD83D\uDCA7" +
                this.currentResource + "/"+this.maxResource;
    }
    public Mage(){
        super();
        this.resource = "Мана";
        this.attack[0] = super.attack[0]-3;
        this.attack[1] = super.attack[1]-3;
    }
}
