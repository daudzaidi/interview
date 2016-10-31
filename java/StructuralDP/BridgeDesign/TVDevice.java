package StructuralDP.BridgeDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class TVDevice extends EntertainmentDevice {

    public  TVDevice(int newDeviceState, int newMaxSetting){
        deviceState = newDeviceState;
        maxSetting = newMaxSetting;

    }

    @Override
    public void buttonFivePressed() { // these will function differently in different device
        System.out.println("Channel Up");
        deviceState++;
    }

    @Override
    public void buttonSixPressed() { // these will function differently in different device
        System.out.println("Channel Down");
        deviceState--;
    }
}
