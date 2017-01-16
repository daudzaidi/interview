package Amazon.Set1;

/**
 * Created by shalvi on 29/06/16.
 * given a string which contains only integers , return maximum number in string form
 */
public class Question4 {

    public static String maximize(String str , int k, String max){
        if(k == 0) return null;

        int len = str.length();

        for(int i =0 ; i< len ;i++){

            for(int j =i+1 ; j<len ;j++){
                if(str.charAt(i) < str.charAt(j))
                    str = swap(str,i,j);
                if(str.compareTo(max) > 0)
                    max = str;

                maximize(str,k-1,max);

            }
        }
        return str;
    }

    public static String swap(String s, int i0, int i1) {
        String s1 = s.substring(0, i0);
        String s2 = s.substring(i0+1, i1);
        String s3 = s.substring(i1+1);
        return s1+s.charAt(i1)+s2+s.charAt(i0)+s3;
    }

    public static void main(String... args){
        String str = "129814999";

        int k = 4;

        String max = str;
        System.out.println("Maximized Number ===> "+maximize(str, k, max));
    }
}
