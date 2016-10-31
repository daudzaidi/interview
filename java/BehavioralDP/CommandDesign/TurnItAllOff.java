package BehavioralDP.CommandDesign;

import java.util.List;

/**
 * Created by shalvi on 09/04/16.
 */
public class TurnItAllOff implements Command {

    List<ElectronicDevice> devices;

    public TurnItAllOff(List<ElectronicDevice> devices){

        this.devices = devices;

    }
    @Override
    public void execute() {
        for(ElectronicDevice device : devices){
            device.turnOff();
        }

    }
}
