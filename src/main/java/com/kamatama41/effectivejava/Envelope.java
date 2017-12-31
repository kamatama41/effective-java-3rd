package com.kamatama41.effectivejava;

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
        }
    }


    public static void main(String[] args) {
        Enclosure enclosure = new Envelope().new Enclosure();
        enclosure.hello();
    }
}
