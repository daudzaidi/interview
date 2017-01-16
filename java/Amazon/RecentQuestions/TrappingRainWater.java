package Amazon.RecentQuestions;

/**
 * Created by shyamsunderpandita on 03/01/17.
 */
public class TrappingRainWater {

    public static int waterTrapped(int[] tower){
        int[] maxSeenRight = new int[tower.length];
        int maxSeenleft = 0 ;
        int maxSeenSoFar = 0;

        int rainwater = 0 ;

        for(int i = tower.length-1 ; i >=0 ; i --){
            if(tower[i] > maxSeenSoFar){
                maxSeenSoFar = tower[i];
            }
            maxSeenRight[i] = maxSeenSoFar;
        }

        for(int i = 0 ; i < tower.length ; i++){
            rainwater = rainwater+ Math.max(Math.min(maxSeenleft,maxSeenRight[i])-tower[i],0);
            if(tower[i] > maxSeenleft){
                maxSeenleft = tower[i];
            }
        }

        return rainwater;
    }

    public static void main(String... args){
        int[]tower = new int[]{3,0,0,2,0,4};
        System.out.println("Water Trapped between the towers is = "+waterTrapped(tower));
    }
}
