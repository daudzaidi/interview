package StructuralDP.BridgeDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class TVRemoteMute extends RemoteButton {

    public TVRemoteMute(EntertainmentDevice theDevice) {
        super(theDevice);
    }

    @Override
    public void buttonNinePressed() {

        System.out.println("TV mas muted");

    }
}
