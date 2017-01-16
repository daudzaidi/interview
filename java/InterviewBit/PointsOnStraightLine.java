package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shyamsunderpandita on 07/01/17.
 */
public class PointsOnStraightLine {
    public int maxPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        HashMap<Double, Integer> hashMap;
        hashMap = new HashMap<>();

        if (A == null || B == null)
            return -1;

        if (A.size() == 0)
            return 0;

        int n = A.size();
        int x1, y1, x2, y2;
        int val;
        int max = 0;

        for (int i = 0; i < n; i++) {

            x1 = A.get(i);
            y1 = B.get(i);
            hashMap.clear();

            for (int j = 0; j < n; j++) {

                if (i == j)
                    continue;

                x2 = A.get(j);
                y2 = B.get(j);

                double slope = y2 - y1;
                int den = x2 - x1;

                if (den == 0)
                    slope = Double.POSITIVE_INFINITY;
                else
                    slope = slope / den;

                val = 1;

                if (hashMap.containsKey(slope)) {
                    val = hashMap.get(slope) + 1;
                }

                hashMap.put(slope, val);

            }

            for (Map.Entry<Double, Integer> entry : hashMap.entrySet()) {
                val = entry.getValue();
                max = Math.max(max, val);
            }
        }

        return max + 1;
    }
    public static void main(String... args){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(-6);
        a.add(5);
        a.add(-18);
        a.add(-17);
        a.add(5);
        a.add(-2);
        ArrayList<Integer> b = new ArrayList<>();
        b.add(-17);
        b.add(-16);
        b.add(-17);
        b.add(-4);
        b.add(-13);
        b.add(20);
        PointsOnStraightLine p = new PointsOnStraightLine();
        System.out.println(p.maxPoints(a,b));
    }
}
