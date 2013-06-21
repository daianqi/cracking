/*
Design an algorithm to find the kth number such that the only prime factors are 3, 5 and 7.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Math;
import java.lang.System;
import java.util.LinkedList;
import java.util.Queue;

public class cracking7_7 {
    //primes3: 3*1, 3*3...
    //primes5: 5*1, 5*3, 5*5...
    //primes7: 7*1, 7*3, 7*5, 7*7...
    public static void printKthPrime(int k) {
        Queue<Integer> primes3 = new LinkedList<Integer>();
        Queue<Integer> primes5 = new LinkedList<Integer>();
        Queue<Integer> primes7 = new LinkedList<Integer>();

        int count = 0;
        int current = 1;
        primes3.add(current);
        while(count < k) {
            int v3 = primes3.size() > 0? primes3.peek():Integer.MAX_VALUE;
            int v5 = primes5.size() > 0? primes5.peek():Integer.MAX_VALUE;
            int v7 = primes7.size() > 0? primes7.peek():Integer.MAX_VALUE;

            current = Math.min(v3, Math.min(v5,v7));

            if(current == v3) {
                primes3.remove();
                primes3.add(current*3);
                primes5.add(current*5);
            } else if(current == v5) {
                primes5.remove();
                primes5.add(current*5);
            } else {
                primes7.remove();
            }
            primes7.add(current*7);

            count ++;
        }
        System.out.println(current);

    }

    public static int getSmallest(Queue<Integer> queue) {
        int min = Integer.MAX_VALUE;
        for(Integer i : queue) {
            if(i<min) {
                min = i;
            }
        }
        while(queue.contains(min)) {
            queue.remove(min); //delete duplicate
        }
        return min;
    }

    public static void addPrime(Queue<Integer> queue, int current) {
        queue.add(current * 3);
        queue.add(current * 5);
        queue.add(current * 7);
    }

    public static void stupidPrintKthPrime(int k) {
        Queue<Integer> primes = new LinkedList<Integer>();
        int count = 1;
        int current = 1;
        addPrime(primes,current);
        while(count < k) {
            current = getSmallest(primes);
            addPrime(primes, current);
            count ++;
        }
        System.out.println(current);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader readBuffer = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(readBuffer.readLine());

        stupidPrintKthPrime(k);
        printKthPrime(k);
    }
}