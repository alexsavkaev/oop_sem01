import units.*;

public class Main {


    public static void main(String[] args) {
Peasant bob = new Peasant("Bob");
Sniper steve = new Sniper("Steve");
Rogue jack = new Rogue("Jack");
Spearman kyle = new Spearman("Kyle");
Monk luke = new Monk("Luke");
Crossbowman nate = new Crossbowman("Nate");
Warlock guldan = new Warlock("Gul'dan");
kyle.getStats();
kyle.UseAccessory(kyle);
jack.UseAccessory(bob);
steve.Attack(jack);
luke.Attack(nate);
guldan.Attack(kyle);
guldan.Attack(kyle);
guldan.Attack(kyle);
kyle.getStats();
    }
}
