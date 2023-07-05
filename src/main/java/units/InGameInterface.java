package units;

import org.jetbrains.annotations.NotNull;

public interface InGameInterface {
    void step();
    String getInfo();


    void attack(@NotNull BaseClass target);
    void useAccessory(BaseClass target);
    int dodge();
}
