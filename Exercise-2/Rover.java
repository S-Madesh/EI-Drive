public class Rover {
    private Position position;
    private Grid grid;

    public Rover(Position position, Grid grid) {
        this.position = position;
        this.grid = grid;
    }

    public void move() {
        Position newPosition = position.moveForward();
        if (grid.canMoveTo(newPosition)) {
            position = newPosition;
        }
    }

    public void turnLeft() {
        position.direction = position.direction.left();
    }

    public void turnRight() {
        position.direction = position.direction.right();
    }

    public Position getPosition() {
        return position;
    }
}
