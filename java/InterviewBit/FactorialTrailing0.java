package InterviewBit;

/**
 * Created by shyamsunderpandita on 20/11/16.
 */
public class FactorialTrailing0 {
    public static int trailingZeroes(int a) {

        if(a < 5){
            return 0;
        }

        int countTwo = 0;
        int countFive = 0;
        for(int i = 2 ; i <= a ; i++){
            if(i % 2 == 0){
                countTwo++;
            }

            if(i % 5 == 0){
                countFive++;
            }

            int isPower = isPower(i);

            if(isPower > 0){
                System.out.println("isPower = "+isPower);
                countFive = countFive + isPower;
            }
        }

        int smaller = (countFive < countTwo) ? countFive : countTwo;

        return smaller;
    }

    public  static int isPower(int a) {
        if(a == 1){
            return 0;
        }

        a = Math.abs(a);
        int limit = ( (int) Math.sqrt(a) )+ 1;

        for(int i = 2 ; i < limit ; i++){
            int j = 0;
            int k = i;
            while(j <=limit ){
                k=k*i;
                if(k == a){

                    return j;
                }
                j++;
            }
        }

        return 0;
    }


    public static void main(String... args){
        System.out.println("Number of trailing zeroes = "+trailingZeroes(9247));
    }
}
