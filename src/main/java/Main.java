import units.*;
import java.util.ArrayList;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
ArrayList<BaseClass> teamRed = new ArrayList<>(10);
ArrayList<BaseClass> teamBlue = new ArrayList<>(10);
fillTeams(teamRed);
fillTeams(teamBlue);
        System.out.println(teamRed);
        System.out.println(teamBlue);
        System.out.println(teamInfo(teamBlue));
        System.out.println(teamInfo(teamRed));

    }
    public static String teamInfo(ArrayList<BaseClass> team){
        StringBuilder info = new StringBuilder();
        for (BaseClass person: team) {
            info.append(person.getInfo()).append(", ");
        }
        info.delete(info.length()-2,info.length()-1);
        return info.toString();
    }
    public static void fillTeams(ArrayList<BaseClass> team) {
        for (int i = 0; i < 10; i++) {
            int cnt = new Random().nextInt(1, 7);
            switch (cnt) {
                case 1 -> team.add(new Monk());
                case 2 -> team.add(new Crossbowman());
                case 3 -> team.add(new Rogue());
                case 4 -> team.add(new Sniper());
                case 5 -> team.add(new Warlock());
                case 6 -> team.add(new Spearman());
                case 7 -> team.add(new Peasant());
            }
        }
    }
//    public static void teamAttack(ArrayList<BaseClass> attackingTeam, ArrayList<BaseClass> underAttack) {

//    }
}
