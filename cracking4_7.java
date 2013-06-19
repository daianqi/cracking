/*
Design an algorithm and write code to find the first common ancestor of two nodes in a binary tree. Avoid storing additional nodes in a data structure. NOTE: This is not necessarily a binary search tree.
*/

import java.lang.System;

public class cracking4_7 {
    public static boolean contains(TreeNode root, TreeNode n) {
        if(root == null)
            return false;
        if(root == n)
            return true;
        else
            return contains(root.left,n) || contains(root.right,n);
    }

    public static TreeNode firstCommon (TreeNode p, TreeNode q, TreeNode root) {
        if(root == null)
            return null;
        if(!contains(root,p) && !contains(root,q))
            return null;    //stupid error check
        if(contains(root.left, p) && contains(root.left, q))
            return firstCommon(p,q,root.left);
        else if(contains(root.right,p) && contains(root.right,q))
            return firstCommon(p,q,root.right);
        else
            return root;
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

//        TreeNode result = firstCommon(root.left.left,root.right.right.right,root);
        TreeNode result = firstCommon(root.left,root.left.right.right,root);
        System.out.println(result==null?"NULL":result.value);
    }
}
