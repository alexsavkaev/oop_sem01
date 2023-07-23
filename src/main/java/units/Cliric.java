package units;

import java.util.ArrayList;

public class Cliric extends Mage{
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam){
        if(!this.alive || this.currentResource <= 0) return;
        BaseClass target = this.findNearestWounded(allyTeam);
        if(target.currentHp == target.health) {
            findNearest(allyTeam).armor += 3;
            System.out.printf("%s не видит раненых союзников и воодушевляет %s, повышая броню.\n",
                    this.name, findNearest(allyTeam).name);
            return;
        }
        int heal = this.getAverageDamage(this.attack);
        target.currentHp += heal;
        this.currentResource -= heal;
        System.out.printf("%s исцеляет раны %s на %d\n", this.name, target.name, this.currentResource/2);
    }

    protected BaseClass findNearestWounded(ArrayList<BaseClass> team) {
        BaseClass nearestWounded = team.get(0);
        for (BaseClass person : team) {
            if (person.visible && person.alive && person.isWounded()) {
                if (location.getDistance(person.getCoordinates()) < location.getDistance(nearestWounded.getCoordinates())) {
                    nearestWounded = person;
                }
            }
        }
        return nearestWounded;
    }
    public Cliric(){
        super();
        this.accessory = "Странная книга";
        this.health = super.health-2;
        this.type = "Целитель";
        this.weapon = "Кадило";
        this.distance = 15;
        this.setInitiative(super.getInitiative() +10);
        this.currentHp = this.health;
    }
    public Cliric(int x, int y) {
        this();
        this.location = new Location(x,y);
}
}