import java.util.Scanner;

// Abstract Product: Button
interface Button {
    void paint();
}

// Concrete Product: Windows Button
class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Windows Button");
    }
}

// Concrete Product: Mac Button
class MacButton implements Button {
    @Override
    public void paint() {
        System.out.println("Mac Button");
    }
}

// Abstract Product: Checkbox
interface Checkbox {
    void paint();
}

// Concrete Product: Windows Checkbox
class WindowsCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Windows Checkbox");
    }
}

// Concrete Product: Mac Checkbox
class MacCheckbox implements Checkbox {
    @Override
    public void paint() {
        System.out.println("Mac Checkbox");
    }
}

// Abstract Factory
interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

// Concrete Factory: Windows Factory
class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

// Concrete Factory: Mac Factory
class MacFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}

// Example usage
public class AbstractFactoryPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for the type of GUI to create
        System.out.print("Choose GUI factory (windows/mac): ");
        String choice = scanner.nextLine();

        GUIFactory factory = null;
        switch (choice.toLowerCase()) {
            case "windows":
                factory = new WindowsFactory();
                break;
            case "mac":
                factory = new MacFactory();
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                scanner.close();
                return;
        }

        // Create GUI components
        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        // Use the created components
        button.paint();
        checkbox.paint();

        scanner.close();
    }
}
