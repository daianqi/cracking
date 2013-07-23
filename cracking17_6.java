/*
Given an array of integers, write a method to find indics m and n such that if you sorted elements m through n, the entire
array would be sorted. Minimize n - m (that is, find the smallest such sequence).
*/

import java.lang.System;

public class cracking17_6 {
    public static void findIndics(int[] array) {
        int start = 0;
        int end = array.length-1;
        while(start<array.length-1) {
            if(array[start]>=array[start+1]){
                start++;
                break;
            }
            start++;
        }
        if(start == array.length-1) {
            System.out.println("Sorted");
            return;
        }
        while(end>0) {
            if(array[end] < array[end-1]){
                end--;
                break;
            }
            end--;
        }

        int min_index = start;
        int max_index = end;

        int origStart = array[start-1];
        int origEnd = array[end+1];

        //find min and max element of middle
        for(int i=start;i<=end;i++) {
            if(array[i]<array[min_index]) min_index = i;
            if(array[i]>array[max_index]) max_index = i;
        }

        int leftCom = array[min_index];
        for(int i = start-1;i>=0;i--) {
            if(array[i]<leftCom) {
                start = i+1;
                break;
            }
        }

        int rightCom = array[max_index];
        for(int i = end+1;i>=0;i++) {
            if(array[i]>rightCom) {
                end = i-1;
                break;
            }
        }

        //minimum of right < left ridge
        //maximum of left > right ridge
        for(int i = end;i<array.length;i++) {
            if(array[i]>origStart) {
                end = (end > i)?end:i;
                break;
            }
            if(i==array.length-1)
                end = array.length-1;
        }

        for(int i = start;i>=0;i--) {
            if(array[i]<origEnd) {
                start = (start<i)?start:i;
                break;
            }
            if(i==0)
                start = 0;
        }

        System.out.println("The start indics "+start+", the end indics "+end);

    }

    public static void main(String[] args) {
        int[] array = {1,2,4,7,10, 20,7,3,17,0, 5,16,18,19};
        findIndics(array);
        int[] array1 = {1,2,3,4,5, 2,15,8,7,9, 10,11,19};
        findIndics(array1);
    }
}