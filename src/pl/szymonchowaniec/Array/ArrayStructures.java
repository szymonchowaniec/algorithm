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

    public void inserValue(int value){
        if(arraySize<50){
            theArray[arraySize] = value;
            arraySize++;
        }

    }
}
