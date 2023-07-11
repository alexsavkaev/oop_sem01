package units;

import java.util.ArrayList;
import java.util.Random;

public class Sniper extends Ranged {
    private final int dodgeMultiplier;
    @Override
    public boolean dodge(){
        int chance = new Random().nextInt(0, 100)+(dodgeMultiplier^2);
        return chance > 80;
    }

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
            this.attack(target);
            if(this.visible) this.visible=false;
            if(!this.findPeasant(allyTeam)) this.currentResource -= 1;
        System.out.println(target.name +" "+target.currentHp +"/"+target.health);
        System.out.println(this.currentResource +"/"+ this.maxResource);
        }

    @Override
    public void useAccessory(BaseClass target){
        System.out.println(this.name + " использует " + this.accessory
                + " и исчезает с поля зрения всех врагов");
        this.visible = false;
    }

    public Sniper(){
        super();
        this.accessory = "Камуфляж";
        this.agility = super.agility+3;
        this.type = "Снайпер";
        this.weapon = "Длинный лук";
        this.resource = "Стрелы";
        this.dodgeMultiplier = 2;
    }
    /**
     * Создаёт снайпера с заданными координатами:
     * @param x x
     * @param y y
     */
    public Sniper(int x, int y) {
        this();
        this.location = new Location(x,y);
    }
}
