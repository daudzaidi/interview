package DesignQuestions;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by shyamsunderpandita on 09/11/16.
 */
public class ConsistentHash {
    private static int MAX_REPLICA = 100;
    private SortedMap<BigInteger, String> entries = new TreeMap<>();

    public void put(String node) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        BigInteger key = hash(node);
        entries.put(key, node);

        for (int i = 0 ; i < MAX_REPLICA ; i++ ) {
            key = hash(node + ":" + i);
            entries.put(key, node);
        }
    }

    private String get(String entry) throws NoSuchAlgorithmException,
            UnsupportedEncodingException{
        assert !entries.isEmpty() : "Handle this case properly";

        BigInteger key = hash(entry);

        if (!entries.containsKey(key)) {
            SortedMap<BigInteger, String> tailMap = entries.tailMap(key);
            key = tailMap.isEmpty() ? entries.firstKey() : tailMap.firstKey();
        }

        return entries.get(key);
    }

    private BigInteger hash(String node) throws NoSuchAlgorithmException,
            UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] checksum = md5.digest(node.getBytes("UTF-8"));
        return new BigInteger(1, checksum);
    }

    public static void main(String[] args) throws Exception {
        ConsistentHash s = new ConsistentHash();

        for (char c = 'A' ; c <= 'Z' ; c++) {
            s.put(String.valueOf(c));
        }

        HashMap<String,Integer> countMap = new HashMap<>();

        for (int i = 0 ; i < 1000 ; i++) {
            if(countMap.containsKey(s.get("user-id-" + i + "-data"))){
                int val = countMap.get(s.get("user-id-" + i + "-data"));
                val++;
                countMap.put(s.get("user-id-" + i + "-data"),val);
            }
            else{
                countMap.put(s.get("user-id-" + i + "-data"),0);
            }

            //System.out.println(s.get("user-id-" + i + "-data"));
        }

        Iterator itr = countMap.entrySet().iterator();
        while(itr.hasNext()){
            Map.Entry pair = (Map.Entry)itr.next();
            System.out.println(pair.getKey()+" - "+ pair.getValue());
        }
    }
}
