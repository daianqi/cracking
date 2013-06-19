/*
Implement a function to check if a binary tree is balanced. For the purposes of this question, a balanced tree is defined to be a tree such that the heights of the two subtrees of any node never differ by more than one.
*/

public class cracking4_1 {

    //step1:
    public int checkHeight(TreeNode n) {
        if(n == null)
            return 0;          //height 0 basic case

        leftHeight = checkHeight(n.left);
        rightHeight = checkHeight(n.right);
        return Math.max(leftHeight, rightHeight) + 1;   //get height
    }

    //step2:
    public int checkHeight(TreeNode n) {
        if(n == null)
            return 0;

        int leftHeight = checkHeight(n.left);
        int rightHeight = checkHeight(n.right);

        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1)
            return -1;                              //get negative value
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }

    //step3:
    public int checkHeight(TreeNode n) {
        if(n == null)
            return 0;

        int leftHeight = checkHeight(n.left);   //save energy
        if(leftHeight == -1)
            return -1;

        int rightHeight = checkHeight(n.right);
        if(rightHeight == -1)
            return -1;

        int heightDiff = leftHeight - rightHeight;
        if(Math.abs(heightDiff) > 1)
            return -1;
        else
            return Math.max(leftHeight, rightHeight) + 1;
    }

    public static boolean checkBalance(TreeNode root) {
        if(checkHeight(root) == -1)
            return false;
        else
            return true;
    }
}
