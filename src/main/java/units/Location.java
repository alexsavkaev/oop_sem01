package units;

import java.util.ArrayList;

public class Location {
    int x;
    int y;

    @Override
    public String toString() {
        return "[x:"+x+" y:"+y+"]";
    }
    public void moveTowards(BaseClass target) {
        int dx = target.location.x - this.x;
        int dy = target.location.y - this.y;
        if (Math.abs(dx) > Math.abs(dy)) {
            moveTowardsVertical(target);
        } else {
            moveTowardsHorizontal(target);
        }
    }

    private void moveTowardsVertical(BaseClass target) {
        if((target.location.x - x) < 0) this.x -= 1;
        else x +=1;
    }

    private void moveTowardsHorizontal(BaseClass target) {
        if((target.location.y - y) < 0) this.y -= 1;
        else y +=1;
    }
    public boolean isTaken(ArrayList<BaseClass> team) {
        boolean result = false;
        for (BaseClass person:team) {
            result = person.location.x== this.x;
            if(result) break;
        }
        return result;
    }
    public int[] getPosition() {
        return new int[]{x, y};
    }
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }

    /**
     * Рассчитывает расстояние между двумя персонажами
     * @param targetPosition координаты цели
     * @return int расстояние
     */
    public int getDistanceTo(Location targetPosition) {
        return (int) Math.sqrt(Math.pow(this.x - targetPosition.getPosition()[0], 2) + Math.pow(this.y - targetPosition.getPosition()[1], 2));
    }
}
