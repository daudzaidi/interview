package Hackerrank.CrackingTheCodingInterview;

import java.util.Scanner;

/**
 * Created by shalvi on 04/10/16.
 */
public class CountingInversion {
    // METHOD 1: For each element count the number of elements which are on right side of given element
    // and are smaller than it
    // O(N square)

    public static long countInversionsSimple(int[] arr){
        long count = 0 ;
        int len = arr.length;
        for(int i = 0 ;i< len-1 ; i++){
            for(int j = i+1; j< len ; j++){
                if(arr[i] > arr[j]){
                    count++;
                }
            }
        }
        return count;
    }


    //METHOD 2 : Merge sort enhanaced
    //O(N log N) time and O(N) space
    public static long countInversions(int[] arr){
        int start = 0 ;
        int end = arr.length - 1;
        return count(arr,new int[arr.length],start,end);

    }

    public static long count (int [] arr,int[] temp, int start, int end){
        if(arr == null || end <= start){
            return 0;
        }
        long x = 0 , y = 0, t = 0;
        if(start < end){
            int middle = (start + end) /2;
            x = count (arr, temp,start, middle);
            y = count (arr, temp, middle+1, end);
            t = splitCount(arr,temp,start, middle, end);
        }
        return x+y+t;
    }

    public static long splitCount (int [] arr,int[]temp, int start, int middle, int end){

        long count = 0;
        int i = start, k = start, j = middle+1;

        while(i<=middle && j <=end){
            if(arr[i] > arr [j]){
                temp[k] = arr[j];
                count = count+(middle+1 - i);
                j++;
            }
            else{
                temp[k] = arr[i];
                i++;
            }
            k++;
        }

        while(i <=middle){
            temp[k] = arr[i];
            i++;
            k++;
        }

        while(j <=end){
            temp[k] = arr[j];
            j++;
            k++;
        }
        int size = end - start +1;
        System.arraycopy(temp,start,arr,start,size);

        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println("MERGE SORT: "+countInversions(arr));
            //System.out.println("BRUTE FORCE: "+countInversionsSimple(arr));
        }
    }
}
