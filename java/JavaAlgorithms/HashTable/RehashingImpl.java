package JavaAlgorithms.HashTable;

import java.util.Arrays;

/**
 * Created by shalvi on 21/05/16.
 */
public class RehashingImpl {

    int arraySize;
    String[] theArray;

    public RehashingImpl(int size){
        this.arraySize = size;
        this.theArray = new String[size];
        Arrays.fill(theArray,"-1");
    }

    public void hashFunctionModulus(String[] numbersToBeInserted, String[] theArray){
        for(int i =0;i<numbersToBeInserted.length;i++){
            String number = numbersToBeInserted[i];
            //int mod = arraySize-1;
            int index = Integer.parseInt(numbersToBeInserted[i]) % arraySize;
            System.out.println("Modulus Index= " + index + " for value " + number);
            while(theArray[index]!="-1"){
                System.out.println("Collision occurred at index "+ index +" for value "+ number);
                ++index;
                System.out.println("Trying index "+index+" instead");
                index = index % arraySize;
                System.out.println("Modulus Index= " + index + " for value " + number);
            }
            theArray[index] = number;
        }

    }

    public void findKey(String key){

        int hashIndex = Integer.parseInt(key)%29;

        while(theArray[hashIndex]!="-1"){
            if(theArray[hashIndex] == key){
                System.out.println("Found the key "+ key + " at index "+ hashIndex);
                return;
            }
            ++hashIndex;
            hashIndex%=arraySize;
        }
        System.out.println("Could not Locate the key "+ key);
    }
}
