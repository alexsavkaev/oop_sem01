package units;

import java.util.ArrayList;

public abstract class Melee extends BaseClass{
    @Override
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam) {
        if(!this.alive) return;
        BaseClass target = this.findNearest(enemyTeam);
        if(!this.isInRange(target)) {
            Location setback = this.location;
            this.location.moveTowards(target);
            System.out.printf("%s движется в сторону %s.\n", this.name, target.name);
            if(this.location.isTaken(allyTeam)) this.location = setback;
        }
        else {
            this.attack(target);
        }

    }

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
