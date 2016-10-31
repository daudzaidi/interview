package BehavioralDP.CommandDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class Television implements ElectronicDevice {

    private int volume =0;

    @Override
    public void turnOn() {

        System.out.println("TV is ON");
    }

    @Override
    public void turnOff() {

        System.out.println("TV is OFF");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("TV Volume is Up : " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("TV Volume is Down : " + volume);
    }
}
