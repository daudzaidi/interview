package old.java.Groupon;

/**
 * Created by pandita on 1/4/2016.
 */

public class LemursVsBanana {
    public static void main(String args[] ) throws Exception {
         /*
         * Read input from stdin and provide input before running */
        int minutes = 1;
        int K =0 ; int N = 0;
      /*  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int L = Integer.parseInt(line);
        for (int i = 0; i < L; i++) {
            line = br.readLine();
            if (line != null) {
                K = Integer.parseInt(line); //lemurs
                line = br.readLine();
                if (line != null) {
                    N = Integer.parseInt(line); //bananas
                }
            }
        }*/

        K=1; N=74;

        if(K%N ==0){
            System.out.println(minutes);
        }

        else{
            int min = 0;
            int []current=new int[8];
            int k =K;
            int n =N;
            while(k%n!=0){
                k=k+1;
                current[0]+=1;
            }
            k=K;
            n=N;

            while(k%n!=0 && k>=2){
                k=k-1;
                n=n-1;
                current[4]+=2;
            }

            k=K;
            n=N;

            while(k%n!=0 && k>=2){
                k=k-1;
                n=n+1;
                current[5]+=2;
            }

            k=K;
            n=N;

            while(k%n!=0){
                k=k+1;
                n=n-1;
                current[6]+=2;
            }

            k=K;
            n=N;

            while(k%n!=0){
                k=k+1;
                n=n+1;
                current[7]+=2;
            }

            k=K;
            n=N;

            while(k%n!=0){
                n=n+1;
                current[1]+=1;
            }

            k=K;
            n=N;
            while(k%n!=0){
                n=n-1;
                current[2]+=1;
            }
            k=K;
            n=N;
            while(k%n!=0 && k>=2){
                k=k-1;
                current[3]+=1;
            }


            min = current[0];
            for(int i =1 ;i <8 ;i++){
                if(current[i] <min)
                {
                    min = current[i];
                }
            }
            System.out.println(min);

        }





    }
}
