package old.java.BitWiseManipulation;

import java.util.Scanner;

/**
 * Created by pandita on 12/1/2015.
 */
public class XoringNinja {
    String binary[] = {
            "0000", "0001", "0010", "0011", "0100", "0101", "0110",
            "0111",
            "1000", "1001", "1010", "1011", "1100", "1101", "1110",
            "1111"
    };
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x=sc.nextInt();
        double y = sc.nextDouble();
        sc.nextLine();
        String s = sc.nextLine();
        System.out.println("String: "+s);
        System.out.println("Double: "+y);
        System.out.println("Int: "+x);


        int a=sc.nextInt();
        int b = sc.nextInt();
        sc.nextLine();
        String numbers=sc.nextLine();
        String [] arr = numbers.split(" ");
        int [] arr2= new int[b];
        for(int i =0;i<b;i++){
            arr2[i]=Integer.parseInt(arr[i]);
        }

        System.out.println(a);
        System.out.println(b);
        for (int k =0;k<b;k++) {
            System.out.print(arr2[k] +" ");
        }


    }

}
