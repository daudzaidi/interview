package Amazon.Tagged;

/**
 * Created by shyamsunderpandita on 26/10/16.
 */
public class CelebrityProblem {

    public static int findCelebrityPointer(int[][]arr){
        int startPointer = 0;
        int endPointer = arr.length -1;

        while(startPointer < endPointer){
            if(knows(startPointer,endPointer,arr)==1)
                startPointer++;
            else
                endPointer--;
        }

        //check if startPointer is actually a celerity

        for(int i = 0 ; i < arr.length ; i++){
            if(i != startPointer){
                if(knows(i,startPointer,arr) == -1 || knows(startPointer,i,arr) ==1)
                    return -1;
            }
        }

        return startPointer;
    }

    public static int knows(int a, int b, int[][]arr){
       if(arr[a][b] == 1)
           return 1;
        else return -1;
    }

    public static void main(String... args){
        int [][] a = {{0,1,0}, {0,0,0}, {0,1,0}};

        int [][] b = {{0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
                {0, 0, 1, 0}};

        System.out.println("Celebrity ID = "+findCelebrityPointer(a));
        System.out.println("Celebrity ID = "+findCelebrityPointer(b));
    }
}
