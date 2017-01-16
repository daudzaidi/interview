package InterviewBit;

import java.util.*;

/**
 * Created by shyamsunderpandita on 07/01/17.
 */
public class SubstringConcatenation {
    public ArrayList<Integer> findSubstring(String a, final List<String> b) {
        ArrayList<Integer> indices = new ArrayList<>();


        if(b.size() > 0) {

            int len = b.get(0).length();
            int strLen = a.length();
            for (int i = 0; i < strLen ; i++) {
                boolean present = true;
                int temp = i;
                Map<String,Integer> map = new HashMap<>();
                for(int m = 0 ; m < b.size() ; m++){
                    if(map.containsKey(b.get(m))){
                        map.put(b.get(m), 1+map.get(b.get(m)));
                    }
                    else{
                        map.put(b.get(m),1);
                    }
                }
                for(int j = 0 ; j < b.size() ; j++) {
                    StringBuilder pat = new StringBuilder();
                    for (int k = 0; k < len; k++) {
                        if((temp+k) > strLen-1){
                            present = false;
                            break;
                        }
                        pat.append(a.charAt(temp + k));
                    }
                    if(!b.contains(pat.toString())){
                        present = false;
                        break;
                    }
                    if(map.containsKey(pat.toString())){
                        map.put(pat.toString(),map.get(pat.toString())-1);
                    }
                    temp = temp+len;
                }

                if(present == true){
                    Iterator it = map.entrySet().iterator();
                    while (it.hasNext()) {
                        Map.Entry pair = (Map.Entry)it.next();
                        if((int)pair.getValue()!=0){
                            present = false;
                        }
                        it.remove(); // avoids a ConcurrentModificationException
                    }

                }

                if(present == true){
                    indices.add(i);
                }
            }
        }

        return indices;
    }


    public static void main(String... args){

        SubstringConcatenation c = new SubstringConcatenation();

        final ArrayList<String> a = new ArrayList<>();
        a.add("foo");
        a.add("bar");

        System.out.println(c.findSubstring("barfoothefoobarman",a));

        final ArrayList<String> a1 = new ArrayList<>();
        a1.add("foo");
        a1.add("bar");
        a1.add("the");

        System.out.println(c.findSubstring("barfoothehagagagagagfoobartheman",a1));

        final ArrayList<String> a2 = new ArrayList<>();
        a2.add("foo");

        System.out.println(c.findSubstring("barfoothehagagagagagfoobartheman",a2));

        final ArrayList<String> a3 = new ArrayList<>();
        a3.add("foo");
        a3.add("foo");


        System.out.println(c.findSubstring("barfoofoohagagagagagfoobartheman",a3));

        final ArrayList<String> a4 = new ArrayList<>();
        a4.add("foo");
        a4.add("bar");
        a4.add("the");

        System.out.println(c.findSubstring("shalvipandita",a4));

        System.out.println(c.findSubstring("barfoofoohagagagagagfoobartheman",a3));

        final ArrayList<String> a5 = new ArrayList<>();
        a5.add("aaa");
        a5.add("aaa");
        a5.add("aaa");
        a5.add("aaa");
        a5.add("aaa");

        System.out.println(c.findSubstring("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",a5));
        final ArrayList<String> a6 = new ArrayList<>();
        a6.add("cac");
        a6.add("aaa");
        a6.add("aba");
        a6.add("aab");
        a6.add("abc");

        System.out.println(c.findSubstring("abbaccaaabcabbbccbabbccabbacabcacbbaabbbbbaaabaccaacbccabcbababbbabccabacbbcabbaacaccccbaabcabaabaaaabcaabcacabaa",a6));


        final ArrayList<String> a7 = new ArrayList<>();
        a7.add("c");



        System.out.println(c.findSubstring("c",a7));

    }
}
