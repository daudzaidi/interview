package Hackerrank.CrackingTheCodingInterview;

import java.util.Scanner;

/**
 * Created by shalvi on 05/10/16.
 */
public class BubbleSortSwapCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        bubbleSort(a);
    }

    public static void bubbleSort(int[]a){
        int len = a.length;
        int swapCount = 0;
        if(len > 0){
            for(int i = 0 ; i < len ; i++){
                int swapTraversal = 0;
                for(int j = 0 ;j < len-1 ;j++){
                    if(a[j] > a[j+1]){
                        swapTraversal++;
                        swapCount++;
                        int temp = a[j];
                        a[j] = a[j+1];
                        a[j+1] = temp;
                    }
                }
                if(swapTraversal == 0){
                    // array sorted
                    break;
                }
            }
            int first = a[0];
            int last = a[len-1];
            System.out.println("Array is sorted in "+swapCount+" swaps.");
            System.out.println("First Element: "+first);
            System.out.println("Last Element: "+last);
        }
    }
}
