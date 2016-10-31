package BehavioralDP.CommandDesign;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shalvi on 09/04/16.
 */
public class PlayWithRemote {

    public static void main(String... args){

        ElectronicDevice device = TVRemote.getDevice();

        TurnTVOn onCommand  = new TurnTVOn(device);
        DeviceButton onPressed = new DeviceButton(onCommand);
        onPressed.press();

        TurnTVOff offCommand  = new TurnTVOff(device);
        DeviceButton offPressed = new DeviceButton(offCommand);
        offPressed.press();

        TurnTVUp upCommand  = new TurnTVUp(device);
        DeviceButton upPressed = new DeviceButton(upCommand);
        upPressed.press();
        upPressed.press();
        upPressed.press();

        TurnTVDown downCommand  = new TurnTVDown(device);
        DeviceButton downPressed = new DeviceButton(downCommand);
        downPressed.press();

        Television tv = new Television();
        Radio radio = new Radio();

        List<ElectronicDevice> theDevices = new ArrayList<>();
        theDevices.add(tv);
        theDevices.add(radio);

        TurnItAllOff turnItAllOff = new TurnItAllOff(theDevices);
        DeviceButton allOffPressed = new DeviceButton(turnItAllOff);
        allOffPressed.press();


    }
}
