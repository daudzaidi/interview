package old.java.Miscellaneous;

import java.util.Arrays;

/**
 * Created by pandita on 9/28/2015.
 */
public class Anagrams {

    //Sorting Method
    public static boolean checkAnagram1(String str1, String str2){

        if(str1==null && str2==null){
            System.out.println("Strings are Anagrams");
            return true;
        }


        if(str1.length()!=str2.length()){
            System.out.println("Strings are not Anagrams");
            return false;
        }

        str1=str1.toLowerCase();
        str2=str2.toLowerCase();

        char[] chars = str1.toCharArray();
        Arrays.sort(chars);
        String sorted1 = new String(chars);
        chars = str2.toCharArray();
        Arrays.sort(chars);
        String sorted2 = new String(chars);

        for(int i =0;i<str1.length();i++){
            if(sorted1.charAt(i) != sorted2.charAt(i)) {
                System.out.println("Strings are not Anagrams");
                return false;
            }
        }

        System.out.println("Strings are Anagrams");
        return true;
    }

    //Count Characters Method
    public static boolean checkAnagram2(String str1, String str2){
        if(str1==null && str2==null){
            System.out.println("Strings are Anagrams");
            return true;
        }

        if(str1.length()!=str2.length()){
            System.out.println("Strings are not Anagrams");
            return false;
        }

        int [] chars = new int[256];
        int [] chars2 = new int[256];
        for(int i=0;i<str1.length();i++){
            int ascii = (int)str1.charAt(i);
            int ascii2 = (int)str1.charAt(i);
            chars[ascii]=chars[ascii]+1;
            chars2[ascii2]=chars2[ascii2]+1;
        }

        for(int i=0; i<256;i++){
            if(chars[i]!=chars2[i]){
                System.out.println("Strings are not Anagrams");
                return false;
            }

        }
        System.out.println("Strings are Anagrams");
        return true;
    }

    public static void main(String args[]){
        Anagrams.checkAnagram1("SHALVI %%% IS GOOD","Ivlahs si doog %%%");
        Anagrams.checkAnagram2("SHALVIaa%","Ivlaaahs%");
    }
}
