package old.java.Amazon.Set234;

/**
 * Created by pandita on 12/10/2015.
 */


public class power {

    public double calculatePower(double x, double n){
        if(n==0)
            return 1;
        if(n==1)
            return x;
        return x*calculatePower(x,n-1);
    }

    public double calculatePowerBi(double x, double n){
        if(n==0)
            return 1;
        else if(n==1)
            return x;
        else if(n%2==0)
            return calculatePowerBi(x,n/2)*calculatePowerBi(x,n/2);
        else
            return x*calculatePowerBi(x,n/2)*calculatePowerBi(x,n/2);
    }

    public double calculatePowerIterative(double x, double n){
        if(n==0)
            return 1;
        if (n==1)
            return x;

        double n1;
        double n2=x;

        double k = 1;
        while(k!=n){
            n1=n2;
            n2=x*n1;
            k++;
        }

        return n2;
    }

    public double powerDQ(double x, int n){
        if(n==0)
            return 1;
        if(n==1)
            return x;
        double temp=powerDQ(x,n/2);
        if(n%2==0)
            return temp*temp;
        else {
            if(n>0)
                return x*temp*temp;
            else
                return (temp*temp)/2;
        }
    }

    public static void main(String... args){
        power p = new power();
        Clock clock = new Clock();
        System.out.println(p.calculatePower(5,4));
        System.out.println("Elapsed Time: "+clock.elapsedTime());

        Clock clock2 = new Clock();
        System.out.println(p.calculatePowerBi(5,4));
        System.out.println("Elapsed Time: "+clock2.elapsedTime());

        Clock clock3 = new Clock();
        System.out.println(p.calculatePowerIterative(5,3));
        System.out.println("Elapsed Time: "+clock3.elapsedTime());

        Clock clock4 = new Clock();
        System.out.println(p.powerDQ(5,3));
        System.out.println("Elapsed Time: "+clock4.elapsedTime());
    }
}
