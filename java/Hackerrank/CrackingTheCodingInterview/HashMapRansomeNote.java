package Hackerrank.CrackingTheCodingInterview;

import java.util.*;

/**
 * Created by shalvi on 28/09/16.
 */
public class HashMapRansomeNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;

    public HashMapRansomeNote(String magazine, String note) {
        magazineMap = new HashMap<String,Integer>();
        noteMap = new HashMap<String,Integer>();
        magazineMap = convertStringToMap(magazine);
        noteMap = convertStringToMap(note);
    }

    public Map<String,Integer> convertStringToMap(String s){
        Map<String,Integer> output = new HashMap<String,Integer>();
        if(s!=null){
            String[] str = s.split(" ");
            for(int i = 0 ;i<str.length ;i++){
                if(output.containsKey(str[i])){
                    int count = output.get(str[i]);
                    count++;
                    output.put(str[i],count);
                }
                else{
                    output.put(str[i],1);
                }
            }
        }
        return output;
    }

    public boolean solve() {
        Iterator it = noteMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if(!(magazineMap.containsKey(pair.getKey()) && magazineMap.get(pair.getKey()) < (Integer)pair.getValue())){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
        scanner.nextLine();

        HashMapRansomeNote s = new HashMapRansomeNote(scanner.nextLine(), scanner.nextLine());
        scanner.close();

        boolean answer = s.solve();
        if(answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
