package old.java.Amazon.Set234;

import java.util.ArrayList;

/**
 * Created by pandita on 12/11/2015.
 */
public class CityTours {

    //LIMITATION: cannot find combinations of elements more than 31 (max integer range is 2^31-1) and bit wise operations cannot be appied on double type
    public void printCombinations(String[] cities){
        int len = cities.length;
      //  int fix=1;

       power pow = new power();
       int power_length=(int)pow.calculatePowerIterative(2,len);
        System.out.println("Total number of combinations: "+(power_length));
        //check if ith bit in the counter is set and print

        for(int counter=0;counter<power_length;counter++){
            for(int i=0;i<len;i++){
                int r = 1<<i;
                int re = counter & r;
                if(re!=0){
                    System.out.print(cities[i]+",");
                }
            }

            System.out.println();
        }

    }

    public void printCombinationsDouble(String[] cities){
        int len = cities.length;

        power pow = new power();
        double power_length=pow.calculatePowerIterative(2,len);
        System.out.println("Total number of combinations: "+(power_length));
        //check if ith bit in the counter is set and print

        for(double counter=0;counter<power_length;counter++){
            for(int i=0;i<len;i++){
                double r = 1<<i;
                double re = Double.longBitsToDouble(Double.doubleToRawLongBits(counter)& Double.doubleToRawLongBits(r));
                if(re!=0){
                   // System.out.print(cities[i]+",");
                }
            }

      //      System.out.println();
        }

    }

    //&& end-i+1 >= r-index

    public void printRCombinations(String[] cities, String[]data, int start, int end, int index, int r) {

        if (index == r) {
            printC(data);
            return;
        }

        for (int i=start; i<=end; i++)
        {
            data[index] = cities[i];
            printRCombinations(cities, data, i+1, end, index+1, r);
        }

    }

    private void printC(String[] combi) {
        for(String c: combi){
            System.out.print(c+",");
        }
        System.out.println();
    }


    public static void main(String arg[]){
        CityTours tours = new CityTours();
       // tours.printCombinationsDouble(new String[]{"Delhi","Mumbai","Kolkata","noida","nagpur","rr","rrt","po","Bangalore","a","b","c","d","e","f","g","h","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"});
        tours.printCombinations(new String[]{"Delhi","Mumbai","Kolkata"});
        ArrayList<String> list=new ArrayList<String>();
        list.add("Delhi");
        list.add("Mumbai");
        list.add("Kolkata");
       // tours.permutation(list,0,3);
       System.out.println();

        // A temporary array to store all combination one by one
        String []data = new String[2];

        // Print all combination using temprary array 'data[]'
        tours.printRCombinations(new String[]{"Delhi","Mumbai","Kolkata"}, data, 0, 2, 0, 2);
    }
}
