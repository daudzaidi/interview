package java8;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by shalvi on 23/08/16.
 */
public class ConcurrentModificationExample {

    public static void main(String... args){
        HashMap<String,Integer> scores = new HashMap<>();

        scores.put("user1",6);
        scores.put("user2",6);
        scores.put("user3",6);
        scores.put("user4",6);
        scores.put("user5",6);
        scores.put("user6",6);
        scores.put("user7",6);

        Iterator<String> itr = scores.keySet().iterator();

        while(itr.hasNext()){
            System.out.println(itr.next());
            scores.put("user8",6);
        }
    }
}
