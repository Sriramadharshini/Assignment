// --- Abstract Products ---
interface Button { void paint(); }
interface TextBox { void showText(); }

// --- Concrete Products for macOS ---
class MacOSButton implements Button {
    public void paint() { System.out.println("Painting a macOS button."); }
}
class MacOSTextBox implements TextBox {
    public void showText() { System.out.println("Showing a macOS text box."); }
}

// --- Concrete Products for Windows ---
class WindowsButton implements Button {
    public void paint() { System.out.println("Painting a Windows button."); }
}
class WindowsTextBox implements TextBox {
    public void showText() { System.out.println("Showing a Windows text box."); }
}

// --- Abstract Factory ---
interface GUIFactory {
    Button createButton();
    TextBox createTextBox();
}

// --- Concrete Factories ---
class MacOSFactory implements GUIFactory {
    public Button createButton() { return new MacOSButton(); }
    public TextBox createTextBox() { return new MacOSTextBox(); }
}

class WindowsFactory implements GUIFactory {
    public Button createButton() { return new WindowsButton(); }
    public TextBox createTextBox() { return new WindowsTextBox(); }
}

// --- Client Code ---
public class AbstractFactory {
    public static void main(String[] args) {
        // Simulate checking the OS
        String os = "Windows"; // Change to "macOS" to see the difference
        GUIFactory factory;

        if (os.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacOSFactory();
        }

        // The client creates UI elements using the factory, without knowing the concrete types
        Button button = factory.createButton();
        TextBox textBox = factory.createTextBox();

        button.paint();
        textBox.showText();
    }
}