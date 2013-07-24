/*
For example, if the actual solution is RGBY and you guess GGRR, you have one hit and one pseudo-hit. Write a method that,
given a guess and a solution, returns the number of hits and pseudo-hits.
*/

import java.lang.System;

public class cracking17_5 {
    public static class Result {
        int hits = 0;
        int pseudo_hits = 0;

        public String toString() {
            return "(" + hits + "," + pseudo_hits + ")";
        }
    }

    public static int encode(char c) {
        switch (c) {
            case 'B':
                return 0;
            case 'G':
                return 1;
            case 'R':
                return 2;
            case 'Y':
                return 3;
            default:
                return -1;
        }
    }

    public static int MAX_COLORS = 4;

    public static Result estimate(String solution,String guess) {
        if(guess.length() != solution.length())
            return null;
        Result res = new Result();
        int[] frequencies = new int[MAX_COLORS];

        for(int i = 0;i<guess.length();i++) {
            if(guess.charAt(i) == solution.charAt(i)){
                res.hits++;
            } else {
                int code = encode(guess.charAt(i));
                frequencies[code]++;
            }
        }

        for(int i = 0;i<guess.length();i++) {
            int code = encode(guess.charAt(i));
            if(code >= 0 && frequencies[code]>0 && guess.charAt(i) != solution.charAt(i)) {
                res.pseudo_hits++;
                frequencies[code]--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String solution = "RGBY";
        String guess = "GGRR";
        System.out.println(estimate(solution, guess).toString());
    }
}
