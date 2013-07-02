/*
Merge Sort
*/

import java.lang.Math;
import java.lang.System;

public class cracking11_0_merge {
    public static void merge(int[] array, int[] help, int start, int mid, int end) {
        for(int i = start;i<=end;i++) {
            help[i] = array[i];
        }
        int helpLeft = start;
        int helpRight = mid+1;
        int i = start;
        while(helpLeft <= mid && helpRight <= end) {
            if(help[helpLeft] > help[helpRight]) {
                array[i++] = help[helpRight++];
            } else {
                array[i++] = help[helpLeft++];
            }
        }
        while(helpLeft<=mid) {
            array[i++] = help[helpLeft++];
        }
    }

    public static void mergeSortHelper(int[] array, int[] help, int start, int end) {

        if(start < end) {
            int mid = (start + end)/2;
            mergeSortHelper(array, help, start, mid);
            mergeSortHelper(array,help, mid+1, end);
            merge(array,help,start,mid,end);
        }
    }

    public static void mergeSort(int[] array) {
        int[] help = new int[array.length];
        mergeSortHelper(array,help,0,array.length-1);
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

        mergeSort(array);

        printArray(array);
    }
}