/*
Given an infinite number of quarters(25 cents), dimes(10 cents), nickles(5 cents), pennies(1 cent), write code to calculate
the number of ways of representing n cents.
*/

import java.lang.Integer;
import java.lang.System;

public class cracking9_08 {
    public static int book(int n, int denom) {
        int next_denom = 0;
        switch (denom) {
            case 25:
                next_denom = 10;
                break;
            case 10:
                next_denom = 5;
                break;
            case 5:
                next_denom = 1;
                break;
            case 1:
                return 1;
        }
        int ways = 0;
        for(int i = 0;i*denom <= n;i++) {
            ways += book(n-i*denom, next_denom);   //this is genuis
        }
        return ways;
    }

    public static int countAllways(int money, int lastTime) {
        if(money == 0)
            return 1;
        if(money >= 25) {
            if(lastTime >= 25) {
                return countAllways(money-25, 25) + countAllways(money-10, 10) + countAllways(money-5, 5) + countAllways(money-1, 1);
            } else if(lastTime >=10) {
                return countAllways(money-10, 10) + countAllways(money-5, 5) + countAllways(money-1, 1);
            } else if(lastTime >=5) {
                return countAllways(money-5, 5) + countAllways(money-1, 1);
            } else {
                return countAllways(money-1, 1);
            }
        } else if(money >= 10) {
            if(lastTime >= 10) {
                return countAllways(money-10, 10) + countAllways(money-5, 5) + countAllways(money-1, 1);
            } else if(lastTime >= 5) {
                return countAllways(money-5, 5) + countAllways(money-1, 1);
            } else {
                return countAllways(money-1, 1);
            }
        } else if(money >= 5) {
            if(lastTime >=5) {
                return countAllways(money-5, 5) + countAllways(money-1, 1);
            } else {
                return countAllways(money-1, 1);
            }
        } else {
            return countAllways(money-1, 1);
        }
    }

    public static void main(String[] args) {
        int money = 100;
        int count = countAllways(money, Integer.MAX_VALUE);
        System.out.println(count);
        int count2 = book(money, 25);
        System.out.println(count2);
    }
}