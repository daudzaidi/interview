package JavaAlgorithms.HashTable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by shalvi on 20/05/16.
 */
public class BasicHashTableImpl {

    String [] theArray;
    int arraySize;

    public BasicHashTableImpl(int size){
        arraySize = size;
        theArray = new String[arraySize];
        Arrays.fill(theArray,"-1");
    }

    public void hashFunction(String[] numbersToBeInserted, String[] array){
        for(int i =0;i<numbersToBeInserted.length;i++){
            String numLocation = numbersToBeInserted[i];
            array[Integer.parseInt(numbersToBeInserted[i])] = numLocation;
        }
    }

    public void hashFunctionModulus(String[] numbersToBeInserted, String[] array){
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
            array[index] = number;
        }

    }

    public void doubleHashFunctionModulus(String[] numbersToBeInserted, String[] array){
        for(int i =0;i<numbersToBeInserted.length;i++){
            String number = numbersToBeInserted[i];
            //int mod = arraySize-1;
            int index = Integer.parseInt(numbersToBeInserted[i]) % arraySize;

            int stepSize = 11 -(Integer.parseInt(number)%11);
            System.out.println("Modulus Index= " + index + " for value " + number);
            while(theArray[index]!="-1"){
                System.out.println("Collision occurred at index "+ index +" for value "+ number);
                index += stepSize;
                System.out.println("Trying index "+index+" instead");
                index = index % arraySize;
                System.out.println("Modulus Index= " + index + " for value " + number);
            }
            array[index] = number;
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

    public boolean isPrime(int n){
        if(n%2 ==0)
            return false;
        for(int i =3; i*i <=n ;i+=2){
            if(n%i==0)
                return false;
        }

        return true;
    }

    public int getNextPrime(int minNumber){
        for(int i=minNumber+1;true;i++){
            if(isPrime(i))
                return i;
        }
    }

    private void increaseArraySize(int minArraySize){
        int newSize = getNextPrime(minArraySize);
        System.out.println("NEW SIZE = "+ newSize);
        moveOldArray(newSize);
    }

    private void moveOldArray(int newSize) {

        String[] cleanArray = removeEmptySpacesinArray(theArray);
        theArray = new String[newSize];
        arraySize = newSize;
        Arrays.fill(theArray,"-1");
        hashFunctionModulus(cleanArray,theArray);
    }

    private String[] removeEmptySpacesinArray(String[] theArray) {
        ArrayList<String>   stringList = new ArrayList<String>();
        for(String str: theArray){
            if(!str.equals("-1") && !str.equals(""))
                stringList.add(str);
        }
        return stringList.toArray(new String[stringList.size()]);
    }


    public void displayHashTable(){
        int increment = 0;

        int numberOfRows = (arraySize / 10) + 1;

        for (int m = 0; m < numberOfRows; m++) {

            increment += 10;

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {

                System.out.format("| %3s " + " ", n);

            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

            for (int n = increment - 10; n < increment; n++) {

                if (n >= arraySize)
                    System.out.print("|      ");

                else if (theArray[n].equals("-1"))
                    System.out.print("|      ");

                else
                    System.out
                            .print(String.format("| %3s " + " ", theArray[n]));

            }

            System.out.println("|");

            for (int n = 0; n < 71; n++)
                System.out.print("-");

            System.out.println();

        }
    }

    public static void main (String args[]){
        BasicHashTableImpl hashtable = new BasicHashTableImpl(30);
        String [] numbToFill = {"1","17","26","20"};
        hashtable.hashFunction(numbToFill,hashtable.theArray);
        hashtable.displayHashTable();

        BasicHashTableImpl hashtable2 = new BasicHashTableImpl(30);
        String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398", "235",
                "802", "900", "723", "699", "1", "16", "999", "890", "725", "998",
                "978", "988", "990", "989", "984", "320", "321", "400", "415", "450",
                "50", "660", "411" };
        hashtable2.hashFunctionModulus(elementsToAdd2,hashtable2.theArray);

        hashtable2.displayHashTable();
        hashtable2.findKey("660");
        //hashtable2.findKey("10"); // goes into infinite loop if key not present

        // Demonstrate how data normally follows patterns and how // a non-prime sized array can cause havoc  // multiples of 30 below
        BasicHashTableImpl hashtable3 = new BasicHashTableImpl(30);
        String[] elementsToAdd3 = { "30", "60", "90", "120", "150", "180",
                "210", "240", "270", "300", "330", "360", "390", "420", "450",
                "480", "510", "540", "570", "600", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };
        hashtable3.hashFunctionModulus(elementsToAdd3,hashtable3.theArray);
        hashtable3.displayHashTable();
        //hashtable2.findKey("660");


        //using prime number as the array size
        BasicHashTableImpl hashtable4 = new BasicHashTableImpl(31);
        hashtable4.hashFunctionModulus(elementsToAdd3,hashtable4.theArray);
        hashtable4.displayHashTable();


        hashtable2.increaseArraySize(60);
        hashtable2.displayHashTable();
    }
}
