package com.kamatama41.effectivejava;

import java.util.Comparator;
import java.util.function.Supplier;

import static java.util.Comparator.comparingInt;

public class PhoneNumber implements Cloneable, Comparable<PhoneNumber> {
    private final short areaCode, prefix, lineNum;
    private static final Comparator<PhoneNumber> COMPARATOR = comparingInt((PhoneNumber pn) -> pn.areaCode)
            .thenComparingInt(pn -> pn.prefix)
            .thenComparingInt(pn -> pn.lineNum);

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    @Override
    public PhoneNumber clone() {
        try {
            return (PhoneNumber) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public static PhoneNumber getInstance() {
        return new PhoneNumber((short)1 ,(short)2, (short)3);
    }

    @Override
    public String toString() {
        return String.format("%03d-%03d-%04d", areaCode, prefix, lineNum);
    }

    @Override
    public int compareTo(PhoneNumber o) {
        return COMPARATOR.compare(this, o);
    }

    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber((short)1 ,(short)2, (short)3);
        System.out.println(phoneNumber);
        PhoneNumber clone = phoneNumber.clone();
        System.out.println(clone);

        Supplier<PhoneNumber> s = PhoneNumber::getInstance;
    }
}
