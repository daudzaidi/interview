package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 14/01/17.
 */
public class Seats {
    public int seats(String a) {
        int res = 0 ;

        if(a == null){
            return res;
        }

        int size = a.length();
        if(size > 0){
            char[] array = a.toCharArray();

            int start = 0 ; int end = array.length-1;
            while(array[start] == '.' && start<end){
                start++;
            }

            while (array[end] == '.' && end > start){
                end --;
            }

            int median = start+(end-start)/2;
            int left = median;
            int right = median+1;

            while(left >=0 && array[left] == 'x'){
                left--;
            }

            while (right <size && array[right] == 'x' ){
                right++;
            }

            for(int i = start ; i <= end ; i++){
                if(array[i] == '.'){
                    continue;
                }
                else{
                    if(i <= left){
                        res = res + (left-i);
                        res = res%10000003;
                        left--;
                    }
                    else if(i >= right){
                        res = res + (i - right);
                        res = res%10000003;
                        right++;
                    }
                }
            }
        }

        return res;
    }

    private static final int MOD = 10000003;

    public int seatsefficient(String A) {
        int n;
        int i;
        int first, last;
        int countLeft[];
        int total = 0;
        int midVal;

        if (A == null || A.length() == 0)
            return 0;

        n = A.length();
        countLeft = new int[n];
        first = last = -1;

        for (i = 0; i < n; i++) {
            countLeft[i] = i > 0 ? countLeft[i - 1] : 0;

            if (A.charAt(i) == 'x') {
                if (first == -1)
                    first = i;
                last = i;
                countLeft[i]++;
                total++;
            }
        }

        midVal = (total + 1) / 2;

        if (first == -1 || first == last)
            return 0;

        int mid;

        for (i = first; i <= last; i++) {
            if (countLeft[i] == midVal)
                break;
        }

        mid = i;

        long res = 0;
        int count = 0;

        for (i = mid; i >= first; i--) {
            if (A.charAt(i) == 'x') {
                res += (mid - i - count);
                res %= MOD;
                count++;
            }
        }

        count = 0;

        mid++;
        for (i = mid; i <= last; i++) {
            if (A.charAt(i) == 'x') {
                res += (i - mid - count);
                res %= MOD;
                count++;
            }
        }

        return (int) res;
    }
    public static void main(String... args){
        Seats seat = new Seats();
        System.out.println(seat.seatsefficient("....x..xx...x.."));
        System.out.println(seat.seatsefficient("xx.....xx.x..xxxx..xxxx.xx..xx..x.xxxx"));
    }
}
