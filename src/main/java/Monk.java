import java.util.Random;

public class Monk extends BaseClass{
    int statsMultiplier;
    int dodgeMultiplier;
    @Override
    public void UseAccessory(BaseClass target){
        System.out.println(this.getName() + " использует " + this.getAccessory() +
                " и увеличивает свои характеристики на " + statsMultiplier);
        this.setArmor(this.getArmor()+statsMultiplier);
        this.setAgility(this.getAgility()+statsMultiplier);
        this.setDamage(this.getDamage()+statsMultiplier);
        this.setHealth(this.getHealth()+statsMultiplier);
    }
    @Override
    public int Dodge(){
        int chance = new Random().nextInt(0, 100)+(dodgeMultiplier^2);
        if (chance > 90) {
            this.setHealth(this.getHealth()+2);
            return this.getAgility()+100;
        }
        else if (chance > 75 && chance < 90){
            return this.getAgility();
        }
        else return 0;
    }
    public Monk(){
        super();
        this.setArmor(5);
        this.setAccessory("Чётки");
        this.setHealth(super.getHealth()+5);
        this.setDamage(super.getDamage()+4);
        this.setAgility(super.getAgility()+4);
        this.setType("Монах");
        this.setWeapon("Посох");
        this.statsMultiplier = 3;
        this.dodgeMultiplier = 3;


    }
    public Monk(String name){
        this();
        this.setName(name);
    }
}
