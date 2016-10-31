package old.java.Spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by pandita on 9/3/2015.
 */
public class DrawingApp {

    public static void main(String args[]){

        ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
        Triangle myBean= (Triangle) context.getBean("triangle");
        myBean.draw();
        System.out.println("Type: "+myBean.getType());

    }
}
