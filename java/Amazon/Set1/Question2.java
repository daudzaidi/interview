package Amazon.Set1;

import java.util.Stack;

/**
 * Created by shalvi on 27/06/16.
 * Question - Calculate the maximum area of the rectangle formed by the histogram
 */

public class Question2 {
    public static int calculateArea(int[] height){
        if (height == null || height.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int max = 0;
        int i = 0;

        while (i < height.length) {
            //push index to stack when the current height is larger than the previous one
            if (stack.isEmpty() || height[i] >= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                //calculate max value when the current height is less than the previous one
                int p = stack.pop();
                int h = height[p];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }

        }

        while (!stack.isEmpty()) {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }

    public static void main(String... args){
        System.out.println("The maximum area in the histogram {6,2,5,4,5,1,6} is ===>" + calculateArea(new int[]{6,2,5,4,5,1,6}));
    }
}
