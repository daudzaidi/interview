package Amazon.Tagged;

import java.util.LinkedList;

/**
 * Created by shyamsunderpandita on 18/10/16.
 */
public class RemoveKthNode {
    static LinkedList<Integer> list = new LinkedList<>();
    public static void removeNode(int k ){
        if(list.size() == 0)
            return;
        int c = 1 ;
        int i = 0;
        while(true){
            if(i >=list.size()){
                break;
            }

            if(c == k){
                list.remove(i);
                c = 1;
                i--;
            }
            else{
                c++;
            }
            i++;
        }

        for(int j = 0 ; j< list.size() ; j++){
            System.out.println(list.get(j));
        }
    }

    public static void main(String... args){
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        RemoveKthNode.removeNode(3);
    }
}


