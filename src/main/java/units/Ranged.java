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
        BaseClass target = this.findNearest(enemyTeam);
        if (this.location.getDistanceTo(target.location) < 3) {
            this.useAccessory(this);
            return;
        }
        if(!this.isInRange(target)) {
            this.location.moveTowards(target);
            return;
        }
        if(this.isInRange(target)) {
            this.attack(target);
            System.out.println(target.name +" "+target.currentHp +"/"+target.health);
            System.out.println(this.currentResource +"/"+ this.maxResource);
        }
        if(this.visible) this.visible=false;
        if(!this.findPeasant(allyTeam)) this.currentResource -= 1;


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
        if (!target.dodge() && this.isInRange(target)){
            int damage = (this.getAverageDamage(this.attack) - target.armor/3);
            if(this.isCritical()) {
                damage *= (int) 1.15;
                System.out.printf("%s(%s) атакует %s, и наносит %d критического урона.\n",
                        this.name, this.type.charAt(0), target.name, damage);
                target.currentHp -= damage;
            }else{
                System.out.printf("%s(%s) атакует %s, и наносит %d урона.\n",
                        this.name, this.type.charAt(0), target.name, damage);
                target.currentHp -= damage;
            }
        }
        else if(target.dodge()){
            System.out.printf("%s(%s) атакует %s, и промахивается.\n",
                    this.name, this.type.charAt(0), target.name);
        }
        if(target.currentHp<=0) {
            target.currentHp = 0;
            target.alive = false;
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
