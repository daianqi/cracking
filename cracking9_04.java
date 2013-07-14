/*
Write a method to return all subsets of a set.
*/

import java.lang.Integer;
import java.lang.System;
import java.util.ArrayList;
import java.util.Set;

public class cracking9_04 {
    
    public static void print(ArrayList<ArrayList<Integer>> output) {
        for(ArrayList<Integer> array : output) {
            printhelper(array);
        }
    }

    public static void printhelper(ArrayList<Integer> output) {
        for(Integer i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static ArrayList<ArrayList<Integer>> printAllSubset(ArrayList<Integer> array, int index) {
        ArrayList<ArrayList<Integer>> newOutput;
        if(index == array.size()) {
            newOutput = new ArrayList<ArrayList<Integer>>();

            newOutput.add(new ArrayList<Integer>());
        }
        else {
            ArrayList<ArrayList<Integer>> lastOutput = printAllSubset(array,index+1);
            newOutput = new ArrayList<ArrayList<Integer>>();
            newOutput.addAll(lastOutput);
            for(ArrayList<Integer> current : lastOutput) {
                ArrayList<Integer> newArray = new ArrayList<Integer>();
                newArray.addAll(current);       //bug
                newArray.add(array.get(index));
                newOutput.add(newArray);
            }

        }
        return newOutput;
    }

    public static ArrayList<Integer> convertIntegerToSubset(int k, ArrayList<Integer> array) {
        int i = 0;
        ArrayList<Integer> output = new ArrayList<Integer>();
        while(k > 0 && i < array.size()) {
            if(k%2 == 1) {
                output.add(array.get(i));
            }
            k /= 2;
            i++;
        }
        return output;
    }

    public static ArrayList<ArrayList<Integer>> binary(ArrayList<Integer> array) {
        int size = array.size();
        int k = 1 << size;
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        for(int i = 0;i<k;i++) {
            ArrayList<Integer> newArray = convertIntegerToSubset(i,array);
            output.add(newArray);
        }
        return output;
    }

    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);

        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        output = printAllSubset(array,0);
        print(output);

        ArrayList<ArrayList<Integer>> output2 = new ArrayList<ArrayList<Integer>>();
        output2 = binary(array);
        print(output2);



    }
}
