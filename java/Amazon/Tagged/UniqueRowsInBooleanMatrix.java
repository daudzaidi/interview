package Amazon.Tagged;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shyamsunderpandita on 20/10/16.
 */
public class UniqueRowsInBooleanMatrix {

    //using hashmap

    public static void printUniqueRows(int[][] mat){

        if ( mat.length == 0 )
            return;

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i<mat.length ; i++){
            String binary = "";
            for(int j = 0 ; j < mat[0].length ; j++){
                binary = binary + mat[i][j];
            }

            int number = getDecimalFromBinary(binary);

            if(!map.containsKey(number)){
                System.out.println(binary);
                map.put(number, 1);
            }
        }
    }

    private static Integer getDecimalFromBinary(String binary) {
        char[] t = binary.toCharArray();
        Integer res = 0 ;
        for(int i = 0 ; i< t.length; i++){
            int p = (int)Math.pow(2,t.length-i-1);
            res+=Character.getNumericValue(t[i])*p;
        }
        return res;
    }

    public static void main(String... args){
        int[][] a = {
                {1, 0, 0, 1},
                {1, 0, 0, 1},
                {0, 1, 0, 1},
                {0, 0, 1, 1}};
        UniqueRowsInBooleanMatrix.printUniqueRows(a);
    }
}
