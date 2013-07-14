/*
Given the heights and weights of each person in the circus, write a method to compute the largest possible number of people
in such a tower.
*/

import java.lang.System;
import java.util.ArrayList;

//remember: longest increasing subsequence's trick--
//from the beginning find the longest ascending array ended with one ele until the very end, so that we do recursive
//the last ele of previous linked list < the last ele, and find the longest of previous lists

public class cracking11_7 {
    //merge sort recite
    public static void merge(pair[] array,pair[] record,int start,int mid,int end) {
        for(int i = start;i<=end;i++) {      //only this in the wrong pos
            record[i] = array[i];
        }
        int i = start;
        int j = mid+1;
        int current = start;
        while(i<=mid && j<=end) {
            if(record[i].height < record[j].height)
                array[current++] = record[i++];
            else
                array[current++] = record[j++];
        }
        while(i<=mid) {
            array[current++] = record[i++];
        }
    }

    public static void mergeSort(pair[] array,pair[] record,int start,int end){
        if(start >= end)
            return;
        int mid = (start+end)/2;

        mergeSort(array, record, start, mid);
        mergeSort(array, record, mid+1, end);

        merge(array, record, start, mid, end);
    }

    public static void sort(pair[] array) {
        pair[] record = new pair[array.length];
        mergeSort(array,record,0,array.length-1);
    }

    //main part2 helper
    //use ArrayList<pair>[] and pass another index argument
    public static ArrayList<pair> findLongestHelp(ArrayList<ArrayList<pair>> array) {
        ArrayList<pair> max = new ArrayList<pair>();
        int length = 0;
        for(ArrayList<pair> p:array) {
            if(p.size()>length) {
                length = p.size();
                max = p;
            }
        }
        return max;
    }

    //main part2
    public static void findLongest(pair[] array,ArrayList<ArrayList<pair>> record) {
        if(record.size() <= array.length) {
            int maxLength = 0;
            ArrayList<pair> maxArray = new ArrayList<pair>();

            for(int i = 0;i<record.size();i++) {
                ArrayList<pair> in = record.get(i);
                if(array[record.size()-1].weight > in.get(in.size()-1).weight && in.size() > maxLength) {
                    maxLength = in.size();
                    maxArray = in;
                }
            }         //this is the trick: find longest ended with one ele

            maxArray.add(array[record.size()-1]);
            record.add(maxArray);

            findLongest(array, record);   //recursion
        }
    }

    //main part1
    public static void sortByHeight(pair[] array) {
        sort(array);
    }

    //main function
    public static ArrayList<pair> findLargestTower(pair[] array) {
        sortByHeight(array);

        System.out.println("First Sort:");
        printPairArray(array);

        ArrayList<ArrayList<pair>> record = new ArrayList<ArrayList<pair>>();
        ArrayList<pair> tmp = new ArrayList<pair>();
        tmp.add(array[0]);
        record.add(tmp);

        findLongest(array,record);

        return findLongestHelp(record);
    }

    public static class pair {
        int height;
        int weight;
        public pair(int h,int w) {
            height = h;
            weight = w;
        }
    }

    public static void printPairArray(pair[] array) {
        for(pair p : array) {
            System.out.println(p.height + "," + p.weight);
        }
    }

    public static void printPairArrayList(ArrayList<pair> array) {
        for(pair p : array) {
            System.out.println(p.height + "," + p.weight);
        }
    }

    public static void main(String[] args) {
        pair[] array = new pair[10];
        array[0] = new pair(9,20);
        array[1] = new pair(8,17);
        array[2] = new pair(7,13);
        array[3] = new pair(6,11);
        array[4] = new pair(5,2);
        array[5] = new pair(4,5);
        array[6] = new pair(3,8);
        array[7] = new pair(2,7);
        array[8] = new pair(1,6);
        array[9] = new pair(0,10);

        ArrayList<pair> result = findLargestTower(array);
        System.out.println("Result:");
        printPairArrayList(result);
    }
}
