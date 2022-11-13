package com.javatechi;

import org.w3c.dom.ls.LSOutput;

import java.net.Inet4Address;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class PredicateDemo {
        //implements Predicate<Integer> {
//    @Override
//    public boolean test(Integer integer) {
//        if(integer%2==0)
//        {
//            return true;
//        }else
//        return false;
//    }

    //Used for conditonal Check...

    public static void main(String[] args) {
        /* PredicateDemo predicateDemo= new PredicateDemo();
        System.out.println( predicateDemo.test(24));*/



        /*
        Predicate<Integer> p = t->t%2==0;
        System.out.println(p.test(23));
*/

       List<Integer> list= Arrays.asList(23,45,6,7,3,90,78,55,33,43,879,7,54,76,98);
        System.out.println("Print even numbers:");
       list.stream().filter(c->c%2==0).forEach(System.out::println);

    Map.Entry e;
    }
}
