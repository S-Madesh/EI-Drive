import java.util.Scanner;

// Target Interface (PS/2)
interface PS2Port {
    void connectPS2();
}

// Adaptee (USB)
class USBDevice {
    public void connectUSB() {
        System.out.println("USB device connected.");
    }
}

// Adapter (USB to PS/2)
class USBToPS2Adapter implements PS2Port {
    private USBDevice usbDevice;

    public USBToPS2Adapter(USBDevice usbDevice) {
        this.usbDevice = usbDevice;
    }

    @Override
    public void connectPS2() {
        usbDevice.connectUSB();
    }
}

// Example usage
public class AdapterPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Connecting USB device to PS/2 port using Adapter...");
        USBDevice usbDevice = new USBDevice();
        PS2Port ps2Port = new USBToPS2Adapter(usbDevice);

        ps2Port.connectPS2();

        scanner.close();
    }
}
