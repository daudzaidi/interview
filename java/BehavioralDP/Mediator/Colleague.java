package BehavioralDP.Mediator;

/**
 * Created by shalvi on 10/04/16.
 */
public class Colleague {
    private Mediator mediator;
    private int colleagueCode =0;

    public Colleague(Mediator mediator) {
        this.mediator = mediator;
    }

    public void saleOffer(String stock, int shares){
        mediator.saleOffer(stock,shares,this.colleagueCode);
    }

    public void buyOffer(String stock, int shares){
        mediator.buyOffer(stock,shares,this.colleagueCode);
    }

    public void setColleagueCode(int colleagueCode) {
        this.colleagueCode = colleagueCode;
    }
}
