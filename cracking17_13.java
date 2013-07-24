/*
Convert BiNode tree into doubly linked list. The values should be kept in order and the operation should be performed in
place (that is, on the original data structure).
*/

public class cracking17_13 {
    public static class NodePair {
        BiNode head;
        BiNode tail;

        public NodePair(BiNode head, BiNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public static convert(BiNode node) {
        BiNode left = convert(node.left);
        BiNode right = convert(node.right);
        mergeList(left,node,right);
        return left;  //the farthest on the left? WOW
    }

    public static NodePair convert(BiNode root) {
        if(root == null)
            return null;  //I will skip null later, so return null is fine

        NodePair part1 = convert(root.node1);//left
        NodePair part2 = convert(root.node2);//right

        if(part1 != null) {
            concat(part1.tail,root);   //part1.tail->root
        }
        if(part2 != null) {
            concat(root,part2.head);   //head ->part2.head
        }

        return new NodePair( part1==null?root:part1.head,
                part2==null?root:part2.tail );
    }

    public static void concat(BiNode x,BiNode y) {
        x.node2 = y;
        y.node1 = x;//x<->y
    }
}