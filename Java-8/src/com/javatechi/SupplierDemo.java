package com.javatechi;

import java.util.function.Supplier;

public class SupplierDemo  {

    public static void main(String[] args) {
        Supplier<String> supplier=()->"This is Omkar";

        supplier.get();
    }
}
