import java.util.*;

// Abstract Class with Template Method
abstract class DataProcessor {
    // Template method
    public final void process() {
        readData();
        processData();
        displayData();
    }

    protected abstract void readData();
    protected abstract void processData();
    protected abstract void displayData();
}

// Concrete Class 1
class TextDataProcessor extends DataProcessor {
    private String data;

    @Override
    protected void readData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text data: ");
        data = scanner.nextLine();
    }

    @Override
    protected void processData() {
        data = data.toUpperCase();
    }

    @Override
    protected void displayData() {
        System.out.println("Processed Text Data: " + data);
    }
}

// Concrete Class 2
class NumberDataProcessor extends DataProcessor {
    private double number;

    @Override
    protected void readData() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        number = scanner.nextDouble();
    }

    @Override
    protected void processData() {
        number = Math.sqrt(number);
    }

    @Override
    protected void displayData() {
        System.out.println("Processed Number Data (Square Root): " + number);
    }
}

// Example usage
public class TemplatePattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting user input for which data processor to use
        System.out.print("Choose data processor (text, number): ");
        String choice = scanner.nextLine();

        DataProcessor processor = null;
        switch (choice.toLowerCase()) {
            case "text":
                processor = new TextDataProcessor();
                break;
            case "number":
                processor = new NumberDataProcessor();
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                scanner.close();
                return;
        }

        // Process the data
        processor.process();

        scanner.close();
    }
}
