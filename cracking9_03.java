/*
A magic index in an array A[1..n-1] is defined to be an index such that A[i] = i. given a sorted array of distinct integers,
write a method to find a magic index, if one exists, in array A.
FOLLOW UP
What if the values are not distinct?
*/

import java.lang.Math;
import java.lang.System;

public class cracking9_03 {
    public static int findMagicIndex(int[] array,int min,int max) {
        if(min >= max)
            return -1;
        int mid = (min+max)/2;
        if(array[mid] == mid)
            return mid;
        else if(array[mid] < mid)
            return findMagicIndex(array,mid+1,max);
        else
            return findMagicIndex(array,min,mid-1);
    }

    //follow up if not distinct: not equal go right + go left  //stupid mind not focused
    //go left: start-(min(mid-1, array[mid]))
    //go right: max(mid+1, array[mid])-end

    public static int findMagicIndexNotDistinct(int[] array,int min,int max) {
        if(min >= max)
            return -1;
        int mid = (min+max)/2;
        if(array[mid] == mid)
            return mid;
        int left = findMagicIndexNotDistinct(array,min,Math.min(mid-1,array[mid]));
        if(left >= 0) return left;
        int right = findMagicIndexNotDistinct(array, Math.max(mid+1,array[mid]),max);
        return right;
    }

    public static void main(String[] arg) {
        int[] array = new int[10];
        array[0] = -40;
        array[1] = -20;
        array[2] = -1;
        array[3] = 1;
        array[4] = 2;
        array[5] = 3;
        array[6] = 5;
        array[7] = 7;
        array[8] = 9;
        array[9] = 12;

        System.out.println("Magic index: "+ findMagicIndex(array,0,array.length-1));

        int[] array2 = new int[10];
        array2[0] = -10;
        array2[1] = -5;
        array2[2] = 2;
        array2[3] = 3;
        array2[4] = 3;
        array2[5] = 3;
        array2[6] = 4;
        array2[7] = 7;
        array2[8] = 9;
        array2[9] = 12;

        System.out.println("Magic index: "+ findMagicIndexNotDistinct(array2,0,array2.length-1));

    }
}