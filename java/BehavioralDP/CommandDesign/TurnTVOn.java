package BehavioralDP.CommandDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class TurnTVOn implements  Command {

    ElectronicDevice theDevice;

    public TurnTVOn(ElectronicDevice device){
        this.theDevice = device;
    }

    @Override
    public void execute() {

        theDevice.turnOn();
    }
}
