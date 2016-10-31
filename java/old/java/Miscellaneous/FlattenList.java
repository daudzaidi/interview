package old.java.Miscellaneous;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by pandita on 1/5/2016.
 */
public class FlattenList {

    public  List<Object> flatten(List<?> list) {
        if(list==null)
            return null;

        List<Object> retVal = new LinkedList<Object>();
        flatten(list, retVal);
        return retVal;
    }

    public  void flatten(List<?> nestedList, List<Object> flatList) {
        for (Object item : nestedList) {
            if (item instanceof List<?>) {
                flatten((List<?>) item, flatList);
            } else {
                flatList.add(item);
            }
        }
    }

    public static void main(String[] args) {
        List<Object> treeList = a(a(1), 2, a(a(3, 4), 5), a(a(a())), a(a(a(6))), 7, 8, a());
        FlattenList flattenList=new FlattenList();
        List<Object> flatList = flattenList.flatten(treeList);
        System.out.println(treeList);
        System.out.println("flatten: " + flatList);
    }

    private static List<Object> a(Object... a) {
        return Arrays.asList(a);
    }
}
