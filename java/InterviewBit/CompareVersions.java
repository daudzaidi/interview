package InterviewBit;

import java.math.BigInteger;

/**
 * Created by shyamsunderpandita on 25/11/16.
 */
public class CompareVersions {
    public static int compareVersion(String A, String B) {

        A = A.replaceAll ("\\b0", "");
        B = B.replaceAll ("\\b0", "");
        String regex = "[0-9.]*";

        if(!(A.matches(regex)) || !(B.matches(regex))){
            return 0;
        }
        String[] arr1 = A.split("\\.");
        String[] arr2 = B.split("\\.");

        int i=0;
        while(i<arr1.length || i<arr2.length){
            if(i<arr1.length && i<arr2.length){
                if(arr1[i].length() > arr2[i].length()){
                    return 1;
                }
                else if(arr1[i].length() < arr2[i].length()){
                    return -1;
                }
                else if(arr1[i].compareTo(arr2[i]) >0){
                    return 1;
                }else if(arr1[i].compareTo(arr2[i])<0){
                    return -1;
                }
            } else if(i<arr1.length){
                if(arr1[i].compareTo("0") != 0){
                    return 1;
                }
            } else if(i<arr2.length){
                if(arr2[i].compareTo("0") != 0){
                    return -1;
                }
            }

            i++;
        }

        return 0;
    }



    public static void main(String... args){
        System.out.println(compareVersion("444444444444444444444444444445555666","444444444444444444444444"));


    }
}
