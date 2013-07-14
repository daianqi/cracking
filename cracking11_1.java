/*
You are given two sorted arrays, A and B, where A has a large enough buffer at the end to hold B. Write a method to merge B 
into A in sorted order.
*/

public class cracking11_1 {
    public static void merge(int[] A, int ASize, int[] B, int BSize) {
        int total = ASize + BSize - 1;       //the initialized length
        int ATail = ASize - 1;
        int BTail = BSize - 1;

        while(BTail >= 0 && ATail >= 0) {
            if(A[ATail] > B[BTail]) {
                A[total--] = A[ATail--];
            } else {
                A[total--] = B[BTail--];
            }
        }
        while(BTail >= 0) {
            A[total--] = B[BTail--];
        }
    }

    public static void printArray(int[] array) {
        for(int i = 0;i<array.length;i++) {
            System.out.print(array[i] + ",");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[10];
        int[] B = new int[5];
        A[0] = 1;
        A[1] = 7;
        A[2] = 15;
        B[0] = 2;
        B[1] = 6;
        B[2] = 8;
        B[3] = 9;
        B[4] = 20;

        printArray(A);
        printArray(B);

        merge(A,3,B,5);
        printArray(A);
    }
}
