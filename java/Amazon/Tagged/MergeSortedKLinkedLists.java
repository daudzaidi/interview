package Amazon.Tagged;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * Created by shyamsunderpandita on 24/10/16.
 */
public class MergeSortedKLinkedLists {

    //HEAP METHOD
    public static Queue<Integer> getMergedLL(List<Queue<Integer>> list){
        if(list == null || list.size() == 0)
            return null;

        if(list.size() == 1){
            return list.get(0);
        }

        Queue<Integer> result = new PriorityBlockingQueue<>();

        int k = list.size();
        for(int i = 0 ; i < k ; i++){
            int s = list.get(i).size();
            for(int j = 0 ; j < s ; j++){
                result.add(list.get(i).poll());
            }
        }

        Queue<Integer> output = new LinkedList<Integer>();
        int s = result.size();
        for(int i = 0 ; i < s ; i++)
            output.add(result.poll());

        return output;
    }


    //DIVIDE AND CONQUER METHOD
    public static List<Integer> getMergedLLEfficient(List<List<Integer>> list){
        if(list == null || list.size() == 0)
            return null;

        if(list.size() == 1){
            return list.get(0);
        }

        int k = list.size();

        List<Integer> output = mergeEfficient(list,k-1);
        return output;
    }

    private static List<Integer> mergeEfficient(List<List<Integer>> list, int last) {

        while(last != 0){
            int i = 0 ;
            int j = last;

            while(i < j){

                list.set(i, mergeTwoLL(list.get(i),list.get(j)));
                i++;
                j--;

                if(i >= j)
                    last = j;
            }
        }
        return list.get(0);
    }

    public static List<Integer> mergeTwoLL(List<Integer> list1, List<Integer> list2){
            List<Integer> res = new ArrayList<>();
            int i = 0 , j = 0;
            while(i < list1.size() && j < list2.size()){
                if(list1.get(i) < list2.get(j)){
                    res.add(list1.get(i));
                    i++;
                }
                else if(list1.get(i) > list2.get(j)){
                    res.add(list2.get(j));
                    j++;
                }
                else {
                    res.add(list2.get(j));
                    res.add(list1.get(i));
                    i++;
                    j++;
                }
            }

            if(i != list1.size() ){
                for(int l = i ; l < list1.size(); l++){
                    res.add(list1.get(l));
                }
            }


            if(j != list2.size() ){
                for(int l = j ; l < list2.size(); l++){
                    res.add(list2.get(l));
                }
            }

            return res;
    }

    public static void main(String... args){
        /*List<Queue<Integer>> list = new ArrayList<>();

        Queue<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);


        Queue<Integer> list2 = new LinkedList<>();
        list2.add(4);
        list2.add(5);



        Queue<Integer> list3 = new LinkedList<>();
        list3.add(5);
        list3.add(6);


        Queue<Integer> list4 = new LinkedList<>();
        list4.add(7);
        list4.add(8);
        list4.add(9);

        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        Queue<Integer> output = getMergedLL(list);

        for(Integer elem : output)
            System.out.println(elem);*/

        List<List<Integer>> listN = new ArrayList<>();

        List<Integer> list1N = new ArrayList<>();
        list1N.add(1);
        list1N.add(2);
        list1N.add(3);


        List<Integer> list2N = new ArrayList<>();
        list2N.add(4);
        list2N.add(5);



        List<Integer> list3N = new ArrayList<>();
        list3N.add(5);
        list3N.add(6);


        List<Integer> list4N = new ArrayList<>();
        list4N.add(7);
        list4N.add(8);
        list4N.add(9);

        listN.add(list1N);
        listN.add(list2N);
        listN.add(list3N);
        listN.add(list4N);

        List<Integer> outputN = getMergedLLEfficient(listN);

        for(Integer elem : outputN)
            System.out.println(elem);
    }
}
