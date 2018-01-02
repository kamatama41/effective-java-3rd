package com.kamatama41.effectivejava;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Generics {

    public static void main(String[] args) {
        List l1 = test1(1, "a");
        l1.add(3f);
        System.out.println(l1);
        List<?> l2 = test2(1, "a");
        // l2.add(3f); Error
        System.out.println(l2);

        /**
         * Test for bounded wildcards
         */
        List<MyNumber> numbers = Arrays.asList(new MyNumber("1"), new MyNumber("1.5"), new MyNumber("2"));
        MyNumber max = max(numbers);
        System.out.println(max);
    }

    static List test1(Object... objects) {
        return Arrays.stream(objects).collect(Collectors.toList());
    }

    static List<?> test2(Object... objects) {
        return Arrays.stream(objects).collect(Collectors.toList());
    }

    static <E extends Comparable<? super E>> E max(Collection<? extends E> c) {
        E result = null;
        for (E e : c) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }
        return result;
    }

    static class MyNumber extends BigDecimal {
        public MyNumber(String val) {
            super(val);
        }
    }
}
