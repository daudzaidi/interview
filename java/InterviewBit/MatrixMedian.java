package InterviewBit;

import java.util.ArrayList;

/**
 * Created by shyamsunderpandita on 22/12/16.
 * Given a N cross M matrix in which each row is sorted, find the overall median of the matrix. Assume N*M is odd.

 For example,

 Matrix=
 [1, 3, 5]
 [2, 6, 9]
 [3, 6, 9]

 A = [1, 2, 3, 3, 5, 6, 6, 9, 9]

 Median is 5. So, we return 5.
 Note: No extra memory is allowed.


 */
public class MatrixMedian {
    public int findMedian(ArrayList<ArrayList<Integer>> A) {

        if(A == null){
            return -1;
        }

        int rows = A.size();
        int cols = A.get(0).size();

        int totalElements = rows*cols;
        int colIndex = cols/2;
        int low = A.get(0).get(colIndex) ;
        int high =A.get(0).get(colIndex);

        for(int row = 1 ; row < rows ; row++){
            if(A.get(row).get(colIndex) < low){
                low = A.get(row).get(colIndex);
            }

            if(A.get(row).get(colIndex) > high){
                high = A.get(row).get(colIndex);
            }
        }


        int countReq = totalElements/2;


        while(low < high) {
            int mid = (high + low) / 2;
            int countleft = 0;
            int countright = 0;
            int countsame = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (A.get(i).get(j) < mid ){
                        countleft++;
                    }

                    if (A.get(i).get(j) > mid){
                        countright++;
                    }

                    if (A.get(i).get(j) == mid){
                        countsame++;
                    }
                }
            }

            int  d = countsame-1;
            d=d+countleft+countright;

            if((countleft == countright ) && d%2 ==0){
                return mid;
            }

            if(countleft > countright){
                high = mid;
            }
            else{
                low = mid;
            }
        }

        return -1;

    }

    public static void main(String... args){
        MatrixMedian mat = new MatrixMedian();
       /* ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(3);
        row1.add(5);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(2);
        row2.add(6);
        row2.add(9);

        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(3);
        row3.add(6);
        row3.add(9);

        list.add(row1);
        list.add(row2);
        list.add(row3);

        System.out.println("MEDIAN = "+mat.findMedian(list));*/

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> row1 = new ArrayList<>();
        row1.add(4);

        ArrayList<Integer> row2 = new ArrayList<>();
        row2.add(4);

        ArrayList<Integer> row3 = new ArrayList<>();
        row3.add(4);

        ArrayList<Integer> row4 = new ArrayList<>();
        row4.add(5);

        ArrayList<Integer> row5 = new ArrayList<>();
        row5.add(2);

        ArrayList<Integer> row6 = new ArrayList<>();
        row6.add(4);

        ArrayList<Integer> row7 = new ArrayList<>();
        row7.add(2);

        ArrayList<Integer> row8 = new ArrayList<>();
        row8.add(2);

        ArrayList<Integer> row9 = new ArrayList<>();
        row9.add(5);

        ArrayList<Integer> row10 = new ArrayList<>();
        row10.add(5);

        ArrayList<Integer> row11 = new ArrayList<>();
        row11.add(5);


        list.add(row1);
        list.add(row2);
        list.add(row3);
        list.add(row4);
        list.add(row5);
        list.add(row6);
        list.add(row7);
        list.add(row8);
        list.add(row9);
        list.add(row10);
        list.add(row11);

        System.out.println("MEDIAN = "+mat.findMedian(list));
       /* ArrayList<ArrayList<Integer>> list1 = new ArrayList<>();
        ArrayList<Integer> row12 = new ArrayList<>();
        row12.add(1);
        row12.add(2);
        row12.add(2);
        row12.add(2);
        row12.add(2);
        row12.add(2);
        row12.add(3);
        row12.add(3);
        row12.add(3);
        row12.add(3);
        row12.add(3);

        list1.add(row12);


        System.out.println("MEDIAN = "+mat.findMedian(list1));*/
    }
}
