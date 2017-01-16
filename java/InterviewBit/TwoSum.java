package InterviewBit;

import java.util.*;

/**
 * Created by shyamsunderpandita on 07/01/17.
 */
public class TwoSum {
    public ArrayList<Integer> twoSum(final List<Integer> A, int B) {
        int sum = B;
        int diff;
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        int size = A.size();
        int num;
        int index;
        ArrayList<Integer> res = new ArrayList<Integer>();
        ArrayList<Node> node = new ArrayList<>();

        for (int i = size - 1; i >= 0; i--) {
            num = A.get(i);
            diff = sum - num;

            if (hashMap.containsKey(diff)) {
                index = hashMap.get(diff);
                node.add(new Node(i + 1, index + 1));
            }

            hashMap.put(num, i);

        }

        if (node.size() > 0) {
            Collections.sort(node);
            res.add(node.get(0).left);
            res.add(node.get(0).right);
        }

        return res;
    }

    static class Node implements Comparable<Node> {

        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right  = right;
        }

        public int compareTo(Node o) {
            if (this.right < o.right)
                return -1;
            if (this.right > o.right)
                return 1;

            return Integer.compare(this.left, o.left);
        }

    }

    public static void main(String... args){
        int[] a = new int[]{4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9, -4, 4, -8};
        final List<Integer> arr = new ArrayList<>();

        for(int i = 0 ; i < a.length ; i++){
            arr.add(a[i]);
        }

        TwoSum s = new TwoSum();
        System.out.println(s.twoSum(arr,-3));
    }
}
