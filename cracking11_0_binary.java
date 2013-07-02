/*
Binary Search
*/

import java.lang.Math;
import java.lang.System;

public class cracking11_0_binary {
    public static int binarySearchRecursion(int value, int[] array, int start, int end) {
        if(start <= end) {
            int mid = (start+end)/2;
            if(value > array[mid]) {
                return binarySearchRecursion(value, array, mid+1, end);
            } else if(value < array[mid]){
                return binarySearchRecursion(value, array, start, mid-1);
            } else {
                return mid;
            }
        } else {
            return -1;
        }
    }

    public static int binarySearch(int value, int[] array) {
        int start = 0;
        int end = array.length-1;
        while(start<=end) {              //one bug <=
            int mid = (start+end)/2;
            if(value > array[mid]) {
                start = mid+1;
            } else if(value < array[mid]){
                end = mid - 1;
            } else
                return mid;
        }
        return -1;
    }

    public static void printArray(int[] array) {
        for(int i = 0;i<array.length;i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        array[0] = 2;
        array[1] = 5;
        array[2] = 8;
        array[3] = 12;
        array[4] = 15;
        array[5] = 16;
        array[6] = 21;
        array[7] = 22;
        array[8] = 23;
        array[9] = 25;

        printArray(array);

        System.out.println(binarySearch(25,array));
        System.out.println(binarySearchRecursion(25,array,0,array.length-1));

    }
}