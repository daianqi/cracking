/*
Design and implement a hash table which uses chaining(linked list) to handle collision.
*/

import java.util.LinkedList;

public class cracking8_10 {
    
    public class Cell<K, V> {
        private K key;
        private V value;
        private Cell(K k, V v) {
            key = k;
            value = v;
        }

        public boolean equivalent(K k) {
            return key.equals(k);
        }

        public boolean equivalent(Cell c) {
            return equivalent(c.getKey());
        }

        public K getKey() {return key;}
        public V getValue() {return value;}
    }

    public class Hash<K, V> {
        private final int MAX_SIZE = 10;
        LinkedList<Cell<K, V>>[] items;

        public Hash() {
            items = (LinkedList<Cell<K, V>>[]) new LinkedList[MAX_SIZE];
        }

        public int hashCodeOfKey(K key) {
            return key.toString().length()%items.length;
        }

        public void put(K key, V value) {
            int x = hashCodeOfKey(key);
            if(items[x] == null) {
                items[x] = new LinkedList<Cell<K, V>>();
            }

            LinkedList<Cell<K, V>> collided = items[x];

            for(Cell<K, V> c : collided) {
                if(c.equivalent(key)) {
                    collided.remove(c);
                    break;
                }
            }
            collided.add(new Cell<K, V>(key,value));
        }

        public V get(K key) {
            int x = hashCodeOfKey(key);
            if(items[x] == null)
                return null;
            LinkedList<Cell<K, V>> collided = items[x];
            for(Cell<K, V> c : collided) {
                if(c.equivalent(key)) {
                    return c.getValue();
                }
            }
            return null;
        }
    }

}
