package InterviewBit;

import java.util.HashMap;

/**
 * Created by shyamsunderpandita on 07/01/17.
 */
public class LongestSubstringWithoutRepeat {
    public int lengthOfLongestSubstring(String a) {
        int res = 0;
            if(a!=null) {
                for (int i = 0; i < a.length(); i++) {
                    int count = 1;
                    int k = 1;
                    HashMap<Character, Integer> map = new HashMap<>();
                    map.put(a.charAt(i), 1);
                    while (i + k < a.length()) {
                        if (map.containsKey(a.charAt(i + k))) {
                            break;
                        } else {
                            map.put(a.charAt(i + k), 1);
                            count++;
                        }
                        k++;
                    }
                    res = Math.max(res, count);
                }
            }
        return res;
    }


    public int lengthOfLongestSubstringEfficient(String A) {

        int count = 0;
        int max = 0;
        if(A!=null) {
            int n = A.length();
            HashMap<Character, Integer> hashMap = new HashMap<>();
            char c;
            int prevIndex;

            for (int i = 0; i < n; i++) {

                c = A.charAt(i);

                if (hashMap.containsKey(c)) {
                    prevIndex = hashMap.get(c);
                    count = Math.min(count + 1, i - prevIndex);
                    hashMap.put(c, i);
                } else {
                    count++;
                    hashMap.put(c, i);
                }

                max = Math.max(max, count);
            }
        }
        return max;
    }

    public static void main(String... args){
        LongestSubstringWithoutRepeat p = new LongestSubstringWithoutRepeat();
        System.out.println(p.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(p.lengthOfLongestSubstring("b"));
        System.out.println(p.lengthOfLongestSubstring("aaaaaaaa"));
        System.out.println(p.lengthOfLongestSubstring(""));
        System.out.println(p.lengthOfLongestSubstring(null));

        System.out.println(p.lengthOfLongestSubstringEfficient("abcabcbb"));
        System.out.println(p.lengthOfLongestSubstringEfficient("b"));
        System.out.println(p.lengthOfLongestSubstringEfficient("aaaaaaaa"));
        System.out.println(p.lengthOfLongestSubstringEfficient(""));

    }
}
