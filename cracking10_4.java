/*
You have an array with all the numbers from 1 to N, where N is at most 32,000. The array may have duplicate entries and you
do not know what N is. With only 4 kilobytes of memory available, how would you print all duplicate elements in the array?
*/

import java.lang.System;

public class cracking10_4 {
    public static void checkDuplicates(int[] array) {
        BitSet bs = new BitSet(32000);
        for(int i = 0;i<array.length;i++) {
            int num = array[i];
            int num0 = num-1;
            if(bs.get(num0)) {
                System.out.println(num);
            } else {
                bs.set(num0);
            }
        }
    }

    class BitSet {
        int[] bitset;
        public BitSet(int size) {
            bitset = new int[size>>5];  //divide by 32
        }

        public boolean get(int pos) {
            int wordNumber = (pos >> 5);  //divide by 32
            int bitNumber = (pos & 0x1F);   //0001 1111 mod by 32
            return (bitset[wordNumber] |= (1<<bitNumber)) != 0;
        }

        public void set(int pos) {
            int wordNumber = (pos >> 5);
            int bitNumber = (pos & 0x1F);
            bitset[wordNumber] |= (1<<bitNumber);
        }
    }
}
