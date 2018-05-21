package pl.szymonchowaniec.Sort;

public class SortArray {

    private int [] theArray = new int[50];
    private int arraySize = 10;

    public void generateRandomArray(){
        for (int i = 0; i < arraySize ; i++) {
            theArray[i] = (int) (Math.random()*10)+10;
        }
    }

    public void printHorizontal(){

        System.out.println("-----------------------------------------------------");

        for (int i = 0; i < arraySize; i++) {
            System.out.print(" | "+i+""+" ");

        }
        System.out.println();
        System.out.println("-----------------------------------------------------");
        for (int i = 0; i < arraySize; i++) {

            System.out.print(" | " +theArray[i] );
        }
        System.out.println();
        System.out.println("-----------------------------------------------------");

    }

    public void bubbleSort(){

        for (int i = arraySize - 1; i > 1 ; i--) {

            for (int j = 0; j < i ; j++) {

                if (theArray[j]>theArray[j+1]){

                    swapValues(j,j+1);
                }
            }
        }
    }

    private void swapValues(int first , int second) {

        int temp = theArray[first];
        theArray[first] = theArray[second];
        theArray[second] = temp;
    }

    public void binarySearchForValue(int value){
        int lowIndex = 0;
        int highIndex = arraySize - 1;

        while(lowIndex <= highIndex){
            int middleIndex = (highIndex + lowIndex) /2;

            if( theArray[middleIndex] < value ) lowIndex = middleIndex + 1;
            else if ( theArray[middleIndex] > value )  highIndex = middleIndex - 1;
            else {
                System.out.println("Found a Match for :"+value+ " in index: "+middleIndex);
                lowIndex = highIndex+1;
            }
        }
    }

    public void selectionSort(){
        for (int i = 0; i < arraySize; i++) {

            int minimum = i;

            for (int j = i  ; j < arraySize; j++) {

                if(theArray[minimum]<theArray[j]){
                    minimum = j;
                }
            }
            swapValues(minimum,i);
        }
    }

    public void insertionSort(){
        for (int i = 1; i < arraySize ; i++) {

            int j = i;

            int toInsert = theArray[i];

            while ((j>0)&&(theArray[j-1])>toInsert){

                theArray[j] = theArray[j-1];

                j--;
            }
            theArray[j] = toInsert;
        }
    }


    public static void main(String[] args) {

        SortArray sortArray = new SortArray();

        sortArray.generateRandomArray();
        sortArray.printHorizontal();

        //       sortArray.bubbleSort();
//        sortArray.selectionSort();
        sortArray.insertionSort();

        sortArray.printHorizontal();

        sortArray.binarySearchForValue(19);
        sortArray.binarySearchForValue(11);
    }
}
