package Amazon.Tagged;

/**
 * Created by shyamsunderpandita on 18/10/16.
 */
public class strstrImpl {

    static int strstr(String str, String target)
    {
        // Your code here
        int c = 0 ;
        for(int i = 0 ; i< str.length(); i++){
            if(str.charAt(i) == target.charAt(c)){
                int k = i+1;
                int j = 1;
                for(j =1 ; j < target.length() ; j++){
                    if(k>str.length()-1){
                        break;
                    }
                    if(str.charAt(k)!=target.charAt(j)){
                        break;
                    }
                    k++;
                }
                if(j == target.length()){
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String... args){
        System.out.println(strstrImpl.strstr("GeeksForGeeks","Fr"));
        System.out.println(strstrImpl.strstr("GeeksForGeeks","For"));
        System.out.println(strstrImpl.strstr("mississippi","sipi"));
        System.out.println(strstrImpl.strstr("s","s"));
    }

}
