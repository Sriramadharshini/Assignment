// --- Receiver ---
class Light {
    public void turnOn() { System.out.println("The light is ON"); }
    public void turnOff() { System.out.println("The light is OFF"); }
}

// --- Command Interface ---
interface Command {
    void execute();
}

// --- Concrete Commands ---
class LightOnCommand implements Command {
    private Light light;
    public LightOnCommand(Light light) { this.light = light; }
    public void execute() { light.turnOn(); }
}

class LightOffCommand implements Command {
    private Light light;
    public LightOffCommand(Light light) { this.light = light; }
    public void execute() { light.turnOff(); }
}

// --- Invoker ---
class SimpleRemoteControl {
    private Command slot;
    public void setCommand(Command command) { this.slot = command; }
    public void buttonWasPressed() {
        System.out.println("Button pressed...");
        slot.execute();
    }
}

// --- Demo ---
public class CommandPattern {
    public static void main(String[] args) {
        SimpleRemoteControl remote = new SimpleRemoteControl();
        Light livingRoomLight = new Light();

        // Create command objects and associate them with the receiver
        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        // Program the remote
        remote.setCommand(lightOn);
        remote.buttonWasPressed();

        remote.setCommand(lightOff);
        remote.buttonWasPressed();
    }
}