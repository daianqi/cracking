/*
Write a method to sort an array of strings so that all the anagrams are next to each other.
*/

import java.lang.String;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Comparator;
import java.lang.System;

public class cracking11_2 {
    
    /*********************************hashTable***********************************/
    public static void hashSort(String[] array) {
        HashMap<String, ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();
        for(String s : array) {
            String tmp = sortChars(s);    //sort to be key

            //book's version is better
            if(!hash.containsKey(tmp)) {
                hash.put(tmp,new ArrayList<String>());
            }
            ArrayList<String> ana = hash.get(tmp);
            ana.add(s);
        }

        int i = 0;
        for(String key : hash.keySet()) {       //stupid mind doesn't know this
            ArrayList<String> tmp = hash.get(key);
            for(String t : tmp) {
                array[i++] = t;
            }
        }
    }

    /*********************************book***********************************/
    public static class AnagramComparator implements Comparator<String> {
        public String sortChars(String s) {
            char[] content = s.toCharArray();
            Arrays.sort(content);
            return new String(content);
        }

        public int compare(String s1, String s2) {
            return sortChars(s1).compareTo(sortChars(s1));
        }
    }

    public static void book(String[] array) {
        Arrays.sort(array,new AnagramComparator());
    }

    /*********************************mergeSort***********************************/
    public static String sortChars(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static int compare(String small, String big) {
        return sortChars(small).compareTo(sortChars(big));  //compareTo: -1 smaller than; 0 equal; 1 larger than
//        return small.compareTo(big); //doesn't work
    }

    public static void merge(String[] array, String[] help, int start, int mid, int end) {
        int left = start;
        int right = mid+1;     //mid+1 match
        int current = start;

        for(int i = start;i<=end;i++) {
            help[i] = array[i];
        }

        while(left <= mid && right <= end) {
            if(compare(help[left],help[right]) < 0) {
                array[current++] = help[left++];
            } else {
                array[current++] = help[right++];
            }
        }

        while(left <= mid) {
            array[current++] = help[left++];
        }
    }

    public static void mergeSortHelper(String[] array, String[] help, int start, int end) {
         if(start < end) {
             int mid = (start+end)/2;
             mergeSortHelper(array, help, start, mid);  //mid-1 bug
             mergeSortHelper(array, help, mid+1, end);
             merge(array,help,start,mid,end);  //put inside if condition
         }
    }

    public static void sort(String[] array) {
        String[] help = new String[array.length];
        mergeSortHelper(array,help,0,array.length-1);
    }

    /*********************************main***********************************/

    public static void printArray(String[] array) {
        for(int i = 0;i<array.length;i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String[] array = new String[10];
        array[0] = "acb";
        array[1] = "come";
        array[2] = "dog";
        array[3] = "cba";
        array[4] = "god";
        array[5] = "odg";
        array[6] = "cab";
        array[7] = "me";
        array[8] = "oemc";
        array[9] = "mcoe";

        printArray(array);

//        sort(array);
//        book(array);
        hashSort(array);

        printArray(array);
    }
}

/*
DIFF: LinkedList vs ArrayList
ArrayList is implemented as a resizable array. As more elements are added to ArrayList, its size is increased dynamically.
It's elements can be accessed directly by using the get and set methods, since ArrayList is essentially an array.
LinkedList is implemented as a double linked list. Its performance on add and remove is better than Arraylist, but worse on get and set methods.

DIFF: hashTable vs hashMap
There are several differences between HashMap and Hashtable in Java:
Hashtable is synchronized, whereas HashMap is not. This makes HashMap better for non-threaded applications, as unsynchronized
Objects typically perform better than synchronized ones.
Hashtable does not allow null keys or values. HashMap allows one null key and any number of null values.
One of HashMap's subclasses is LinkedHashMap, so in the event that you'd want predictable iteration order (which is insertion
order by default), you could easily swap out the HashMap for a LinkedHashMap. This wouldn't be as easy if you were using Hashtable.
*/
