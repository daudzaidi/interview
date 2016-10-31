package java8.Lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shalvi on 23/06/16.
 */
public class StrategyPatternUsingLambda {
    public static void main(String... args){
        System.out.println("Strategy pattern on Steroids");
        List<Strategy>  strategies = Arrays.asList(
                ()-> {System.out.println("Perform Lazy Task");},
                () ->{System.out.println("Perform  Task Now");}
        );

        strategies.forEach((elem) -> elem.performTask());

        List<Computation<Integer>> computations = Arrays.asList(
                (n,m) -> {return n+m;},
                (n,m) -> {return n-m;},
                (n,m) -> {return n*m;}
        );

        computations.forEach((comp)-> System.out.println(comp.compute(10,4)));
    }
}
