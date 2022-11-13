package com;

interface Addable{
    int addition(int a,int b);

}




public class LambdaParameters {
    public static void main(String[] args) {

        Addable addable=(a, b)-> {
            int c = a+b;
            return c;
        };

        System.out.println("Sum of two numbers is:"+addable.addition(23,32));
    }
}



