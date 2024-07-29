public class Position {
    int x, y;
    Direction direction;

    public Position(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public Position moveForward() {
        return switch (direction) {
            case N -> new Position(x, y + 1, direction);
            case S -> new Position(x, y - 1, direction);
            case E -> new Position(x + 1, y, direction);
            case W -> new Position(x - 1, y, direction);
        };
    }
}
