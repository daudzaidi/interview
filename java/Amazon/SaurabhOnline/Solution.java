package Amazon.SaurabhOnline;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;

/**
 * Created by shyamsunderpandita on 13/12/16.
 */
public class Solution {

    public String maxNumberDivisibleBy3 (String num){
        if(num == null){
            return null;
        }


        List<Integer> array = new ArrayList<Integer>();

        List<Integer> bucket0 = new ArrayList<Integer>();
        List<Integer> bucket1 = new ArrayList<Integer>();
        List<Integer> bucket2 = new ArrayList<Integer>();

        int sum = 0;

        for (int i = 0; i < num.length(); i++) {
            if (Character.isDigit(num.charAt(i))) {


                int digit = Character.getNumericValue(num.charAt(i));
                array.add(digit);

                sum += digit;

                if(digit % 3 == 0){
                    bucket0.add(digit);
                }
                else if(digit % 3 == 1){
                    bucket1.add(digit);
                }
                else if(sum % 3 == 2){
                    bucket2.add(digit);
                }
            }
        }

        Collections.sort(array,Collections.reverseOrder());
        Collections.sort(bucket1,Collections.reverseOrder());
        Collections.sort(bucket2,Collections.reverseOrder());

        if(sum % 3 == 0){
            return getString(array);
        }
        else if( sum % 3 == 1){
            if(!bucket1.isEmpty()){
                int minimal = bucket1.get(bucket1.size()-1);
                int indexArray = array.indexOf(minimal);
                array.remove(indexArray);
                return getString(array);
            }
            else{
                int minimal1 = bucket2.get(bucket2.size()-1);
                int minimal2 = bucket2.get(bucket2.size()-2);
                int indexArray1 = array.indexOf(minimal1);
                array.remove(indexArray1);
                int indexArray2 = array.indexOf(minimal2);
                array.remove(indexArray2);
                return getString(array);
            }
        }
        else if(sum % 3 == 2){
            if(!bucket2.isEmpty()){
                int minimal = bucket2.get(bucket2.size()-1);
                int indexArray = array.indexOf(minimal);
                array.remove(indexArray);
                return getString(array);
            }
            else{
                int minimal1 = bucket1.get(bucket1.size()-1);
                int minimal2 = bucket1.get(bucket1.size()-2);
                int indexArray1 = array.indexOf(minimal1);
                array.remove(indexArray1);
                int indexArray2 = array.indexOf(minimal2);
                array.remove(indexArray2);
                return getString(array);
            }
        }

        return getString(array);
    }

    public String getString(List<Integer> str){
        StringBuilder builder = new StringBuilder();

        for(int i = 0 ; i < str.size() ; i++){
            builder.append(str.get(i));
        }

        return builder.toString();
    }

    public static  void main(String... args){
        Solution solution = new Solution();
        System.out.println(solution.maxNumberDivisibleBy3("2314"));
    }
}
