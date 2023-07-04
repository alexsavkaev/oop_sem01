import java.util.Random;

public class Sniper extends BaseClass{
    private final int dodgeMultiplier;
    boolean visible;
    @Override
    public int Dodge(){
        int chance = new Random().nextInt(0, 100)+(dodgeMultiplier^2);
        if (chance > 75) return getAgility();
        else return 0;
    }
    @Override
    public void UseAccessory(BaseClass target){
        System.out.println(this.getName() + " использует " + this.getAccessory()
                + "и исчезает с поля зрения всех врагов");
        visible = false;
    }
    public Sniper(){
        super();
        this.setAccessory("Камуфляж");
        this.setAgility(super.getAgility()+2);
        this.setHealth(super.getHealth()-2);
        this.setDamage(super.getDamage()+5);
        this.setType("Снайпер");
        this.setWeapon("Длинный лук");
        this.setResource("Стрелы");
        this.setDistance(15);
        this.visible = true;
        this.dodgeMultiplier = 3;
    }
    public Sniper(String name){
        this();
        this.setName(name);
    }
}
