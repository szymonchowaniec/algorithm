package pl.szymonchowaniec;

import pl.szymonchowaniec.Array.ArrayStructures;

public class Main {

    public static void main(String[] args) {
        ArrayStructures arrayStructures = new ArrayStructures();
        arrayStructures.generateRandomArray();
        arrayStructures.printArray();
        System.out.println("Get value at Index 4: "+arrayStructures.getValueAtIndex(4));
        System.out.println("Does Array contains value 10: "+ arrayStructures.doesArrayContainsThisValue(10));

//        System.out.println("I want delete value at index 2 (recursion method) and print Array");
//        arrayStructures.deleteIndexRecursion(3);
//        arrayStructures.printArray();
//
//        System.out.println("I want delete value at index 3 (for loop method) and print Array");
//        arrayStructures.deleteIndex(6);
//        arrayStructures.printArray();

        arrayStructures.inserValue(22);
        arrayStructures.printArray();


    }
}
