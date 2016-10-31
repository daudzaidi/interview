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
public class DetermineUpperCaseTest {

    @Autowired
    DetermineUpperCase uppercase;

    @Test
    public void testNull(){
        Assert.assertFalse(uppercase.isStringStartUpperCase(null));
    }

    @Test
    public void testValid1(){
        Assert.assertTrue(uppercase.isStringStartUpperCase("SpringBoard91"));
    }

    @Test
    public void testValid2(){
        Assert.assertTrue(uppercase.isStringStartUpperCase("ABcderfH"));
    }

    @Test
    public void testValid3(){
        Assert.assertTrue(uppercase.isStringStartUpperCase("ZddddcderfH"));
    }

    @Test
    public void testInvalid1(){
        Assert.assertFalse(uppercase.isStringStartUpperCase("springboard"));
    }

    @Test
    public void testInvalid2(){
        Assert.assertFalse(uppercase.isStringStartUpperCase("1234567"));

    }

}
