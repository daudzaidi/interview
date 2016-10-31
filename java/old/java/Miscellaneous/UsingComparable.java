package old.java.Miscellaneous;

import java.util.TreeSet;

/**
 * Created by pandita on 9/12/2015.
 */
public class UsingComparable implements Comparable<UsingComparable> {
    public int getValue() {
        return value;
    }

    private int value;
    @Override
    public int compareTo(UsingComparable o) {
       return this.getValue()-o.getValue();
    }

    public void setValue(int value) {
        this.value = value;
    }

    public UsingComparable(int n ){
        this.setValue(n);
    }
}

class usingMain{
    public static void main(String args[]){
        UsingComparable u1 = new UsingComparable(1);
        UsingComparable u2 = new UsingComparable(1);

        int res = u1.compareTo(u2);
        if(res==0){
            System.out.println("Equal Objects");
        }
        else{

        }

        System.out.println("Natural Ordering of elements");
        TreeSet<UsingComparable> set = new TreeSet<UsingComparable>();
        set.add(new UsingComparable(1200));
        set.add((new UsingComparable(1000)));
        set.add(new UsingComparable(3000));
        for(UsingComparable list : set){
            System.out.println(list.getValue());
        }
    }
}
