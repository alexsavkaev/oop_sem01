package units;
import java.util.ArrayList;

public interface InGameInterface {
    /**
     * Делает ход.
     * @param enemyTeam команда врагов
     * @param allyTeam команда союзников
     */
    void takeTurn(ArrayList<BaseClass> enemyTeam, ArrayList<BaseClass> allyTeam);
    String getInfo();
    void attack(BaseClass target);
    void useAccessory(BaseClass target);
    boolean dodge();
}
