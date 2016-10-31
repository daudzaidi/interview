package BehavioralDP.CommandDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class Radio implements ElectronicDevice {

    private int volume =0;

    @Override
    public void turnOn() {

        System.out.println("Radio is ON");
    }

    @Override
    public void turnOff() {

        System.out.println("Radio is OFF");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("Radio Volume is Up : " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("Radio Volume is Down : " + volume);
    }
}
