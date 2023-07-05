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
    public int getDistance(Location targetPosition) {
        return (int) Math.sqrt(Math.pow(x - targetPosition.getPosition()[0], 2) + Math.pow(y - targetPosition.getPosition()[1], 2));
    }
}
