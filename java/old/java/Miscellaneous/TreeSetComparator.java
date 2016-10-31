package old.java.Miscellaneous;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by pandita on 9/12/2015.
 */

class AppServer{
    int size ;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    AppServer(int n){
        this.size=n;
    }
}

class sizeComparator implements Comparator<AppServer>{

    @Override
    public int compare(AppServer o1, AppServer o2) {
       return o2.getSize() - o1.getSize();
    }
}

public class TreeSetComparator {
public static void main(String args[]){

    System.out.println("Ordering of Elements using Comparator - user defined sorting logic");
    TreeSet<AppServer> set = new TreeSet<AppServer>(new sizeComparator());
    set.add(new AppServer(1200));
    set.add((new AppServer(1000)));
    set.add(new AppServer(3000));
    for(AppServer list : set){
        System.out.println(list.getSize());
    }
}
}
