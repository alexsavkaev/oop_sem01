public class Peasant extends BaseClass{
    public Peasant(){
        super();
        this.setAccessory("Крынка молока");
        this.setAgility(super.getAgility()-2);
        this.setHealth(super.getHealth()+5);
        this.setDamage(super.getDamage()-2);
        this.setType("Крестьянин");
        this.setWeapon("Вилы");
    }
    public Peasant(String name) {
        this();
        this.setName(name);
    }


}
