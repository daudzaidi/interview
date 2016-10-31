package BehavioralDP.ObserverDesign;

import java.text.DecimalFormat;

/**
 * Created by shalvi on 08/04/16.
 */
public class GetTheStock implements Runnable {

    private String stockName;
    private double stockPrice;

    private Subject stockGrabber;

    public GetTheStock(Subject stockGrabber,String stockName,  double stockPrice){
        this.stockGrabber = stockGrabber;
        this.stockName = stockName;
        this.stockPrice =stockPrice;
    }


    @Override
    public void run() {

        for (int i = 1; i <= 20; i++) {

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            double randNum = (Math.random() * (.06)) - .03;
            DecimalFormat df = new DecimalFormat("#.##");
            stockPrice = Double.valueOf(df.format((stockPrice + randNum)));

            if (stockName == "IBM") ((StockGrabber) stockGrabber).setIBMPrice(stockPrice);
            if (stockName == "AMAZON") ((StockGrabber) stockGrabber).setAmazonPrice(stockPrice);
            if (stockName == "GOOGLE") ((StockGrabber) stockGrabber).setGooglePrice(stockPrice);

            System.out.println(stockName + ": " + df.format((stockPrice + randNum)) +
                    " " + df.format(randNum));

            System.out.println();

        }
    }


}
