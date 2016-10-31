package Amazon.Tagged;

/**
 * Created by shyamsunderpandita on 17/10/16.
 */
public class MaxChainLength {
    public static int maxChainLength(PairVal[] a, int n){
        int[] mcl = new int[n];

        for(int i = 0 ; i< n ; i++)
            mcl[i] =1;

        for(int i = 1 ; i < n ; i++){
            for(int j = 0 ; j<i ; j++){
                if(a[i].a > a[j].b)
                    mcl[i] = mcl[j]+1;
            }
        }
        int max = mcl[0];
        for(int i = 1 ; i< n ;i++){
            if(mcl[i] > max)
                max = mcl[i];
        }
        return max;
    }

    public static void main(String... args){
        PairVal pair_arr[] = new PairVal[5];
        pair_arr[0] = new PairVal(5, 24);
        pair_arr[1] = new PairVal(39, 60);
        pair_arr[2] = new PairVal(15, 28);
        pair_arr[3] = new PairVal(27, 40);
        pair_arr[4] = new PairVal(50, 60);
        int n = pair_arr.length;

        System.out.println("the length of maximum size chain is "+MaxChainLength.maxChainLength(pair_arr,n));
    }
}

class PairVal
{
    int a;
    int b;

    PairVal(int a, int b)
    {
        this.a = a;
        this.b = b;
    }
}
