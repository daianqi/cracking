/*
An array A contains all the integers from 0 through n, except fot one number which is missing. In this problem, we cannot
access an entire integer in A with a single operation. The elements of A are reresented in binary, and the only operation
we can use to access them is "fetch the jth bit of A[i]", which takes constant time. Write code to find the missing integer.
Can you do it in O(n) time?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.lang.Integer;
import java.util.ArrayList;

public class cracking5_7 {

    public static int findMissing (ArrayList<BitInteger> array) {
        return findMissingHelper(array,0);
    }

    //super tricky: count(0s) <= count(1s), then lowest bit 0; count(0s) > count(1s), then lowest bit 1
    //stupid mind cant recursion
    public static int findMissingHelper (ArrayList<BitInteger> array, int column) {
        if(column >= BitInteger.INTEGER_SIZE) return 0;

        ArrayList<BitInteger> array0 = new ArrayList<BitInteger>(array.size()/2);
        ArrayList<BitInteger> array1 = new ArrayList<BitInteger>(array.size()/2);

        for(BitInteger t : array) {
            if(t.fetch(column) == 0)
                array0.add(t);
            else
                array1.add(t);
        }

        if(array0.size() <= array1.size()) {
            int v = findMissing(array0, column+1);
            return (v<<1) | 0;
        } else {
            int v = findMissing(array1, column+1);
            return (v<<1) | 1;
        }
    }

    public static void main(String[] args) throws Exception{
    }
}