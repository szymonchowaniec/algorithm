package pl.szymonchowaniec.StackQueue;

import java.util.Arrays;

public class TheQueue {
    private String [] queueArray;
    private int queueSize;
    private int front, rear, numberOfItems = 0;

    TheQueue(int size){
        queueSize = size;
        queueArray = new String[size];
        Arrays.fill(queueArray,"-1");
    }

    public void insert(String input){
        if(numberOfItems+1<=queueSize){
            queueArray[rear] = input;

            rear++;
            numberOfItems++;
            System.out.println("Insert "+ input +" was added to queue.");
        }
        else{
            System.out.println("You cannot insert an input. The Queue is full.");
        }
    }

    public void remove(){
        if(numberOfItems>0){

            System.out.println("Remove "+ queueArray[front] +" was removed from queue.");
            queueArray[front] = "-1";

            front++;
            numberOfItems--;
        }
        else{
            System.out.println("You cannot remove anything. The Queue is empty.");
        }
    }
    public void peep(){
        System.out.println("The first element in queue is: "+queueArray[front]);
    }

    public void priorityQueue(String input){

        int i;
        if(numberOfItems==0){
            insert(input);
        }
        else{
            for ( i = numberOfItems; i >=0 ; i--) {
                if(Integer.parseInt(input)>Integer.parseInt(queueArray[i])){
                    queueArray[i+1]=queueArray[i];
                }
                else break;
            }

            queueArray[i+1] = input;

            rear++;
            numberOfItems++;
        }


    }

    public static void main(String[] args) {
        TheQueue theQueue = new TheQueue(10);

     theQueue.insert("10");
     theQueue.insert("10");
     theQueue.insert("10");
     theQueue.insert("10");
     theQueue.insert("10");
     theQueue.insert("10");
     theQueue.priorityQueue("19");
     theQueue.peep();

    }
}
