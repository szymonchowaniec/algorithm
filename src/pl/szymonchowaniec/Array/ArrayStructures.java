package pl.szymonchowaniec.Array;



public class ArrayStructures {
    private int [] theArray = new int[50];
    private int arraySize = 10;


    public void generateRandomArray(){
        for (int i = 0; i < arraySize ; i++) {
            theArray[i] = (int) (Math.random()*10)+10;
        }
    }
    public void printArray(){
        System.out.println("----------");

        for (int i = 0; i < arraySize; i++) {
            System.out.print("| "+i+" | ");
            System.out.println( theArray[i] +" | ");
            System.out.println("----------");
        }
    }
    public int getValueAtIndex(int index){
        if (index<arraySize) return theArray[index];
        else return 0;
    }

    public boolean doesArrayContainsThisValue(int value){
        boolean itIs = false;

        for (int i = 0; i < arraySize  ; i++) {
           if(value == theArray[i]) itIs = true;

        }
        return itIs;
    }

    public void deleteIndex(int index){

        if( index < arraySize ){

            for (int i = index; i < arraySize-1 ; i++) {
                theArray[i]=theArray[i+1];
            }
            arraySize--;
        }
    }

    public void deleteIndexRecursion(int index){

        if(index<arraySize) {
            theArray[index] = theArray[index + 1];
            index = index + 1;
            deleteIndexRecursion(index);
        }
    }

    public void insertValue(int value){
        if(arraySize<50){
            theArray[arraySize] = value;
            arraySize++;
        }

    }

    public int linearSearch(int value){
        int counter = 0;
        for (int i = 0; i < arraySize; i++) {
            if(theArray[i] == value) counter ++;
        }
        return counter;
    }

    public String linearSearchWithIndex(int value){
        StringBuilder indexesWithValue = new StringBuilder();
        boolean valueInArray = false;

        System.out.println("The value found in following index; ");
        for (int i = 0; i < arraySize; i++) {
            if(theArray[i] == value){
                valueInArray = true;
                System.out.println(i+" ");
                indexesWithValue.append(i).append(" ");
            }
        }

        if(!valueInArray){
            System.out.println("None");
        }

        return indexesWithValue.toString();
    }

    public static void main(String[] args) {
        ArrayStructures arrayStructures = new ArrayStructures();
        arrayStructures.generateRandomArray();
        arrayStructures.printArray();
        System.out.println("Get value at Index 4: "+arrayStructures.getValueAtIndex(4));
//        System.out.println("Does Array contains value 10: "+ arrayStructures.doesArrayContainsThisValue(10));

//        System.out.println("I want delete value at index 2 (recursion method) and print Array");
//        arrayStructures.deleteIndexRecursion(3);
//        arrayStructures.printArray();
//
//        System.out.println("I want delete value at index 3 (for loop method) and print Array");
//        arrayStructures.deleteIndex(6);
//        arrayStructures.printArray();

//        arrayStructures.insertValue(22);


        System.out.format("We looking for number 15. It appears %d times in Array.%n ", arrayStructures.linearSearch(15) );

        arrayStructures.linearSearchWithIndex(15);
    }

}
