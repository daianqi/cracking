/*
Write an algorithm to find the 'next' node (in-order successor) of a given node in a binary search tree. You may assume that each node has a link to it parent.
*/

import java.lang.System;

public class cracking4_6 {

    public static TreeNode leftMost(TreeNode root) {
        if(root == null)
            return null;
        while(root.left != null)
            root = root.left;
        return root;
    }

    public static TreeNode getNext(TreeNode n) {
        if(n == null)
            return null;
        if(n.right != null)
            return leftMost(n.right);
        else {
//            TreeNode c = n;
//            TreeNode p = c.parent;    //stupid kid: you need to keep child and parent sperately
            TreeNode p = n;
//            while(p != null && p.left != c) {
//                c = p;
//                p = p.parent;
//            }
            while(p.parent != null && p.parent.left != p) {
                p = p.parent;
            }
//            return p;
            return p.parent; //when I return to the root and it's still not a left child, I will return null!
        }
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

        System.out.println(getNext(root).value);
        System.out.println(getNext(root.left.right.right).value);
//        System.out.println(getNexr(root.right.right.right).value); //I fix this bug for a night, FUUUUUUCK
        TreeNode result = getNext(root.right.right.right);
        if(result == null)
            System.out.println("NULL");
        else
            System.out.println(result.value);
    }
}
