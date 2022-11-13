package com;

import java.util.Map;

class  ThreadDemo implements Runnable{
    @Override
       public void run(){
        System.out.println("run method called..");

    }
}
public class RunnableLambdaExpression {
    public static void main(String[] args) {


        Thread thread = new Thread(new ThreadDemo());
        thread.start();


    }

}
