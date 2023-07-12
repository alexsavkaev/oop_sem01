package units;

import java.util.ArrayList;

public abstract class Ranged extends BaseClass{
    /**
     * Выполняет свой ход, если живой и есть стрелы. Находит ближайшего противника
     * и использует аксессуар, если противник слишком близко, либо атакует противника.
     * Ищет в своей команде Крестьянина и если не находит - тратит одну стрелу.
     * @param enemyTeam Команда врага
     * @param allyTeam Команда союзника
     */
    @Override
    public void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam) {
        if(!this.alive || this.currentResource <= 0) return;
        this.lookAround(enemyTeam);
        BaseClass target = this.findNearest(enemyTeam);
        if (this.location.getDistance(target.location) < 3) {
            this.useAccessory(this);
            return;
        }
        else if(!this.isInRange(target)) {
            System.out.printf("%s слишком далеко," +
                            "\n",
                    target.name);
            return;
        }
        this.attack(target);
        if(this.visible) this.visible=false;
        if(!this.findPeasant(allyTeam)) this.currentResource -= 1;

        System.out.println(target.name +" "+target.currentHp +"/"+target.health);
        System.out.println(this.currentResource +"/"+ this.maxResource);
    }
    public boolean findPeasant(ArrayList<BaseClass> team) {
        boolean result = false;
        for (BaseClass person : team) {
            if (person.type.equals("Холоп") && person.free) {
                person.free = false;
                result = true;
                break;
            }
        }
        return result;
    }
    @Override
    public void attack(BaseClass target) {
        if (!target.dodge() || this.isInRange(target)){
            int damage = (this.getAverageDamage(this.attack) - target.armor/3);
            if(this.isCritical()) {
                damage *= 1.15;
                System.out.printf("%s атакует %s, и наносит %d критического урона.\n",
                        this.name, target.name, damage);
                target.currentHp -= damage;
            }else{
                System.out.printf("%s атакует %s, и наносит %d урона.\n",
                        this.name, target.name, damage);
                target.currentHp -= damage;
            }
            if(target.currentHp<=0) target.alive = false;
        }
        else if(target.dodge()){
            System.out.printf("%s атакует %s, и промахивается.\n",
                    this.name, target.name);
        }
    }
    @Override
    public String getInfo() {
        return name + " (" + type + ") - " + "\uD83E\uDDE1" + this.currentHp + "/" + this.health
                + ", \uD83D\uDDF2" + this.getInitiative()+", ⚔"+this.attack[0]+"/"+this.attack[1] + ", ➹" +
                this.currentResource + "/"+this.maxResource;
    }
    public Ranged() {
        super();
        this.health = super.health - 2;
        this.currentHp = this.health;
        this.attack[0] = super.attack[0] + 5;
        this.attack[1] = super.attack[1] + 5;
        this.distance = 8;
        this.setInitiative(super.getInitiative() - 10);
        this.currentResource = this.maxResource = 5;
    }

}
