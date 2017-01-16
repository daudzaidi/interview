package InterviewBit;

/**
 * Created by shyamsunderpandita on 18/11/16.
 */
public class IsPower {
    public static boolean isPower(int a) {
        if(a == 1){
            return true;
        }

        a = Math.abs(a);
        int limit = ( (int) Math.sqrt(a) )+ 1;
        boolean isPower = false;
        for(int i = 2 ; i < limit ; i++){
            int j = 0;
            int k = i;
            while(j <=limit ){
                k=k*i;
                if(k == a){
                    isPower = true ;
                    break;
                }
                j++;
            }
        }

        return isPower;
    }

    public static void main(String... args){
        System.out.println(isPower(100));
    }
}
