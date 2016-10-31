package Amazon.Tagged;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shyamsunderpandita on 18/10/16.
 */
public class GenerateIPAddress {

    public static boolean ok(int a, int b, int c, int d){
        return (a <=255 && b <=255 && c<=255 && d<=255);
    }

    public static String genIP(int a, int b, int c, int d){
        return a+"."+b+"."+c+"."+d;
    }

    public static List<String> getValidIPs(String s){
        List<String> res = new ArrayList<>();

        if(s.length()>12 || s.length() <4){
            return res;
        }

        for(int i = 1; i<=3 ;i++){
            for(int j = 1 ; j<= 3; j++){
                for(int k = 1 ; k<=3;k++){
                    for (int l = 1 ; l <=3 ; l++){

                        if(i+j+k+l == s.length()){
                            String aStr = s.substring(0,i);
                            String bStr = s.substring(i,i+j);
                            String cStr = s.substring(i+j,i+j+k);
                            String dStr = s.substring(i+j+k,i+j+k+l);

                            int a = Integer.parseInt(aStr);
                            int b = Integer.parseInt(bStr);
                            int c = Integer.parseInt(cStr);
                            int d = Integer.parseInt(dStr);
                            if(ok(a,b,c,d)){
                                String str = genIP(a,b,c,d);
                                if(str.length() == s.length()+3){
                                    res.add(str);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String... args){
        List<String> IPs = GenerateIPAddress.getValidIPs("10211");
        for(String ip:IPs)
            System.out.println(ip);
    }
}
