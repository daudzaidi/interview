package StructuralDP.FacadeDesign;

/**
 * Created by shalvi on 09/04/16.
 */
public class SecurityCodeCheck {

    private int securityCode = 1234;

    public int getSecurityCode(){
        return securityCode;
    }

    public boolean isCodeCorrect(int securityCode){ // behind the scenes check
        if(securityCode == this.securityCode)
            return true;

        return false;
    }
}
