package pl.szymonchowaniec.HashFunction;

import java.util.*;

public class HashFunction {
    String [] theArray;
    int arraySize;
    int itemInArray = 0;

    public static void main(String[] args) {
        HashFunction theFunc = new HashFunction(30);

//        String [] elementsToAdd = {"1","5","5","9","22","24","5"};
//
//        theFunc.hashFunction1(elementsToAdd, theFunc.theArray);

        String[] elementsToAdd2 = { "100", "510", "170", "214", "268", "398",
                "235", "802", "900", "723", "699", "1", "16", "999", "890",
                "725", "998", "978", "988", "990", "989", "984", "320", "321",
                "400", "415", "450", "50", "660", "624" };

        theFunc.hashFunction2(elementsToAdd2, theFunc.theArray);

        theFunc.findKey("660");

        theFunc.displayTheStack();
        System.out.println(27%29);

    }

    public HashFunction(int size) {
        this.arraySize = size;
        theArray = new String[size];
        Arrays.fill(theArray,"-1");
    }

    public void hashFunction1(String [] stringsForArray, String [] theArray){
        for(int n = 0; n < stringsForArray.length; n++){
            String newElementValue = stringsForArray[n];

            theArray[Integer.parseInt(newElementValue)] = newElementValue;
        }
    }
    public void hashFunction2(String [] stringsForArray, String [] theArray){
        for(int n = 0; n < stringsForArray.length; n++){
            String newElementValue = stringsForArray[n];

            int arrayIndex = Integer.parseInt(newElementValue) % 29;

            System.out.println("Modulus Index= "+ arrayIndex + "for value: "+newElementValue);

            while(theArray[arrayIndex] != "-1"){
                ++arrayIndex;
                System.out.println("Collision Try "+ arrayIndex + " Instead");

                arrayIndex = arrayIndex % arraySize;
            }
            theArray[arrayIndex] = newElementValue;
        }
    }


    public String findKey( String value){

        int arrayIndexHash = Integer.parseInt(value) % 29;

        while (theArray[arrayIndexHash] !="-1"){
            if(theArray[arrayIndexHash]==value){
                System.out.println(value + " was Found in Index " + arrayIndexHash);
                return theArray[arrayIndexHash];
            }
            ++arrayIndexHash;

            arrayIndexHash %= arraySize;
        }

        return "We can not find this value!";
    }


    public void displayTheStack() {

        int increment = 0;

        for (int m = 0; m < 3; m++) {

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

                if (theArray[n].equals("-1"))
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
}
