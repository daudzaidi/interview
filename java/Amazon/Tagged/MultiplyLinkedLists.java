package Amazon.Tagged;

import DocPractice.SinglyLinkedListImpl;
import old.java.Amazon.Set234.power;

import java.util.LinkedList;

/**
 * Created by shyamsunderpandita on 17/10/16.
 */
public class MultiplyLinkedLists {

    static LinkedList<Integer> list1 = new LinkedList<>();
    static LinkedList<Integer> list2 = new LinkedList<>();

    public static int multiply(){
        int size1 = list1.size();
        int size2 = list2.size();
        LinkedList<Integer> result = new LinkedList<>();
        int list1R = 0;
        for(int i = 0 ; i<size1;i++){
            double p = Math.pow(10,size1-i-1);
            list1R= (int) (list1.get(i)*(p)+list1R);
        }
        for(int i = 0 ;i<size2;i++){
            double p = Math.pow(10,size2-i-1);
            int elem = (int) (list1R*(list2.get(i)*(p)));
            result.add(i,elem);
        }

        int res = 0;
        for(Integer elem:result){
            res+=elem;
        }
        return res;
    }

    static int carry = 0;
    static LinkedList<Integer> sumRes = new LinkedList<>();

    public static void add(int size1, int size2){
        if(size1 == list1.size()-1 && size2 == list2.size()-1){
            int sum = list1.get(size1) + list2.get(size2);
            carry = sum/10;
            sumRes.add(sum%10);

        }
        else{
            add(size1+1,size2+1);
            int sum = list1.get(size1)+list2.get(size2)+carry;
            carry = sum/10;
            if(size1 == 0 && size2 == 0){
                sumRes.add(sum);
            }else{
                sumRes.add(sum%10);
            }

        }
    }
    public static void main(String... args){
        //list1.add(4);
        list1.add(3);
        list1.add(3);
        list1.add(1);
        //list2.add(1);
        //list2.add(1);
        list2.add(3);
        list2.add(3);
        list2.add(1);
        System.out.println("The Result of MULTIPLY is = "+MultiplyLinkedLists.multiply());
        MultiplyLinkedLists.add(0,0);
        System.out.println("The Result of ADDITION is = ");
        for(int i = sumRes.size()-1 ; i>=0 ;i--){
            System.out.print(sumRes.get(i));
        }

    }

}


