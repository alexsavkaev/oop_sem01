package units;

import java.util.Random;

public class Sniper extends Ranged {
    private final int dodgeMultiplier;
    @Override
    public boolean dodge(){
        int chance = new Random().nextInt(0, 100)+(dodgeMultiplier^2);
        return chance > 80;
    }
    @Override
    public void useAccessory(BaseClass target){
        if(!this.usedAccessory) {
            System.out.println(this.name + " использует " + this.accessory
                    + " и исчезает с поля зрения всех врагов");
            this.visible = false;
            this.usedAccessory = true;
        }
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
