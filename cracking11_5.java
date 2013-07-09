/*
Given a sorted array of strings which is interspersed with empty strings, write a method to find the location of a given string.
*/

public class cracking11_5 {
    public static int findStringHelp(String str,String[] array,int start,int end) {
        if(start > end)
            return -1;
        int mid = (start+end)/2;

        if(array[mid].isEmpty()) {
            int left = mid-1;
            int right = mid+1;
            while(true) {
                if(left<start && right > end)
                    return -1;
                else if(left>=start && !array[left].isEmpty()) {
                    mid = left;
                    break;
                } else if(right<=end && !array[right].isEmpty()) {
                    mid = right;
                    break;
                } else{
                    left --;
                    right ++;
                }
            }
            if(str.equals(array[mid]))
                return mid;
            if(array[mid].compareTo(str)<0) {
                return findStringHelp(str,array,mid+1,end);
            } else {
                return findStringHelp(str,array,start,mid-1);
            }
        }
    }

    public static int findString(String str,String[] array) {
        if(array == null || str == null || str=="")
            return -1;
        return findStringHelp(str,array,0,array.length-1);
    }
}