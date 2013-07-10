/*
You have two very large binary trees: T1, with millions of nodes and T2, with hundreds of nodes. Create an algorithm to decide
if T2 is a subtree of T1. A tree T2 is a subtree of T1 if there exists a node n in T1 such that the subtree of n is identical
to T2. That is, if you cut off the tree at node n, the two trees would be identical.
*/

import java.lang.System;

public class cracking4_8 {
    //just one stupid method: check each same node in T1 as the root of T2, and check if subtree matches
    public static boolean isSubtree (TreeNode big, TreeNode small) {
        if(small == null)
            return true;
        else if(big == null)
            return false;
        else if (big.value == small.value && matchTree(big,small)){
            return true;
        }
        else {
            return isSubtree(big.left,small) || isSubtree(big.right,small);
        }
    }

    public static boolean matchTree (TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null)
            return true;
        if(t1 == null || t2 == null)
            return false;
        if(t1.value != t2.value)
            return false;
        return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.addChildWithParent(2, 8);
        root.left.addChildWithParent(1, 3);
        root.right.addChildWithParent(6, 9);
        root.left.left.addChildWithParent(-1, -1);
        root.left.right.addChildWithParent(-1, 4);
        root.right.left.addChildWithParent(-1, 7);
        root.right.right.addChildWithParent(-1, 10);

        TreeNode root1 = new TreeNode(8);
        root1.addChildWithParent(6, 9);
        root1.right.addChildWithParent(-1, 7);
        root1.right.addChildWithParent(-1, 10);

        System.out.println(isSubtree(root,root1)?"YES":"NO");
    }
}
