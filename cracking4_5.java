/*
Implement a function to check if a binary tree is a binary search tree.
*/

import java.lang.Integer;
import java.util.ArrayList;

public class cracking4_5 {
    //stupid mind: BST != (left.date <= current.data < right.data)
    //smart MinMax method to set range
    public static boolean checkBSTbyMinMax (TreeNode root, int Max, int Min) {
        if(root == null)
            return true;
        if(root.value > Max || root.value <= Min) return false;

        if(!checkBSTbyMinMax(root.left,root.value,Min))
            return false;
        if(!checkBSTbyMinMax(root.right, Max, root.value))
            return false;
        return true;
    }

    //smart checkBSTwithoutArray
    public static int last = Integer.MIN_VALUE;
    public static boolean checkBSTwithoutArray(TreeNode root) {
        if(root == null)
            return true;
        if(!checkBSTwithoutArray(root.left))//you don't need to && left and right, just check them and throw away
            return false;
        if(root.value < last) return false;
        last = root.value;
        if(!checkBSTwithoutArray(root.right))
            return false;
        return true;
    }

    //stupid checkBSTbyArray
    public static void checkBSTbyArray (TreeNode root, ArrayList<Integer> array) {
        if(root == null)
            return;
        else {
            if(root.left != null)
                checkBSTbyArray(root.left, array);
            array.add(root.value);
            if(root.right != null)
                checkBSTbyArray(root.right, array);
        }
    }

    public static boolean checkArrayInOrder (ArrayList<Integer> array) {
        if(array.size() == 0 || array.size() == 1)
            return true;
        else {
            for(int i = 1;i<array.size();i++) {
                if(array.get(i)<array.get(i-1))
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(5);
        root.addChild(2,8);
        root.left.addChild(1,3);
        root.right.addChild(6,9);
        root.left.left.addChild(-1,-1);
        root.left.right.addChild(-1, 4);
        root.right.left.addChild(-1, 7);
        root.right.right.addChild(-1, 10);

        ArrayList<Integer> array = new ArrayList<Integer>();
//        checkBSTbyArray(root,array);
//        System.out.println(checkArrayInOrder(array)?"Yes":"No");
//        System.out.println(checkBSTwithoutArray(root)?"Yes":"No");

        System.out.println(checkBSTbyMinMax(root, Integer.MAX_VALUE, Integer.MIN_VALUE)?"Yes":"No");
    }
}
