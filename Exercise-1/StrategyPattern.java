import java.util.Scanner;

// Strategy Interface
interface Strategy {
    double execute(double a, double b);
}

// Concrete Strategies
class Add implements Strategy {
    @Override
    public double execute(double a, double b) {
        return a + b;
    }
}

class Subtract implements Strategy {
    @Override
    public double execute(double a, double b) {
        return a - b;
    }
}

class Multiply implements Strategy {
    @Override
    public double execute(double a, double b) {
        return a * b;
    }
}

class Divide implements Strategy {
    @Override
    public double execute(double a, double b) {
        return a / b;
    }
}

// Context
class Calculator {
    private Strategy strategy;

    public Calculator(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double execute(double a, double b) {
        return strategy.execute(a, b);
    }
}

// Example usage
public class StrategyPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Getting user input for operation
        System.out.print("Choose operation (add, subtract, multiply, divide): ");
        String operation = scanner.nextLine();

        // Setting the strategy based on user input
        Calculator calculator = null;
        switch (operation.toLowerCase()) {
            case "add":
                calculator = new Calculator(new Add());
                break;
            case "subtract":
                calculator = new Calculator(new Subtract());
                break;
            case "multiply":
                calculator = new Calculator(new Multiply());
                break;
            case "divide":
                calculator = new Calculator(new Divide());
                break;
            default:
                System.out.println("Invalid operation. Exiting.");
                scanner.close();
                return;
        }

        // Getting user input for numbers
        System.out.print("Enter first number: ");
        double a = scanner.nextDouble();
        System.out.print("Enter second number: ");
        double b = scanner.nextDouble();

        // Performing the operation
        double result = calculator.execute(a, b);
        System.out.println("Result: " + result);

        scanner.close();
    }
}
