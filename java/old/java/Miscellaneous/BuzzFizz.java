package old.java.Miscellaneous;

/**
 * Created by pandita on 1/5/2016.
 */
public class BuzzFizz {

    public boolean printNumbers(int start, int end){

        if(start<=end) {
            for (int i = start; i <= end; i++) {
                if (i % 15 == 0)
                    System.out.println("FizzBuzz");
                else if (i % 3 == 0)
                    System.out.println("Fizz");
                else if (i % 5 == 0)
                    System.out.println("Buzz");
                else
                    System.out.println(i);
            }
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String... args){
        BuzzFizz bf = new BuzzFizz();
        bf.printNumbers(1,100);
    }
}
