package pl.szymonchowaniec.StackQueue;

import java.util.Arrays;

public class TheStack{

    private String [] stackArray;

    private int stackSize;

    private int topOfStack = -1;


    TheStack(int size){
        stackSize = size;
        stackArray =  new String [size];
        Arrays.fill(stackArray, "-1");
    }

    public void push(String input){
        if(topOfStack+1<stackSize){
            topOfStack++;
            stackArray[topOfStack] = input;
        }
        else System.out.println("Sorry but the Stack is Full");
    }

    public String pop(){
        if(topOfStack>=0){

            System.out.println("Pop "+ stackArray[topOfStack] + " was removed from stack");

            stackArray[topOfStack] = "-1";
           return stackArray[topOfStack--];
        }
        else{
            System.out.println("sorry but the stack is empty");
            return "-1";
        }

    }

    public String peek(){
        System.out.println("Peek "+ stackArray[topOfStack]+" From the stack");
        return stackArray[topOfStack];
    }

    public void pushMany(String multipleValues){
        String [] values = multipleValues.split(" ");

        for (int i = 0; i < values.length; i++) {
            push(values[i]);
        }
    }

    public void popAll(){
        for (int i = topOfStack; i >=0 ; i--) {
            pop();
        }
    }

    public static void main(String[] args) {
         TheStack theStack = new TheStack(6);

         theStack.push("12");
         theStack.pushMany("13 14 18");

        System.out.println(theStack.peek());


    }
}
