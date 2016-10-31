package Amazon.Tagged;

import java.util.Scanner;

/**
 * Created by shyamsunderpandita on 24/10/16.
 */
public class Replace5With0 {

    public static void main(String... args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        for(int i = 0 ; i<n ;i++){
            System.out.println(replace(scanner.nextInt()));
        }

    }

    private static int replace(int i) {
        int output = 0 ;
        if (i == 0)
            output = 5;

        int mul = 1;
        while(i > 0){
            int rem = i % 10;
            if(rem == 0){
                rem = 5;
            }
            output = output + (mul*rem);
            mul = mul *10;
            i = i / 10;
        }

        return output;
    }
}
