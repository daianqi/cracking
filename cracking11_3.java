/*
Given a sorted array of n integers that has been rotated an unknown number of times, write code to find an element in the array. You may assume that the array was originally sorted in increasing order.
*/

import java.lang.Integer;
import java.lang.System;

public class cracking11_3 {
    public static int bookHelp(int x,Integer[] a,int left, int right) {
        int mid = (left + right)/2;
        if(x==a[mid])
            return mid;
        if(left>right)
            return -1;

        if(a[left]<a[mid]) {
            if(x>=a[left]&&x<=a[mid])
                return bookHelp(x,a,left,mid-1);
            else
                return bookHelp(x,a,mid+1,right);
        } else if(a[mid]<a[right]) {
            if(x>=a[mid]&&x<=a[right])
                return bookHelp(x,a,mid+1,right);
            else
                return bookHelp(x,a,left,mid-1);
        } else if(a[left]==a[mid]) {
            if(a[mid]!=a[right])
                return bookHelp(x,a,mid+1,right);
            else{
                int result=bookHelp(x,a,left,mid-1);
                if(result == -1)
                    return bookHelp(x,a,mid+1,right);
                else
                    return result;
            }
        }
        return -1;
    }

    public static int findEleHelp(int ele, Integer[] array,int start,int end) {
        int mid = (start+end)/2;
        if(ele == array[mid])
            return mid;
        else if(start>=end)
            return -1;
        else {
            if(ele < array[mid]) {
                if(ele == array[start]) {
                    return start;
                }
                if(array[start] < array[mid]) {
                    if(ele<array[start]) {
                        System.out.println("right1");
                        return findEleHelp(ele,array,mid+1,end);
                    }
                    else {
                        System.out.println("left1");
                        return findEleHelp(ele, array, start, mid-1);
                    }
                } else {
                    System.out.println("left2");
                    return findEleHelp(ele, array, start, mid);  //bug
                }
            } else {
                if(ele == array[end]) {
                    return end;
                }
                if(array[mid] < array[end]) {
                    if(ele < array[end]) {
                        System.out.println("right2");
                        return findEleHelp(ele, array, mid+1, end);
                    } else {
                        System.out.println("left3");
                        return findEleHelp(ele,array,start,mid-1);
                    }
                } else {
                    System.out.println("left4");
                    return findEleHelp(ele, array, start, mid);
                }
            }
        }
    }

    public static int findEle(int ele,Integer[] array) {
//        return findEleHelp(ele,array,0,array.length-1);
        return bookHelp(ele,array,0,array.length-1);
    }

    public static void main(String[] args) {
        Integer[] array1 = new Integer[10];
        array1[0] = 14;
        array1[1] = 15;
        array1[2] = 20;
        array1[3] = 0;
        array1[4] = 1;
        array1[5] = 2;
        array1[6] = 4;
        array1[7] = 5;
        array1[8] = 10;
        array1[9] = 12;

        Integer[] array2 = new Integer[6];
        array2[0] = 2;
        array2[1] = 2;
        array2[2] = 2;
        array2[3] = 3;
        array2[4] = 4;
        array2[5] = 2;

        System.out.println("5 position in array1" + " " + findEle(5,array1) );
        System.out.println("4 position in array2" + " " + findEle(4,array2) );
    }
}