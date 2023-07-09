package units;
public class Location {
    int x;
    int y;

    @Override
    public String toString() {
        return "[x:"+x+" y:"+y+"]";
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
    public int getDistance(Location targetPosition) {
        return (int) Math.sqrt(Math.pow(this.x - targetPosition.getPosition()[0], 2) + Math.pow(this.y - targetPosition.getPosition()[1], 2));
    }
}
