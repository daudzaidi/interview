package BehavioralDP.CommandDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class DeviceButton { //Invoker design button knows nothing - what device or command is being used

    Command theCommand;

    public DeviceButton(Command command){
        this.theCommand = command;
    }

    public void press(){
        theCommand.execute();
    }
}
