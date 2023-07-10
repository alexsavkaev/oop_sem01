import units.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
ArrayList<BaseClass> teamRed = new ArrayList<>(10);
ArrayList<BaseClass> teamBlue = new ArrayList<>(10);
ArrayList<BaseClass> teams = new ArrayList<>();
fillTeams(teamRed,0);
fillTeams(teamBlue,9);
teams.addAll(teamRed);
teams.addAll(teamBlue);
sortTeam(teams);
        System.out.println("Red team:\n"+teamRed);
        System.out.println("---------");
        System.out.println("Blue team:\n"+teamBlue);
        System.out.println("---------");
        System.out.println(teamInfo(teamRed));
        System.out.println("---------");
        System.out.println(teamInfo(teamBlue));
        System.out.println("---------");
        for (BaseClass person:teams) {
            if(teamBlue.contains(person)){
                person.takeTurn(teamRed,teamBlue);
            }
            else person.takeTurn(teamBlue, teamRed);
        }
    }
    /**
     * Выводит информацию о команде строкой типа: "Имя (Класс) - hp: current/max, init: init"
     */
    public static String teamInfo(ArrayList<BaseClass> team){
        StringBuilder info = new StringBuilder();
        for (BaseClass person: team) {
            info.append(person.getInfo()).append("\n");
        }
        return info.toString();
    }

    /**
     * Сортирует команду по параметру initiative
     * @param team целевая команда для сортировки ArrayList<BaseClass>
     */
    public static void sortTeam(ArrayList<BaseClass> team){
        team.sort(Comparator.comparingInt(BaseClass::getInitiative));
    }
    /**
     * Заполняет команду случайным классом
     * @param team целевая команда
     * @param xPos позиция, на которой появится персонаж
     */
    public static void fillTeams(ArrayList<BaseClass> team, int xPos) {
        for (int i = 0; i < 10; i++) {
            int cnt = new Random().nextInt(1, 7);
            int pos = new Random().nextInt(0,2); // Небольшой элемент рандома при позиционировании
            if(xPos>5) pos *= -1;                            // Чтобы вторая команда не появлялась за полем 10*10
            switch (cnt) {
                case 1 -> team.add(new Monk(xPos+pos,i));
                case 2 -> team.add(new Crossbowman(xPos+pos,i));
                case 3 -> team.add(new Rogue(xPos+pos,i));
                case 4 -> team.add(new Sniper(xPos+pos,i));
                case 5 -> team.add(new Warlock(xPos+pos,i));
                case 6 -> team.add(new Spearman(xPos+pos,i));
                case 7 -> team.add(new Peasant(xPos+pos,i));
            }
        }
    }
}
