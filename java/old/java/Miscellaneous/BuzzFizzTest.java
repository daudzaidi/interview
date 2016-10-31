package old.java.Miscellaneous;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by pandita on 1/5/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:environment-context.xml")
public class BuzzFizzTest {
    @Autowired
    BuzzFizz buzzfizz;

    @Test
    public void testValid1(){
        Assert.assertTrue(buzzfizz.printNumbers(1,100));
    }

    @Test
    public void testValid2(){
        Assert.assertTrue(buzzfizz.printNumbers(-100,100));
    }

    @Test
    public void testValid3(){
        Assert.assertTrue(buzzfizz.printNumbers(0,1000));
    }

    @Test
    public void testInvalid(){
        Assert.assertFalse(buzzfizz.printNumbers(100,0));
    }
}
