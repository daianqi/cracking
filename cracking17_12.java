/*
Design an algorithm to find all pairs of integers within an array which sum to a specified value.
*/

import java.lang.Integer;
import java.lang.System;
import java.util.Hashtable;

public class cracking17_12 {
    public static void bookSorted(int[] array,int value){
        int start = 0;
        int end = array.length-1;
        while(start<end) {
            if(array[start]+array[end]==value) {
                System.out.println(array[start] + "+" + array[end]);
                start++;     //option
                end--;
            } else if(array[start]+array[end]<value) {
                start++;
            } else {
                end--;
            }
        }
    }

    public static void findAllPairs(int[] array, int value) {
        Hashtable<Integer,Integer> table = new Hashtable<Integer, Integer>();
        for(int i = 0;i<array.length;i++) {
            if(table.containsKey(array[i])) {
                System.out.println(array[i] + "+" + table.get(array[i]));
            } else {
                table.put(value - array[i],array[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {-2,-1,0,3,5,6,7,9,13,14};
        int value = 12;
        findAllPairs(array, value);
        System.out.println("---------");
        bookSorted(array,value);
    }
}