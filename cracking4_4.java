/*
Given a binary tree, design an algorithm which creates a linked list of all the nodes at each depth(e.g., if you have a tree
with depth D, you will have D linked lists).
*/

import java.lang.System;
import java.util.ArrayList;
import java.util.LinkedList;

public class cracking4_4 {

    public static ArrayList< LinkedList<TreeNode> > levelTraverse (TreeNode n) {
        LinkedList<TreeNode> listOld = new LinkedList<TreeNode>();
        LinkedList<TreeNode> listNew = new LinkedList<TreeNode>();
        ArrayList< LinkedList<TreeNode> > array = new ArrayList<LinkedList<TreeNode>>();
        listOld.add(n);

        //stupid kid: this bug took me an hour:  LinkedList pass by reference you have to renew one, unless they are flushed
        array.add(new LinkedList<TreeNode>(listOld));

        while(!listOld.isEmpty()) {
            TreeNode tmpNode = listOld.removeFirst();
            if(tmpNode.left != null) listNew.add(tmpNode.left);
            if(tmpNode.right != null) listNew.add(tmpNode.right);

            if(listOld.isEmpty()) {
//                if(listNew.isEmpty()){    //unnecessary cause I check listOld
//                   break;
//                } else {
                array.add(new LinkedList<TreeNode>(listNew));

                LinkedList<TreeNode> tmp = new LinkedList<TreeNode>();
                listOld = listNew;
                listNew = tmp;
//                }
            }
        }
        return array;
    }

    public static void showArray(ArrayList< LinkedList<TreeNode> > array) {
        for(int i = 0;i<array.size();i++) {
            LinkedList<TreeNode> tmpList = array.get(i);
            showList(tmpList);
        }
    }

    public static void showList(LinkedList<TreeNode> list) {
        for(int i =0;i<list.size();i++) {
            TreeNode tmp = list.removeFirst();
            if(tmp == null)          //unnecessary
                System.out.print("null ");
            else
                System.out.print(tmp.value + " ");
            list.add(tmp);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ArrayList< LinkedList<TreeNode> > result = new ArrayList<LinkedList<TreeNode>>();
        TreeNode root = new TreeNode(5);
        root.addChild(2,8);
        root.left.addChild(1,3);
        root.right.addChild(6,9);
        root.left.left.addChild(-1,-1);
        root.left.right.addChild(-1, 4);
        root.right.left.addChild(-1, 7);
        root.right.right.addChild(-1, 10);

        result = levelTraverse(root);
        showArray(result);

    }

}


    //The book's DFS method:
    void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
        if(root == null) return;

        LinkedList<TreeNode> list = null;
        if(lists.size() == level) {
            lists.add(list);
        } else {
            list = lists.get(level);
        }
        list.add(root);
        createLevelLinkedList(root.left, lists, level + 1);
        createLevelLinkedList(root.right,lists,level+1);
    }

    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
        createLevelLinkedList(root,lists,0);
        return lists;
    }

    //The book's BFS method :
    ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
        ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
        LinkedList<TreeNode> current = new LinkedList<TreeNode>();
        if(root!=null) {
            current.add(root);
        }
        while(current.size()>0) {
            result.add(current);
            LinkedList<TreeNode> parents = current;
            current = new LinkedList<TreeNode>();
            for(TreeNode parent: parents) {
                if(parent.left!=null) current.add(parent.left);
                if(parent.right!=null) current.add(parent.right);
            }
        }
        return result;
    }

