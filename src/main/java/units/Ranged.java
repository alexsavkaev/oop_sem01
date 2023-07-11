package units;

public abstract class Ranged extends BaseClass{
    @Override
    public void attack(BaseClass target) {
        if (!target.dodge() || this.inRange(target)){
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
        }else if(!this.inRange(target)) System.out.printf("%s слишком далеко," +
                        " %s хочет подойти ближе, но пока не умеет\n",
                target.name, this.name);
    }
    public Ranged() {
        super();
        this.health = super.health - 2;
        this.currentHp = this.health;
        this.attack[0] = super.attack[0] + 5;
        this.attack[1] = super.attack[1] + 5;
        this.distance = 8;
        this.setInitiative(super.getInitiative() + 10);
        this.currentResource = 5;
    }

}
