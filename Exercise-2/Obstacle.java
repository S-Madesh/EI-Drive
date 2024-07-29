public class Obstacle implements GridComponent {
    private Position position;

    public Obstacle(int x, int y) {
        this.position = new Position(x, y, null);
    }

    @Override
    public boolean canMoveTo(Position position) {
        return !occupies(position);
    }

    public boolean occupies(Position position) {
        return this.position.x == position.x && this.position.y == position.y;
    }
}
