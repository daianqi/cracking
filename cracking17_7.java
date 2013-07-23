/*
Given any integer, print an English phrase that describes the integer (e.g., "One Thousand, Two Hundred Thirty Four").
*/

import java.lang.System;

public class cracking17_7 {
    public static String[] digits = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    public static String[] teens = {"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    public static String[] tens = {"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public static String[] bigs = {"","Thousand","Million","Billion"}; //no need for billion

    public static String convert(int num) {
        int twoLow = num%100;
        int oneHigh = num/100;
        String str = "";
        if(num == 0)
            return str;
        if(twoLow == 0) {
            str += digits[oneHigh-1]+" " + "Hundred";  //-1 bug
            return str;
        }
        else if(twoLow%10 == 0)
            str += tens[twoLow/10 - 1];
        else if(twoLow<20 && twoLow>10)
            str += teens[twoLow%10 - 1];
        else {
            str += tens[twoLow/10 - 1] + " "+ digits[twoLow%10 - 1];
        }

        if(oneHigh == 0)
            return str;
        else {
            str = digits[oneHigh-1]+" " + "Hundred" + " " + str;
            return str;
        }
    }

    public static String callNum(int num) {
        if(num == 0)
            return "Zero";
        if(num < 0)
            return callNum(-1*num);
        String str = "";
        int count = 0;
        while(num>0) {
            if(num%1000 != 0) {
                str = convert(num % 1000) +" "+bigs[count] + " " + str;
                count ++;
            }
            num /= 1000;
        }
        return str;
    }

    public static void main(String[] args) {
        int num = 919323984;
        System.out.println(callNum(num));
    }
}