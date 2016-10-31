package Hackerrank.ThirtyDayCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by shalvi on 07/10/16.
 */
public class BinaryNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        List<Integer> binary = binaryRepresentation(n);
        //System.out.println(binary.toString());
        long res = consecutiveOnes(binary);
        System.out.println(res);


    }

    public static List<Integer> binaryRepresentation(int n){

        List<Integer> binary = new ArrayList<Integer>();
        if(n == 0){
            binary.add(0);
            return binary;
        }
        while(n>0){
            int rem = n%2;
            binary.add(rem);
            n = n/2;
        }
        return binary;
    }

    public static long consecutiveOnes (List<Integer> binary){
        long max = 0 ;
        long curr = 0 ;
        int len = binary.size();
        for(int i = 0 ; i < len ; i++ ){
            while(binary.get(i) != 0){
                curr ++;
                i++;
                if(i>=len){
                    break;
                }
            }
            max = Math.max(max,curr);
            curr = 0;
        }
        return max;
    }
}
