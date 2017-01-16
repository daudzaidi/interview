package InterviewBit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shyamsunderpandita on 08/01/17.
 */
public class WindowString {
    private HashMap<Character, Integer> count;
    private HashMap<Character, Integer> hashMap;

    public String minWindow(String S, String T) {

        int start = 0;
        int end = 0;
        int n;
        char c;
        int val;

        if (S == null || T == null)
            return null;

        count = new HashMap<>();
        hashMap = new HashMap<>();

        n = T.length();

        for (int i = 0; i < n; i++) {
            c = T.charAt(i);
            add(count, c , 1);
            add(hashMap, c, 0);
        }

        ArrayList<Integer> res = new ArrayList<>();
        n = S.length();

        while (end < n) {
            c = S.charAt(end);
            add(hashMap, c, 1);
            while (start < end) {
                decrement(hashMap, S.charAt(start));
                if (!validString()) {
                    add(hashMap, S.charAt(start), 1);
                    break;
                }
                start++;
            }
            updateResult(res, start, end);
            end++;
        }

        if (res.size() == 0)
            return "";

        start = res.get(0);
        end = res.get(1);

        return S.substring(start, end + 1);

    }

    public void add(HashMap<Character, Integer> map, char key, int v) {
        int val;
        val = v;
        if (map.containsKey(key)) {
            val += map.get(key);
        }
        map.put(key, val);
    }

    public void decrement(HashMap<Character, Integer> map, char key) {
        int val;
        if (!map.containsKey(key))
            return;
        val = map.get(key);
        val--;
        map.put(key, val);
    }

    public void updateResult(ArrayList<Integer> res, int start, int end) {
        if (!validString())
            return;

        int i, j;

        if (res.size() == 0) {
            res.add(start);
            res.add(end);
            return;
        }

        i = res.get(0);
        j = res.get(1);

        if (j - i <= end - start)
            return;

        res.clear();
        res.add(start);
        res.add(end);
    }

    public boolean validString() {
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            char key = entry.getKey();
            int val = entry.getValue();
            if (val > hashMap.get(key))
                return false;
        }
        return true;
    }


    public static void main(String... args){
        WindowString w = new WindowString();
        System.out.println(w.minWindow("ADOBECODEBANC","ABC"));
    }
}
