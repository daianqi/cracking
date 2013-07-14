/*
Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search tree with
minimal height.
*/

import java.lang.Integer;
import java.lang.System;
import java.util.ArrayList;
import java.util.LinkedList;

public class cracking4_3 {
    public static TreeNode generateTree(int start, int end, int[] array) {
        TreeNode n = new TreeNode();
        if(start>end) {       //stupid bug is here when the total number of elements are even
            return null;
        }
//        else if(start == end) {   //stupid: can get rid of this
//            n.value = array[start];
//            n.left = null;
//            n.right = null;
//        }
        else {
            n.value = array[(int)((start+end)/2)];
            n.left = generateTree(start,(int)((start+end)/2)-1, array);
            n.right = generateTree((int)((start+end)/2)+1, end, array);
        }
        return n;
    }

    public static void showTree(TreeNode n) {
        LinkedList<TreeNode> stackold = new LinkedList<TreeNode>();
        LinkedList<TreeNode> stacknew = new LinkedList<TreeNode>();
        stackold.add(n);
        while(!stackold.isEmpty()) {
            TreeNode tmpNode = stackold.removeFirst();
            if(tmpNode == null)
                System.out.print("null ");
            else {
                stacknew.add(tmpNode.left);
                stacknew.add(tmpNode.right);
                System.out.print(tmpNode.value + " ");

                if(stackold.isEmpty()) {
                    System.out.println();
                    if(stacknew.isEmpty())
                        break;
                    else {
                        LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
                        stackold = stacknew;
                        stacknew = tmp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        TreeNode n = generateTree(0,9,array);
        showTree(n);
    }

}

