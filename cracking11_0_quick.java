/*
Quick Sort
*/

import java.lang.Math;
import java.lang.System;

public class cracking11_0_quick {
    public static int partition(int[] array, int start, int end) {
        int mid = (start+end)/2;
        int pivot = array[mid];

        while(start<=end) {
            while(array[start] < pivot)
                start++;
            while(array[end] > pivot)
                end--;
            if(start <= end) {
                int t = array[end];
                array[end] = array[start];
                array[start] = t;
                start ++;
                end --;
            }
        }
        return start;
    }

    public static void quickSortHelper(int[] array, int start, int end) {
        int index = partition(array, start, end);
        if(start < index -1)    //stupid
            quickSortHelper(array,start,index-1);
        if(index < end)
            quickSortHelper(array,index,end);
    }

    public static void quickSort(int[] array) {
        quickSortHelper(array,0,array.length-1);
    }

    public static void printArray(int[] array) {
        for(int i = 0;i<array.length;i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for(int i = 0;i<array.length;i++) {
            array[i] = (int) (Math.random() * 10);
        }

        printArray(array);

        quickSort(array);

        printArray(array);
    }
}