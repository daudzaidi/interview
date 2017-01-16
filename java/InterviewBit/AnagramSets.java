package InterviewBit;

import java.util.*;

/**
 * Created by shyamsunderpandita on 07/01/17.
 */
public class AnagramSets {
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        HashMap<String,ArrayList<Integer>> map = new HashMap<>();


        for(int i = 0 ; i < a.size() ; i++){
            char[] s = a.get(i).toCharArray();
            Arrays.sort(s);
            String str = new String(s);
            if(map.containsKey(str)){
                map.get(str).add(i+1);
            }
            else{
                ArrayList<Integer> m = new ArrayList<>();
                m.add(i+1);
                map.put(str,m);
            }
        }

        Iterator itr = map.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry obj = (Map.Entry) itr.next();
            res.add((ArrayList<Integer>) obj.getValue());
        }

        return res;
    }

    public static void main(String... args){
        AnagramSets a = new AnagramSets();
        final List<String> ar = new ArrayList<>();
        ar.add("cat");
        ar.add("dog");
        ar.add("god");
        ar.add("tca");
        System.out.println(a.anagrams(ar));
    }
}
