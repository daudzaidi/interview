package DocPractice;

/**
 * Created by shalvi on 27/05/16.
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:environment-context.xml")
public class setElementsToZeroTestCases {
    @Autowired setElementsToZero elementsToZero;

    @Test
    public void test1(){
        int [][] arr = {
                {1,2,0,4},
                {5,6,7,8},
                {0,10,11,12},
                {13,14,15,16}
        };

        elementsToZero.display(arr,4,4);

        System.out.println("After setting Elements to zero");
        elementsToZero.scanElementsZeroWithRowColumn(arr,4,4);

        elementsToZero.display(arr,4,4);

    }

    @Test
    public void test2(){
        int [][] arr = {
                {1,2,4,4},
                {5,6,7,8},
                {40,10,11,12},
                {13,14,15,16}
        };

        elementsToZero.display(arr,4,4);

        System.out.println("After setting Elements to zero");
        elementsToZero.scanElementsZeroWithRowColumn(arr,4,4);

        elementsToZero.display(arr,4,4);

    }

    @Test
    public void test3(){
        SinglyLinkedListImpl<Integer> sl = null;
        int [][] arr = {
                {1,2,0,4},
                {5,6,7,8},
                {0,10,11,12},
        };


        elementsToZero.display(arr,3,4);

        System.out.println("After setting Elements to zero");
        elementsToZero.scanElementsZeroWithRowColumn(arr,3,4);

        elementsToZero.display(arr,3,4);

    }

    @Test
    public void test4(){

        int [][] arr = null;

        elementsToZero.scanElementsZeroWithRowColumn(arr,0,0);

    }

}

