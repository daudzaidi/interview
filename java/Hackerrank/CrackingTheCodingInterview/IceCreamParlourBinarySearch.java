package Hackerrank.CrackingTheCodingInterview;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by shalvi on 04/10/16.
 */



class IceCream implements Comparable{
    int flavor;
    int index;

    public IceCream(int flavor, int index) {
        this.flavor = flavor;
        this.index = index;
    }

    @Override
    public int compareTo(Object o) {
        IceCream that = (IceCream)o;
        if(this.flavor > that.flavor)
            return 1;
        else if(this.flavor == that.flavor)
            return 0;
        else
            return -1;
    }

    @Override
    public boolean equals(Object o){
        IceCream that = (IceCream)o;
        if(that.index == this.index)
            return true;
        else
            return false;
    }

}

public class IceCreamParlourBinarySearch {

    public static int binarySearch(int first, int last, IceCream[] arr, int search) {

        while(first <= last){
            int mid = (first+last)/2;
            if(arr[mid].flavor == search)
                return arr[mid].index;
            else if(arr[mid].flavor > search)
                last = mid-1;
            else
                first = mid+1;
        }
        return -1;
    }

    public static void main(String[] args) {

        int t;
        int n, m;

        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        for(int test = 0; test < t; test++) {

            m = in.nextInt();
            n = in.nextInt();
            IceCream[] arr = new IceCream[n];

            for (int i = 0; i < n; i++)
                arr[i] = new IceCream(in.nextInt(), i + 1);

            Arrays.sort(arr);
            int firstIndex = 100000, secondIndex = 100000;
            for(int i = 0; i < n - 1 ; i++) {
                int search = m - arr[i].flavor;
                if(search >= arr[i].flavor) {
                    int index = binarySearch( i + 1, n - 1, arr, search);
                    if( index != -1 ) {
                        System.out.println( Math.min(arr[i].index, index) + " " + Math.max(arr[i].index, index));
                        break;

                    }
                }
            }

        }

    }

}
