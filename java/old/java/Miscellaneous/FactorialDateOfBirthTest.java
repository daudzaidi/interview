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
public class FactorialDateOfBirthTest {
    @Autowired
    FactorialDateOfBirth factorial;

    @Test
    public void testNullDOB(){
        String dob = null;
        Assert.assertFalse("String is Null hence the result should be false as factorial cannot be calculated",factorial.calcFactorial(dob));
    }

    @Test
    public void testValidDOB1(){
        String dob = "01.05.91";
        Assert.assertTrue("Factorial must be calculated",factorial.calcFactorial(dob));
    }

    @Test
    public void testValidDOB2(){
        String dob = "31.12.20";
        Assert.assertTrue("Factorial must be calculated",factorial.calcFactorial(dob));
    }

    @Test
    public void testValidDOB3(){
        String dob = "29.02.97";
        Assert.assertTrue("Factorial must be calculated",factorial.calcFactorial(dob));
    }

    @Test
    public void testInvalidDOB(){
        String dob = "0105abc91";
        Assert.assertFalse("Invalid date format",factorial.calcFactorial(dob));
    }

    @Test
    public void testLargeLengthDOB(){
        String dob = "01-05-1991";
        Assert.assertFalse("Lenth too large. Valid Format is dd.mm.yy",factorial.calcFactorial(dob));
    }

}
