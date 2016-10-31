package StructuralDP.BridgeDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class TVRemotePause extends RemoteButton {

    public TVRemotePause(EntertainmentDevice theDevice) {
        super(theDevice);
    }

    @Override
    public void buttonNinePressed() {
        System.out.println("TV mas Paused");
    }
}
