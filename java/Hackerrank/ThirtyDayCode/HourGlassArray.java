package Hackerrank.ThirtyDayCode;

import java.util.Scanner;

/**
 * Created by shalvi on 07/10/16.
 */
public class HourGlassArray {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        int res = maxHourglassSum(arr);
        System.out.println(res);
    }

    private static int maxHourglassSum(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;

        int maxSum = Integer.MIN_VALUE ;
        int localSum = 0;
        for(int i = 0 ; i<rows-2 ;i++){
            for(int j = 0 ; j<cols-2;j++){
               localSum = arr[i][j] + arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                maxSum = Math.max(maxSum,localSum);
            }
        }

        return maxSum;
    }


}
