package StructuralDP.BridgeDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class TestTheRemote {
    public static void main(String... args){

        RemoteButton theTV = new TVRemoteMute(new TVDevice(1,200));

        RemoteButton theTV2 = new TVRemotePause(new TVDevice(1,200));

        theTV.buttonNinePressed();
        theTV.buttonFivePressed();
        theTV.buttonSixPressed();
        theTV.deviceFeedback();


        theTV2.buttonNinePressed();
        theTV2.buttonFivePressed();
        theTV2.buttonSixPressed();
        theTV2.deviceFeedback();
    }
}
