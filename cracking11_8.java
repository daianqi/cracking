/*
Imagine you are reading in a stream of integers. Periodically, you wish to be able to look up the rank of a number x
(the number of values less than or equal to x). Implement the data structures and algorithms to support these operations.
That is, implement the method track(int x), which is called when each number is generated, and the method getRankOfNumber(int x),
which returns the number of values less than or equal to x(not including x itself).
*/

import java.lang.System;
import java.util.ArrayList;

public class cracking11_8 {
    public static int getRankOfNumber(int x,augmentedTree myTree) {
        augmentedTreeNode tmp = myTree.root;
        int count = 0;
        while(tmp != null) {
            if(x == tmp.value) {
                count += tmp.leftSize;  //bug
                return count;
            }
            else if(x > tmp.value) {
                count += 1;
                count += tmp.leftSize;
                tmp = tmp.rightChild;  //go right count+ (trick)
            } else {
                tmp = tmp.leftChild;   //go left no increasement
            }
        }
        return -1;
    }

    public static void track(int value,augmentedTree myTree) {
        if(myTree.root == null) {
            myTree.root = new augmentedTreeNode(value);
        } else {
            augmentedTreeNode tmp = myTree.root;
            while(tmp!= null ) {
                if(value<tmp.value) {
                    tmp.leftSize ++;
                    if(tmp.leftChild != null)
                        tmp = tmp.leftChild;
                    else {
                        tmp.leftChild = new augmentedTreeNode(value);
                        break;
                    }
                } else {
                    if(tmp.rightChild != null)
                        tmp = tmp.rightChild;
                    else {
                        tmp.rightChild = new augmentedTreeNode(value);
                        break;
                    }
                }
            }
        }
    }

    //book recursion
//    public void insert(int d) {
//        if(d<=data) {
//            if(left!=null)
//                left.insert(d);
//            else {
//                left = new RankNode(d);
//            }
//            left_size++;
//        } else {
//            if(right!=null)
//                right.insert(d);
//            else
//                right = new RankNode(d);
//        }
//    }
//
//    public int getRank(int d) {
//        if(d==data) {
//            return left_size;
//        } else if(d<data) {
//            if(left == null)    return -1;
//            else return left.getRank(d);
//        } else {
//            int right_rank = right == null?-1:right.getRank(d);
//            if(right_rank == -1)    return -1;
//            else return left_size+1+right_rank;
//        }
//    }

    public static class augmentedTree {
        augmentedTreeNode root;

        public augmentedTree () {
            root = null;
        }
    }

    public static class augmentedTreeNode {
        int value;
        int leftSize;
        augmentedTreeNode leftChild;
        augmentedTreeNode rightChild;

        public augmentedTreeNode(int i) {
            value = i;
            leftChild = null;
            rightChild = null;
            leftSize = 0;
        }
    }

    public static void printArray(ArrayList<augmentedTreeNode> array) {
        for(augmentedTreeNode n:array) {
            System.out.print(n.value + " ");
        }
        System.out.println();
    }

    public static void printTree(augmentedTree myTree) {
        ArrayList<augmentedTreeNode> old = new ArrayList<augmentedTreeNode>();
        ArrayList<augmentedTreeNode> newOne = new ArrayList<augmentedTreeNode>();
        old.add(myTree.root);
        while(!old.isEmpty()) {
            augmentedTreeNode tmp = old.remove(0);
            System.out.print(tmp.value + "("+tmp.leftSize+")"+" ");
            if(tmp.leftChild != null)
                newOne.add(tmp.leftChild);
            if(tmp.rightChild != null)
                newOne.add(tmp.rightChild);
            if(old.isEmpty()) {
                old = newOne;
                newOne = new ArrayList<augmentedTreeNode>();  //cant newOne.clear()
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        augmentedTree myTree = new augmentedTree();
        track(20,myTree);
        track(15,myTree);
        track(25,myTree);
        track(10,myTree);

        printTree(myTree);
        System.out.println("the rank of 15 is "+getRankOfNumber(15,myTree));

        track(5,myTree);
        track(13,myTree);
        track(23,myTree);

        printTree(myTree);
        System.out.println("the rank of 20 is "+getRankOfNumber(20,myTree));

        track(24,myTree);

        printTree(myTree);
        System.out.println("the rank of 25 is "+getRankOfNumber(25,myTree));

    }
}