import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MarsRoverSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get grid size
        System.out.print("Enter grid width: ");
        int width = scanner.nextInt();
        System.out.print("Enter grid height: ");
        int height = scanner.nextInt();

        // Get starting position
        System.out.print("Enter starting X position (0 to " + (width - 1) + "): ");
        int startX = scanner.nextInt();
        System.out.print("Enter starting Y position (0 to " + (height - 1) + "): ");
        int startY = scanner.nextInt();
        System.out.print("Enter starting direction (N, S, E, W): ");
        Direction startDirection = Direction.valueOf(scanner.next().toUpperCase());

        // Get obstacles
        List<Obstacle> obstacles = new ArrayList<>();
        System.out.print("Enter number of obstacles: ");
        int numObstacles = scanner.nextInt();
        for (int i = 0; i < numObstacles; i++) {
            System.out.print("Enter obstacle " + (i + 1) + " X position (0 to " + (width - 1) + "): ");
            int obsX = scanner.nextInt();
            System.out.print("Enter obstacle " + (i + 1) + " Y position (0 to " + (height - 1) + "): ");
            int obsY = scanner.nextInt();
            obstacles.add(new Obstacle(obsX, obsY));
        }

        // Create grid and rover
        Grid grid = new Grid(width, height, obstacles);
        Rover rover = new Rover(new Position(startX, startY, startDirection), grid);

        // Get commands
        List<Command> commands = new ArrayList<>();
        System.out.print("Enter commands (M for move, L for turn left, R for turn right, separated by spaces): ");
        scanner.nextLine();  // Consume newline
        String[] commandInput = scanner.nextLine().split(" ");
        for (String cmd : commandInput) {
            switch (cmd.toUpperCase()) {
                case "M":
                    commands.add(new MoveCommand(rover));
                    break;
                case "L":
                    commands.add(new TurnLeftCommand(rover));
                    break;
                case "R":
                    commands.add(new TurnRightCommand(rover));
                    break;
                default:
                    System.out.println("Invalid command: " + cmd);
                    break;
            }
        }

        // Execute commands
        for (Command command : commands) {
            command.execute();
        }

        // Final position and status report
        Position finalPosition = rover.getPosition();
        System.out.printf("Final Position: (%d, %d, %s)%n",
                          finalPosition.x, finalPosition.y, finalPosition.direction);
        System.out.printf("Status Report: Rover is at (%d, %d) facing %s.%n",
                          finalPosition.x, finalPosition.y, finalPosition.direction);

        scanner.close();
    }
}
