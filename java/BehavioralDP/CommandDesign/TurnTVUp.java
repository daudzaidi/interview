package BehavioralDP.CommandDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class TurnTVUp implements Command {
    ElectronicDevice theDevice;

    public TurnTVUp(ElectronicDevice device){
        this.theDevice = device;
    }

    @Override
    public void execute() {

        theDevice.volumeUp();
    }
}
