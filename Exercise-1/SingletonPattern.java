import java.util.Scanner;

// Singleton Logger Class
class Logger {
    private static Logger instance;
    private StringBuilder log = new StringBuilder();

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        log.append(message).append("\n");
    }

    public void showLog() {
        System.out.println(log.toString());
    }
}

// Example usage
public class SingletonPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        System.out.print("Enter the number of log messages: ");
        int numMessages = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (int i = 0; i < numMessages; i++) {
            System.out.print("Enter log message: ");
            String message = scanner.nextLine();
            logger.log(message);
        }

        System.out.println("\nLog Messages:");
        logger.showLog();

        scanner.close();
    }
}
