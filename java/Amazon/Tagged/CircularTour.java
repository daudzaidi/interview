package Amazon.Tagged;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by shyamsunderpandita on 19/10/16.
 */
public class CircularTour {

    public static int startPoint(PetrolPump[] arr){
        if(arr.length == 1){
            return 1;
        }

        int i = 0 ;  int start = 0 ; int end = arr.length -1;
        int curr_petrol = arr[0].petrol;
        while(start != end){

            if(i == arr.length){
                return -1;
            }

            curr_petrol = curr_petrol - arr[start].dist;

            if(curr_petrol < 0 ){
                start = ++i;
                start = start % arr.length;
                end++;
                end = end % arr.length;
                curr_petrol = arr[start].petrol;
            }
            else{
                start++;
                start = start % arr.length;
                curr_petrol = curr_petrol+arr[start].petrol;
            }

            if(start == end){
                curr_petrol = curr_petrol - arr[start].dist;
                if(curr_petrol < 0){
                    start = i++;
                }
                else{
                    break;
                }
            }
        }
    return i;

    }

    public static void main(String... args){
        PetrolPump [] arr = new PetrolPump[4];
        arr[0] = new PetrolPump(4,6,0);
        arr[1] = new PetrolPump(6,5,1);
        arr[2] = new PetrolPump(7,3,2);
        arr[3] = new PetrolPump(4,5,3);
        System.out.println("Starting Point is = "+ CircularTour.startPoint(arr));

        PetrolPump [] arr2 = new PetrolPump[3];
        arr2[0] = new PetrolPump(6,4,0);
        arr2[1] = new PetrolPump(3,6,1);
        arr2[2] = new PetrolPump(7,3,2);
        System.out.println("Starting Point is = "+ CircularTour.startPoint(arr2));

        PetrolPump [] arr3 = new PetrolPump[3];
        arr3[0] = new PetrolPump(1,4,0);
        arr3[1] = new PetrolPump(1,6,1);
        arr3[2] = new PetrolPump(1,3,2);
        System.out.println("Starting Point is = "+ CircularTour.startPoint(arr3));
    }
}

class PetrolPump{
    int petrol;
    int dist;
    int id;
    public PetrolPump(int a, int b, int c){
        this.petrol = a;
        this.dist = b;
        this.id = c;
    }
}
