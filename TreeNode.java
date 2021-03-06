public class TreeNode {
    public int value;
    public TreeNode parent;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
        left = null;
        right = null;
        value = -1;
        parent = null;
    }

    public TreeNode(int i) {
        value = i;
        left = null;
        right = null;
        parent = null;
    }

    public TreeNode(int value, TreeNode parent) {
        this.value = value;
        left = null;
        right = null;
        this.parent = parent;
    }

//    public TreeNode(int i, int left, int right) {
//        this.left = this(left);
//        this.right = this(right);
//        this.value = i;
//    }

    public void addChild(int left, int right) {
        if(left == -1)
            this.left = null;
        else
            this.left = new TreeNode(left);
        if(right == -1)
            this.right = null;
        else
            this.right = new TreeNode(right);
    }

    public void addChildWithParent(int left,int right) {
        if(left == -1)
            this.left = null;
        else {
            this.left = new TreeNode(left, this);
        }
        if(right == -1)
            this.right = null;
        else {
            this.right = new TreeNode(right,this);
        }
    }

}