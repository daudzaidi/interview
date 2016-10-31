package BehavioralDP.Mediator;

/**
 * Created by shalvi on 10/04/16.
 */
public interface Mediator {
    public void saleOffer(String stock, int shares, int collCode);

    public void buyOffer(String stock, int shares, int collCode);

    public void addColleague(Colleague colleague);
}
