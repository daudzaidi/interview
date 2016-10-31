package old.java.LinkedListProblems;

import old.java.SinglyLinkedList.SinglyLinkedListImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Assert;

/**
 * Created by pandita on 1/4/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:environment-context.xml")
public class PalindromTestCases {
    @Autowired
    private CheckPlaindrome plaindrome;

    @Test
    public void testNullRecursive(){
        SinglyLinkedListImpl<Integer> sl = null;
        boolean isPalindrom = plaindrome.CheckPalindomeImpl(sl);
        Assert.assertFalse("Method returning true with linked list as null",isPalindrom);
    }

    @Test
    public void testNullStackImpl(){
        SinglyLinkedListImpl<Integer> sl = null;
        boolean isPalindrom = plaindrome.checkPalindromStackImpl(sl);
        Assert.assertFalse("Method returning true with linked list as null",isPalindrom);
    }

    @Test
    public void testPositiveIntegerListRecursive(){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.add(33);
        sl.add(89);
        sl.add(54);
        sl.add(32);
        sl.add(3);

        CheckPlaindrome<Integer> pal = new CheckPlaindrome<Integer>();
        boolean isPalindrom = pal.CheckPalindomeImpl(sl);
        Assert.assertTrue("List is a Plaindrome but returning false",isPalindrom);
    }

    @Test
    public void testPositiveIntegerListStackImpl(){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.add(33);
        sl.add(89);
        sl.add(54);
        sl.add(32);
        sl.add(3);

        CheckPlaindrome<Integer> pal = new CheckPlaindrome<Integer>();
        boolean isPalindrom = pal.checkPalindromStackImpl(sl);
        Assert.assertTrue("List is a Plaindrome but returning false",isPalindrom);
    }

    @Test
    public void testNegativeIntegerListRecursive(){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(70);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.add(33);
        sl.add(89);
        sl.add(54);
        sl.add(32);
        sl.add(3);
        sl.add(10);

        CheckPlaindrome<Integer> pal = new CheckPlaindrome<Integer>();
        boolean isPalindrom = pal.CheckPalindomeImpl(sl);
        Assert.assertFalse("List is a not Plaindrome but returning true",isPalindrom);
    }

    @Test
    public void testNegativeIntegerListStackImpl(){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(70);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.add(33);
        sl.add(89);
        sl.add(54);
        sl.add(32);
        sl.add(3);
        sl.add(10);
        CheckPlaindrome<Integer> pal = new CheckPlaindrome<Integer>();
        boolean isPalindrom = pal.checkPalindromStackImpl(sl);
        Assert.assertFalse("List is a not Plaindrome but returning true",isPalindrom);
    }

    @Test
    public void testPositiveCharacterListRecursive(){
        SinglyLinkedListImpl<Character> sl = new SinglyLinkedListImpl<Character>();
        sl.add('a');
        sl.add('b');
        sl.add('c');
        sl.add('d');
        sl.add('d');
        sl.add('c');
        sl.add('b');
        sl.add('a');

        CheckPlaindrome<Character> pal = new CheckPlaindrome<Character>();
        boolean isPalindrom = pal.CheckPalindomeImpl(sl);
        Assert.assertTrue("List is a Plaindrome but returning false",isPalindrom);
    }

    @Test
    public void testPositiveCharacterListStackImpl(){
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        sl.add(3);
        sl.add(32);
        sl.add(54);
        sl.add(89);
        sl.add(33);
        sl.add(89);
        sl.add(54);
        sl.add(32);
        sl.add(3);

        CheckPlaindrome<Integer> pal = new CheckPlaindrome<Integer>();
        boolean isPalindrom = pal.checkPalindromStackImpl(sl);
        Assert.assertTrue("List is a Plaindrome but returning false",isPalindrom);
    }

    @Test
    public void testNegativeCharacterListRecursive(){
        SinglyLinkedListImpl<Character> sl = new SinglyLinkedListImpl<Character>();
        sl.add('a');
        sl.add('g');
        sl.add('b');
        sl.add('c');
        sl.add('d');
        sl.add('d');
        sl.add('c');
        sl.add('b');
        sl.add('a');
        sl.add('g');

        CheckPlaindrome<Character> pal = new CheckPlaindrome<Character>();
        boolean isPalindrom = pal.CheckPalindomeImpl(sl);
        Assert.assertFalse("List is a not Plaindrome but returning true",isPalindrom);
    }

    @Test
    public void testNegativeCharacterListStackImpl(){
        SinglyLinkedListImpl<Character> sl = new SinglyLinkedListImpl<Character>();
        sl.add('a');
        sl.add('g');
        sl.add('b');
        sl.add('c');
        sl.add('d');
        sl.add('d');
        sl.add('c');
        sl.add('b');
        sl.add('a');
        sl.add('g');
        CheckPlaindrome<Character> pal = new CheckPlaindrome<Character>();
        boolean isPalindrom = pal.checkPalindromStackImpl(sl);
        Assert.assertFalse("List is a not Plaindrome but returning true",isPalindrom);
    }
}
