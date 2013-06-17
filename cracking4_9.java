/*
You are given a binary tree in which each node contains a value. Design an algorithm to print all paths which sum to a given
value. The path does not need to start or end at the root or a leaf.
*/

import java.lang.Integer;
import java.lang.System;
import java.util.ArrayList;

public class cracking4_9 {
    public static void printAll(TreeNode root, int sum) {
        int tmpSum = 0;
        ArrayList<Integer> printList = new ArrayList<Integer>();
        while(root != null) {
            printList.add(root.value);
            tmpSum += root.value;
            if(tmpSum == sum) {
                for(int i = 0;i<printList.size();i++) {
                    System.out.print(printList.get(i)+"->");
                }
                System.out.println();
            }
            root = root.parent;
        }
    }
    public static void printPath(TreeNode root, int sum) {
        if(root == null)
            return;
        if(root.value == sum)
            System.out.println(root.value);
        else {
            printAll(root,sum);
        }
        printPath(root.left,sum);
        printPath(root.right,sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.addChildWithParent(2, -2);
        root.left.addChildWithParent(1, 3);
        root.right.addChildWithParent(5, 9);
        root.left.left.addChildWithParent(-1, -1);
        root.left.right.addChildWithParent(-1, -2);
        root.right.left.addChildWithParent(-1, 0);
        root.right.right.addChildWithParent(-1, -4);

        printPath(root,8);
    }
}