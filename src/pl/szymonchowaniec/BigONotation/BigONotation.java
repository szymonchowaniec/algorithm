package pl.szymonchowaniec.BigONotation;

public class BigONotation {

    private int[] theArray;

    private int arraySize;

    private int itemsInArray = 0;

    static long startTime;

    static long endTime;

    public static void main(String[] args) {

        /*
         * 0(1) Test BigONotation testAlgo = new BigONotation(10);
         *
         * testAlgo.addItemToArray(10);
         *
         * System.out.println(Arrays.toString(testAlgo.theArray));
         */

        BigONotation testAlgo2 = new BigONotation(100000);
        testAlgo2.generateRandomArray();

        BigONotation testAlgo3 = new BigONotation(200000);
        testAlgo3.generateRandomArray();

        BigONotation testAlgo4 = new BigONotation(30000);
        testAlgo4.generateRandomArray();

        BigONotation testAlgo5 = new BigONotation(400000);
        testAlgo5.generateRandomArray();

        /*
         * O(N) Test
         *
         * testAlgo2.linearSearchForValue(20);
         *
         * testAlgo3.linearSearchForValue(20);
         *
         * testAlgo4.linearSearchForValue(20);
         *
         * testAlgo5.linearSearchForValue(20);
         */

        // O(N^2) Test
        /*
         * testAlgo2.bubbleSort();
         *
         * testAlgo3.bubbleSort();
         *
         * testAlgo4.bubbleSort();
         *
         * // 0 (log N) Test
         *
         * testAlgo2.binarySearchForValue(20);
         * testAlgo3.binarySearchForValue(20);
         */

        // O (n log n) Test

        startTime = System.currentTimeMillis();

        testAlgo2.quickSort(0, testAlgo2.itemsInArray);

        endTime = System.currentTimeMillis();

        System.out.println("Quick Sort Took " + (endTime - startTime));

    }


    public void addItemToArray(int newItem) {

        theArray[itemsInArray++] = newItem;

    }


    public void linearSearchForValue(int value) {

        boolean valueInArray = false;
        String indexsWithValue = "";

        startTime = System.currentTimeMillis();

        for (int i = 0; i < arraySize; i++) {

            if (theArray[i] == value) {
                valueInArray = true;
                indexsWithValue += i + " ";
            }

        }

        System.out.println("Value Found: " + valueInArray);

        endTime = System.currentTimeMillis();

        System.out.println("Linear Search Took " + (endTime - startTime));

    }


    public void bubbleSort() {

        startTime = System.currentTimeMillis();

        for (int i = arraySize - 1; i > 1; i--) {

            for (int j = 0; j < i; j++) {

                if (theArray[j] > theArray[j + 1]) {

                    swapValues(j, j + 1);

                }
            }
        }

        endTime = System.currentTimeMillis();

        System.out.println("Bubble Sort Took " + (endTime - startTime));
    }


    public void binarySearchForValue(int value) {

        startTime = System.currentTimeMillis();

        int lowIndex = 0;
        int highIndex = arraySize - 1;

        int timesThrough = 0;

        while (lowIndex <= highIndex) {

            int middleIndex = (highIndex + lowIndex) / 2;

            if (theArray[middleIndex] < value)
                lowIndex = middleIndex + 1;

            else if (theArray[middleIndex] > value)
                highIndex = middleIndex - 1;

            else {

                System.out.println("\nFound a Match for " + value
                        + " at Index " + middleIndex);

                lowIndex = highIndex + 1;

            }

            timesThrough++;

        }


        endTime = System.currentTimeMillis();

        System.out.println("Binary Search Took " + (endTime - startTime));

        System.out.println("Times Through: " + timesThrough);

    }


    public void quickSort(int left, int right) {

        if (right - left <= 0)
            return;

        else {

            int pivot = theArray[right];

            int pivotLocation = partitionArray(left, right, pivot);

            quickSort(left, pivotLocation - 1);
            quickSort(pivotLocation + 1, right);

        }

    }

    public int partitionArray(int left, int right, int pivot) {

        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {

            while (theArray[++leftPointer] < pivot)
                ;

            while (rightPointer > 0 && theArray[--rightPointer] > pivot)
                ;

            if (leftPointer >= rightPointer) {

                break;

            } else {

                swapValues(leftPointer, rightPointer);

            }

        }

        swapValues(leftPointer, right);

        return leftPointer;

    }

    BigONotation(int size) {

        arraySize = size;

        theArray = new int[size];

    }

    public void generateRandomArray() {

        for (int i = 0; i < arraySize; i++) {

            theArray[i] = (int) (Math.random() * 1000) + 10;

        }

        itemsInArray = arraySize - 1;

    }

    public void swapValues(int indexOne, int indexTwo) {

        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;

    }

}
