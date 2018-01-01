package com.kamatama41.effectivejava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Generics {

    public static void main(String[] args) {
        List l1 = test1(1, "a");
        l1.add(3f);
        System.out.println(l1);
        List<?> l2 = test2(1, "a");
        // l2.add(3f); Error
        System.out.println(l2);
    }

    static List test1(Object... objects) {
        return Arrays.stream(objects).collect(Collectors.toList());
    }

    static List<?> test2(Object... objects) {
        return Arrays.stream(objects).collect(Collectors.toList());
    }
}
