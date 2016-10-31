package BehavioralDP.CommandDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class TurnTVOff implements Command {
    ElectronicDevice theDevice;

    public TurnTVOff(ElectronicDevice device){
        this.theDevice = device;
    }

    @Override
    public void execute() {

        theDevice.turnOff();
    }
}
