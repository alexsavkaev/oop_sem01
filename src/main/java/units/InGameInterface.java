package units;
import java.util.ArrayList;

public interface InGameInterface {
    void step(ArrayList<BaseClass> team);
    String getInfo();
    void attack(BaseClass target);
    void useAccessory(BaseClass target);
    int dodge();
}
