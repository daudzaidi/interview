package Hackerrank.CrackingTheCodingInterview;

import java.util.Scanner;

/**
 * Created by shalvi on 04/10/16.
 */
public class BinarySearchImpl {
    public static boolean binarySearchIterative (int [] arr, int key){
        int left = 0 , right = arr.length - 1;
        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid] == key)
                return true;
            else if(arr[mid] > key)
                right = mid-1;
            else
                left = mid+1;
        }
        return false;
    }

    public static boolean binarySearchRecursive (int [] arr, int key, int left, int right){
        if(left > right)
            return false;
        int mid = (left+right)/2;

        if(arr[mid] == key)
            return true;
        else if(arr[mid] > key)
            return binarySearchRecursive(arr,key,left,mid-1);
        else
            return binarySearchRecursive(arr,key,mid+1,right);
    }

    public static void main(String... args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int arr_i=0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            System.out.println("Is Key Present: "+binarySearchIterative(arr,4));
            System.out.println("Is Key Present: "+binarySearchRecursive(arr,4,0,arr.length-1));
        }

    }
}
