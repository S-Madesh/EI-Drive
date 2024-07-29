import java.util.Scanner;

// Component
interface Coffee {
    String getDescription();
    double getCost();
}

// Concrete Component
class BasicCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Basic Coffee";
    }

    @Override
    public double getCost() {
        return 5.0;
    }
}

// Decorator
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

// Concrete Decorators
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Milk";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 1.0;
    }
}

class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Sugar";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 0.5;
    }
}

class WhippedCreamDecorator extends CoffeeDecorator {
    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getCost() {
        return decoratedCoffee.getCost() + 1.5;
    }
}

// Example usage
public class DecoratorPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Coffee coffee = new BasicCoffee();

        System.out.println("Basic Coffee: " + coffee.getDescription() + " | Cost: $" + coffee.getCost());

        System.out.print("Do you want milk? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            coffee = new MilkDecorator(coffee);
        }

        System.out.print("Do you want sugar? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            coffee = new SugarDecorator(coffee);
        }

        System.out.print("Do you want whipped cream? (yes/no): ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            coffee = new WhippedCreamDecorator(coffee);
        }

        System.out.println("Final Coffee: " + coffee.getDescription() + " | Cost: $" + coffee.getCost());

        scanner.close();
    }
}
