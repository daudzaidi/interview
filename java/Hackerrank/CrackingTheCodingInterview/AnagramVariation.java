package Hackerrank.CrackingTheCodingInterview;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
/**
 * Created by shalvi on 28/09/16.
 */
public class AnagramVariation {

    public static int numberNeeded2(String first, String second){
        int[] arr = new int[26];
        first.chars().forEach((c) -> {
            arr[c - 97]++;
        });
        second.chars().forEach((c) -> {
            arr[c - 97]--;
        });
        return Arrays.stream(arr).map(Math::abs).sum();
    }
    public static int numberNeeded(String first, String second) {
        if(first == null && second == null){
            return 0;
        }
        if(first == null && second!=null){
            return second.length();
        }

        if(first!=null && second == null){
            return first.length();
        }

        int[] arr = new int[26];
        int len1 = first.length();
        int len2 = second.length();

        for(int i = 0 ;i< len1 ;i++){
            arr[first.charAt(i)-97]++;
        }

        for(int i = 0 ;i< len2 ;i++){
            arr[second.charAt(i)-97]--;
        }
        int res = 0;
        for(int i = 0 ;i<26;i++){
            res+=Math.abs(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}