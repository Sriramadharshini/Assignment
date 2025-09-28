// --- Implementor Interface ---
interface Device {
    void turnOn();
    void turnOff();
    void setVolume(int percent);
}

// --- Concrete Implementors ---
class TV implements Device {
    public void turnOn() { System.out.println("TV is ON"); }
    public void turnOff() { System.out.println("TV is OFF"); }
    public void setVolume(int percent) { System.out.println("TV volume set to " + percent + "%"); }
}

class Radio implements Device {
    public void turnOn() { System.out.println("Radio is ON"); }
    public void turnOff() { System.out.println("Radio is OFF"); }
    public void setVolume(int percent) { System.out.println("Radio volume set to " + percent + "%"); }
}

// --- Abstraction ---
abstract class RemoteControl {
    protected Device device; // The "bridge" to the implementation
    public RemoteControl(Device device) { this.device = device; }

    public abstract void power();
    public abstract void volumeUp();
}

// --- Refined Abstraction ---
class BasicRemote extends RemoteControl {
    public BasicRemote(Device device) { super(device); }

    @Override
    public void power() {
        System.out.println("Remote: Power button pressed.");
        device.turnOn();
    }

    @Override
    public void volumeUp() {
        System.out.println("Remote: Volume up.");
        device.setVolume(75);
    }
}

// --- Demo ---
public class BridgePattern {
    public static void main(String[] args) {
        Device tv = new TV();
        RemoteControl tvRemote = new BasicRemote(tv);
        tvRemote.power();
        tvRemote.volumeUp();

        System.out.println("\nSwitching to Radio...");
        Device radio = new Radio();
        RemoteControl radioRemote = new BasicRemote(radio);
        radioRemote.power();
    }
}