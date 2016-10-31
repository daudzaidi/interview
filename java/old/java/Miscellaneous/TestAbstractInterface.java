package old.java.Miscellaneous;

import java.util.ArrayList;

/**
 * Created by pandita on 10/30/2015.
 */
public class TestAbstractInterface extends B implements A{
public static void main(String args[]){
    A a = new A() {
        @Override
        public void methodA() {
            System.out.println("In methodA");
        }
    };

    a.methodA();

    B b = new B() {
        @Override
        void methodB() {
            System.out.println("Inside method B");
        }
    };

    b.methodB();
    TestAbstractInterface t = new TestAbstractInterface();
    t.methodB();
    A aa = t;
    aa.methodA();
    B bb =t;
    bb.methodB();
    bb.methodC();
    ArrayList<Integer> arr = new ArrayList<Integer>();

    int i =5;
    float f = 6.5F;
    i=(int)f;
}

    @Override
    void methodB() {
        System.out.println("Inside overridden methodB");
    }

    @Override
    public void methodA() {
        System.out.println("Inside overridden methodA");
    }
}

interface A{
 void methodA();
}

abstract class B{
        abstract void  methodB();
        void methodC(){
            System.out.println("In methodC");
        }
}

class check {

    void methodD(){
        System.out.println("In methodD");
    }
}