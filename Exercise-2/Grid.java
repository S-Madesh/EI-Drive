import java.util.List;

public class Grid implements GridComponent {
    private int width, height;
    private List<Obstacle> obstacles;

    public Grid(int width, int height, List<Obstacle> obstacles) {
        this.width = width;
        this.height = height;
        this.obstacles = obstacles;
    }

    @Override
    public boolean canMoveTo(Position position) {
        return isWithinBounds(position) && !isObstacle(position);
    }

    private boolean isWithinBounds(Position position) {
        return position.x >= 0 && position.x < width && position.y >= 0 && position.y < height;
    }

    private boolean isObstacle(Position position) {
        return obstacles.stream().anyMatch(obstacle -> obstacle.occupies(position));
    }
}
