package com.kamatama41.effectivejava;

import java.util.HashMap;
import java.util.Map;

public class MethodReferenceExample {
    private static Map<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(test2(1));
        System.out.println(test2(1));
        System.out.println(test2(1));
        System.out.println(test2(1));
        System.out.println(test2(1));
        System.out.println(test2(1));
    }

    private static int test(int key) {
        return map.merge(key, 1, (count, incr) -> count + incr);
    }

    private static int test2(int key) {
        return map.merge(key, 1, Integer::sum);
    }
}
