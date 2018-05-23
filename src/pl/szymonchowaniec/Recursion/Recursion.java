package pl.szymonchowaniec.Recursion;

public class Recursion {

    int triangularNumber = 1;

    public int getTriangularNum(int value){

        System.out.println("Method "+ value);

        if(value == 1) {
            System.out.println("Returned 1.");
            return 1;
        }
        else {
            int results = value + getTriangularNum(value-1);
            System.out.print("Returned :"+ results);
            System.out.println(" : "+ value+ " +get TN("+value+"-1)");
            return results;
        }
    }

    public int getTriangularNumber2(int number){
        while (number>0){
            triangularNumber+=number;
            number--;
        }
        return triangularNumber;
    }

    public int getFactorial(int value){

        System.out.println("Method "+ value);

        if(value == 1) {
            System.out.println("Returned 1.");
            return 1;
        }
        else {
            int results = value * getFactorial(value-1);
            System.out.print("Returned :"+ results);
            System.out.println(" : "+ value+ " *get FACT("+value+"-1)");
            return results;
        }
    }

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
       recursion.getFactorial(100);
    }

}
