/*
Print all prime number until N. The Sieve of Eratosthenes.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.Exception;
import java.lang.Integer;
import java.lang.Math;
import java.lang.System;

public class cracking7_0 {
    
    public static boolean[] crossOut(int prime, boolean[] flags) {
        for(int i = prime*prime;i<flags.length;i+=prime) {   //stupid mind doesn't know prime^2
            flags[i] = false;
        }
        return flags;
    }

    public static int getNextPrime(int prime, boolean[] flags) {
        int i = prime + 1;     //stupid mind doesn't know + 1
        while(i < flags.length && flags[i] == false){
            i++;
        }
        return i;
    }

    public static void init(boolean[] flags) {
        for(int i = 0; i < flags.length; i++) {
            flags[i] = true;
        }
    }

    public static void printBooleanArray(boolean[] array) {
        for(int i = 2; i < array.length;i++) {
            if(array[i] == true)
                System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void printAllPrime(int N) {
        boolean[] flags = new boolean[N+1];
        init(flags);

        int prime = 2;
        while(prime <= Math.sqrt(N)) {
            crossOut(prime, flags);
            prime = getNextPrime(prime,flags);

            if(prime >= flags.length)
                break;  //stupid mind doesn't know this
        }
        printBooleanArray(flags);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader readBuffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(readBuffer.readLine());
        if(N < 2)
            return;

        printAllPrime(N);
    }
}
