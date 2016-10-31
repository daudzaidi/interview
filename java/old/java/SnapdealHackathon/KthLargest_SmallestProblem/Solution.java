package old.java.SnapdealHackathon.KthLargest_SmallestProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by pandita on 11/16/2015.
 */
public class Solution {
    static Double[] N_array;
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Double K;
        Double X;
        int type;
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String s = bufferRead.readLine();
            String[] arr = s.split(" ");
            if(arr.length==2){
                int N = Integer.parseInt(arr[0]);
                int Q = Integer.parseInt(arr[1]);
                for(int i=0;i<N;i++){
                    String num=bufferRead.readLine();
                    String[] numbers=num.split(" ");
                    for(int k=0;k<numbers.length;k++){
                        N_array[k]=Double.parseDouble(numbers[k]);
                    }
                    for(int j=0;i<Q;i++){
                        String query=bufferRead.readLine();
                        String[] querArr=query.split(" ");
                        if(querArr.length==3){
                            X=Double.parseDouble(querArr[0]);
                            K=Double.parseDouble(querArr[1]);
                            type=Integer.parseInt(querArr[2]);
                            Double result= executeQuery(X,K,type);
                            System.out.println(result);
                        }
                        else {
                            return;
                        }
                    }
                }
            }
            else{
                return;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Double executeQuery(Double x, Double k, int type) {
        Double res =null;

        return res;
    }

}
