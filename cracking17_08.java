/*
You are given an array of integers (both positive and negative). Find the contiguous sequence with the largest sum. Return
the sum.
*/

import java.lang.Integer;
import java.lang.System;

public class cracking17_8 {
    public static int[] array = {2,3,-1,-1,2,8,4,-2,3};

    public static int book(int[] a) {
        int max = 0;
        int sum = 0;
        for(int i = 0;i<a.length;i++) {
            sum+=a[i];
            if(max<sum)
                max = sum;      //fine, max is a record of highest, nothing else needed
            else if(sum<0)
                sum = 0;
        }
        return max;
    }

    public static int findMaxSum(int index) {
        int sum = Integer.MIN_VALUE;
        int tmpSum = array[index++];
        while(index<array.length) {
            tmpSum += array[index];
            if(sum<tmpSum)
                sum = tmpSum;
            index++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int max = Integer.MIN_VALUE;
        for(int i = 0;i<array.length;i++) {
            if(array[i]>0 && (i==0|| array[i-1]<=0 )) {
                int result= findMaxSum(i);
                if(result>max){
                    max = result;
                }
            }
        }
        System.out.println("The maximum sum is: "+max);
        System.out.println("The book is: "+book(array));
    }
}
