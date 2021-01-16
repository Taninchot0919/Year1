package IteraBleTor;

import java.util.Iterator;

public class IBle implements Iterable<Contact> { //ใช้Iterableซึ่งในIterableมีIterator

    private Contact[] friends;
    private int count;

    public Iterator<Contact> iterator() {
        return new Iterator<Contact>() {
            private int index;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public Contact next() {
                if (index == count) {
                    System.out.println("No More Contact.");
                }

                return friends[index++];
            }

        };
    }

    public class Itle implements Iterator<Contact> { //ใช้Iteratorเลย

        private int index;

        @Override
        public boolean hasNext() {
            return index < count;
        }

        @Override
        public Contact next() {
            if (index == count) {
                System.out.println("No More Contact.");
            }

            return friends[index++];
        }

    };
}
