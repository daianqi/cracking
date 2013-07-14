/*
Write methods to implement the multiply, substract, and divide operations for integers. Use only the add operator.
*/

import java.lang.ArithmeticException;
import java.lang.System;

public class cracking7_4 {
    
    public static int negate(int a) {
        int d = (a>0)? -1 : 1;
        int neg = 0;
        while(a!=0) {
            neg += d;
            a += d;
        }
        return neg;
    }

    public static int substract(int a, int b) {
        return a + negate(b);
    }

    public static int abs(int a) {
        if(a < 0)
            a = negate(a);
        return a;
    }

    public static int multiply(int a, int b) {
        if(a > b)
            return multiply(b,a);
        int sum = 0;
        for(int i = 0;i< abs(b);i++) {
            sum += a;
        }
        if(b < 0)
            sum = negate(sum);
        return sum;
    }

    public static int divide(int a, int b) throws ArithmeticException{
        if(b == 0)
            throw new ArithmeticException("ERROR");
        int absa = abs(a);
        int absb = abs(b);
        int product = 0;
        int x = 0;
        while(product + absb <= absa) {
            product += absb;
            x ++;
        }
        if((a<0&&b>0)||(a>0&&b<0))
            x = negate(x);
        return x;
    }

    public static void main(String[] args) {
        System.out.println("1-9= " + substract(1,9));
        System.out.println("2*9= " + multiply(2,9));
        System.out.println("9/3= " + divide(9,3));
    }
}
