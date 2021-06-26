package org.yash.data.structure;

import java.util.Arrays;

public class HashTable<K, V> {

    private int initialCapacity = 2;

    private int size = 0;

    private final int threshold;

    private Entry<?, ?>[] table = null;


    public HashTable() {
        table = new Entry[initialCapacity];
        threshold = (int) Math.min(initialCapacity * .75f, Integer.MAX_VALUE);
    }


    public synchronized void add(K key, V value) {
        int hashCode = key.hashCode();

        int index = hashCode % initialCapacity;

        if (threshold <= size) {
            rehash();
        }

        if (table[index] == null) {
            table[index] = new Entry(key, value);
            size++;
        }
    }

    private void rehash() {

        Entry<?, ?>[] newTable = new Entry[initialCapacity += initialCapacity];

        Arrays.stream(table).forEach(entry -> {
            if (entry != null) {
                int hashCode = entry.key.hashCode();
                int index = hashCode % initialCapacity;
                newTable[index] = entry;
            }

        });

        table = newTable;
    }

    public synchronized V  get(K key) {
        int hashCode = key.hashCode();
        int index = hashCode % initialCapacity;


        return (V) table[index].value;

    }


    private static class Entry<T, V> {
        T key;
        V value;

        public Entry(T key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }
}
