package BehavioralDP.CommandDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class TurnTVDown implements Command {
    ElectronicDevice theDevice;

    public TurnTVDown(ElectronicDevice device){
        this.theDevice = device;
    }

    @Override
    public void execute() {

        theDevice.volumeDown();
    }
}
