package old.java.Miscellaneous.JSONConversion;

import old.java.Miscellaneous.FlattenList;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by pandita on 1/5/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:environment-context.xml")
public class FlattenListTest {
    @Autowired
    FlattenList flattenList;

    @Test
    public void testNull(){
        Assert.assertNull(flattenList.flatten(null));
    }

    @Test
    public void testValid1(){
        List<Object> treeList = a(a(1), 2, a(a(3, 4), 5), a(a(a())), a(a(a(6))), 7, 8, a());
        System.out.println(treeList);
        List<Object> flatList = flattenList.flatten(treeList);
        Assert.assertNotNull(flatList);
        System.out.println("flatten: " + flatList);
    }

    @Test
    public void testValid2(){
        List<Object> treeList = a(a('a'), 'b', a(a('c', 'd'), 'e'), a(a(a())), a(a(a('f'))), 'g', 'h', a());
        System.out.println(treeList);
        List<Object> flatList = flattenList.flatten(treeList);
        Assert.assertNotNull(flatList);
        System.out.println("flatten: " + flatList);
    }

    @Test
    public void testValid3(){
        List<Object> treeList = a(a(1), 2, a(a('a', 'b'), 'c'), a(a(a())), a(a(a(6))), 7, 8, a());
        System.out.println(treeList);
        List<Object> flatList = flattenList.flatten(treeList);
        Assert.assertNotNull(flatList);
        System.out.println("flatten: " + flatList);
    }

    private static List<Object> a(Object... a) {
        return Arrays.asList(a);
    }
}
