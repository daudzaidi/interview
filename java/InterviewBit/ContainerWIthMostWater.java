package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 05/01/17.
 */
public class ContainerWIthMostWater {
    public int maxArea(ArrayList<Integer> height) {
        if (height == null || height.size() < 2) {
            return 0;
        }

        int max = 0;
        int left = 0;
        int right = height.size() - 1;

        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height.get(left).intValue(), height.get(right).intValue()));
            if (height.get(left).intValue() < height.get(right).intValue())
                left++;
            else
                right--;
        }

        return max;
    }

    public static void main(String... args){
        ContainerWIthMostWater c = new ContainerWIthMostWater();
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(5);
        a.add(4);
        a.add(3);

        System.out.println(c.maxArea(a));
    }
}
