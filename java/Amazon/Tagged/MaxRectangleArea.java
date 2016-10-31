package Amazon.Tagged;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by shyamsunderpandita on 19/10/16.
 */
public class MaxRectangleArea {
    public static int maxRectangle(int[][] mat){
        int rows = mat.length;
        int cols = mat[0].length;
        int[] hist = new int[cols];

        int maxArea = 0;
        for(int i = 0 ; i< rows ; i++){
            for(int j = 0 ; j<cols ;j++){
                if(i == 0){
                    hist[j] = mat[i][j];
                }
                else{
                    hist[j] = (mat[i][j]==0) ? 0 : hist[j]+mat[i][j];
                }
            }
            int area = getMaxAreaFromHistogram(hist);
            maxArea = Math.max(area,maxArea);
        }

        return maxArea;
    }

    private static int getMaxAreaFromHistogram(int[] hist) {
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0 ;
        int i = 0;
        while(i < hist.length){
            if(stack.size() == 0 || hist[stack.peek()] <= hist[i]){
                stack.push(i);
                i++;
            }
            else{
                int pop = stack.pop();
                int h = hist[pop];
                int w = (stack.size() == 0 )?i : i-stack.peek()-1;
                maxArea = Math.max(maxArea,h*w);
            }
        }

        while(!stack.isEmpty()){
            int pop = stack.pop();
            int h = hist[pop];
            int w = (stack.size() == 0 )?i : i-stack.peek()-1;
            maxArea = Math.max(maxArea,h*w);
        }
        return maxArea;
    }

    public static  int maxHistogram(int input[]){
        Stack<Integer> stack = new Stack<Integer>();
        int maxArea = 0;
        int area = 0;
        int i;
        for(i=0; i < input.length;){
            if(stack.isEmpty() || input[stack.peek()] <= input[i]){
                stack.push(i++);
            }else{
                int top = stack.pop();
                //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
                if(stack.isEmpty()){
                    area = input[top] * i;
                }
                //if stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
                else{
                    area = input[top] * (i - stack.peek() - 1);
                }
                if(area > maxArea){
                    maxArea = area;
                }
            }
        }
        while(!stack.isEmpty()){
            int top = stack.pop();
            //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
            if(stack.isEmpty()){
                area = input[top] * i;
            }
            //if stack is not empty then everything from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
            else{
                area = input[top] * (i - stack.peek() - 1);
            }
            if(area > maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

    public static void main(String... args){
        int[][]a = {
                {1, 0, 0, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {0, 1, 1, 1, 1, 1},
                {0, 0, 1, 1, 1, 1},};
        System.out.println("Maximum Rectangle Area = "+MaxRectangleArea.maxRectangle(a));
        System.out.println("TEST ===> "+ MaxRectangleArea.getMaxAreaFromHistogram(new int[]{0,0,3,4,2,4}));
        System.out.println("TEST 2===> "+ MaxRectangleArea.maxHistogram(new int[]{0,0,3,4,2,4}));
    }
}
