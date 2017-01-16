package InterviewBit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shyamsunderpandita on 05/01/17.
 * You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

 Find i, j, k such that :
 max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
 Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))

 **abs(x) is absolute value of x and is implemented in the following manner : **

 if (x < 0) return -x;
 else return x;
 Example :

 Input :
 A : [1, 4, 10]
 B : [2, 15, 20]
 C : [10, 12]

 Output : 5
 With 10 from A, 15 from B and 10 from C.
 */
public class ThreePointer {
    public int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {
        int i = 0 , j = 0 , k=0;

        int res = 0;

        int sizeA = a.size();
        int sizeB = b.size();
        int sizeC = c.size();


        while(i<sizeA-1 && j<sizeB-1 && k < sizeC-1){
            int max = Math.max(a.get(i).intValue(),Math.max(b.get(j).intValue(),c.get(k).intValue()));
            while(i<sizeA && a.get(i).intValue() < max){
                i++;
            }

            while(j<sizeB && b.get(j).intValue() < max){
                j++;
            }

            while(k<sizeC && c.get(k).intValue() < max){
                k++;
            }
            res = Math.max(res,Math.max(Math.abs(a.get(i).intValue() - b.get(j).intValue()), Math.max(Math.abs(b.get(j).intValue() - c.get(k).intValue()), Math.abs(c.get(k).intValue() - a.get(i).intValue()))));
        }


        return res;
    }

    public int minimize2(final List<Integer> A, final List<Integer> B, final List<Integer> C) {

        ArrayList<Node> list = new ArrayList<>();

        add(list, A, 0);
        add(list, B, 1);
        add(list, C, 2);

        Collections.sort(list);

        int res = Integer.MAX_VALUE;
        int n = list.size();
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {

            Node node = list.get(i);
            hashMap.put(node.index, node.value);

            if (hashMap.size() == 3) {
                int a = hashMap.get(0);
                int b = hashMap.get(1);
                int c = hashMap.get(2);


                int temp = Math.max(Math.abs(a - b), Math.abs(b - c));
                temp = Math.max(temp, Math.abs(c - a));

                res = Math.min(temp, res);
            }

        }

        return res;

    }

    public void add(ArrayList<Node> list, final List<Integer> A, int idx) {
        for (int num : A)
            list.add(new Node(num, idx));
    }


    class Node implements Comparable<Node>{
        int value;
        int index;

        public Node(int value, int idx) {
            this.value = value;
            this.index = idx;
        }

        @Override
        public int compareTo(Node node) {
            return Integer.compare(value, node.value);
        }
    }
    public static void main(String... args){
        final List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(4);
        a.add(10);

        final List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(15);
        b.add(20);

        final List<Integer> c = new ArrayList<>();
        c.add(10);
        c.add(12);

        ThreePointer t = new ThreePointer();
        System.out.println(t.minimize2(a,b,c));


    }
}
