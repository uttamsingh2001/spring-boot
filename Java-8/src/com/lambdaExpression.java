package com;


import java.util.HashMap;
import java.util.Map;

interface  Shape{

    void draw();
}

/*
class Rectangle implements Shape{

    @Override
    public void draw() {
        System.out.println("Reactangle class draw() method");
    }

}*/


/*class Circle implements Shape{


    @Override
    public void draw() {
        System.out.println("Circle class draw() method.....");
    }
}*/

public class lambdaExpression {
    public static void main(String[] args) {


      Shape  rectangle =()->  System.out.println("Circle class draw() method.....");

      rectangle.draw();

    rectangle = ()->System.out.println("Rectangle class draw() method.....");
    rectangle.draw();


        Map<Integer,String> map = new HashMap<>();
        map.put(12,"Omkar");
        map.put(23,"Balram");
        map.put(13,"Shambhu");
        map.put(16,"Raj");
        map.put(54,"Kedar");
        map.put(11,"Saurabh");

        map.forEach((key,value)-> System.out.println("key="+key));


    }




}
