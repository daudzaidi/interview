package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 16/01/17.
 */
public class JumpGameArray {

    public int canJump(ArrayList<Integer> a){
        if(a!=null && a.size() > 0){
            int res = a.get(0);

            for(int i = 0 ; i < a.size() ; i++){
                if(res < i && a.get(i) == 0){
                    return 0;
                }

                if(res < i + a.get(i)){
                    res = i + a.get(i);
                }

                if(res >= a.size()){
                    return 1;
                }
            }
        }
        return 0;
    }

    //min jumps required
    public int jump(ArrayList<Integer> a) {
        if(a!=null && a.size() > 0){
            if(a.size() == 1){
                return 0;
            }

            int[] jumps = new int[a.size()];
            int[] positions = new int[a.size()];

            jumps[0] = 0;
            positions[0] =-1;

            for(int i=1; i < a.size() ; i++){
                jumps[i] = Integer.MAX_VALUE-1;
            }


            for(int i = 1 ; i < a.size() ; i++){
                for(int j = 0 ; j < i ; j++){
                    if(i <= a.get(j)+j ){
                        jumps[i] = Math.min(jumps[i],jumps[j]+1);
                        positions[i] = j;
                    }
                }
            }

            return (jumps[a.size()-1] != Integer.MAX_VALUE-1) ? jumps[a.size()-1] : -1;
        }
        return -1;
    }
    public static void main(String... args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(3);
        a.add(1);
        a.add(1);
        a.add(2);
        a.add(4);
        a.add(2);
        a.add(0);
        a.add(1);
        a.add(1);



        JumpGameArray j = new JumpGameArray();
        System.out.println(j.jump(a));


        int[] arr = new int[]{33, 21, 50, 0, 0, 46, 34, 3, 0, 12, 33, 0, 31, 37, 15, 17, 34, 18, 0, 4, 12, 41, 18, 35, 37, 34, 0, 47, 0, 39, 32, 49, 5, 41, 46, 26, 0, 2, 49, 35, 4, 19, 2, 27, 23, 49, 19, 38, 0, 33, 47, 1, 21, 36, 18, 33, 0, 1, 0, 39, 0, 22, 0, 9, 36, 45, 31, 4, 14, 48, 2, 33, 0, 39, 0, 37, 48, 44, 0, 11, 24, 16, 10, 23, 22, 41, 32, 14, 22, 16, 23, 38, 42, 16, 15, 0, 39, 23, 0, 42, 15, 25, 0, 41, 2, 48, 28};
      //  System.out.println(j.canJump(a1));

        ArrayList<Integer> b = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            b.add(arr[i]);
        }
       // System.out.println(j.canJump(b));
    }
}
