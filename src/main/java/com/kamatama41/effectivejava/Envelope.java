package com.kamatama41.effectivejava;

import java.util.function.Supplier;

/**
 * Item 24: Favor static member class over nonstatic
 */
public class Envelope {

    public String getName() {
        return "world";
    }

    private class Enclosure {
        void hello () {
            // This "Envelope.this" is called "qualified this"
            System.out.println("Hello, " + Envelope.this.getName());

            // Local class
            class HelloEnclosure {
                private String getClassName() {
                    return this.getClass().toString();
                }
            }
            // class com.kamatama41.effectivejava.Envelope$Enclosure$1HelloEnclosure
            System.out.println(new HelloEnclosure().getClassName());

            // Anonymous class
            Supplier<String> s = new Supplier<String>() {
                @Override
                public String get() {
                    return this.getClass().toString();
                }
            };
            // class com.kamatama41.effectivejava.Envelope$Enclosure$1
            System.out.println(s.get());

            // Lambda
            s = () -> this.getClass().toString();
            // class com.kamatama41.effectivejava.Envelope$Enclosure
            System.out.println(s.get());
        }
    }


    public static void main(String[] args) {
        Enclosure enclosure = new Envelope().new Enclosure();
        enclosure.hello();
    }
}
