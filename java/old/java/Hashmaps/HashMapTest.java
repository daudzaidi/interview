package old.java.Hashmaps;

import java.util.HashMap;

/**
 * Created by pandita on 12/5/2015.
 */

class Clock {

    private final long startTime;

    public Clock() {
        startTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }
}

public class HashMapTest {
    long key;
    long value;

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashMapTest map = (HashMapTest) o;

        if (key != map.key) return false;
        return value == map.value;

    }

    @Override
    public int hashCode() {
        int result = (int) key;
        //result = 31 * result + value;
        result= (int) (key%260000);
        return result;
    }

    public static void main(String... args){
        Clock clock = new Clock();
        HashMap<Long,Long> map = new HashMap(260000);
        HashMapTest test=new HashMapTest();
        for(long i =0;i<260000000;i++)
        {
            test.setKey(i);
            test.setValue(i);
            //System.out.println(test.hashCode());
            map.put(test.getKey(),test.getValue());
        }
        System.out.println("elapsed Time: "+clock.getElapsedTime());

    }

}

