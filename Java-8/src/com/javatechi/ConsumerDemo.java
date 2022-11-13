package com.javatechi;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<Integer> consumer= x-> System.out.println("Number is:"+x);
     // consumer.accept(234);

        List<Integer> list1= Arrays.asList(1,2,3,4,5);

        list1.stream().forEach(x-> System.out.println("Number is:"+x));
    }

}
