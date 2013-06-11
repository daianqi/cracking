public class StackNode {
    public StackNode above;
    public StackNode below;
    public int item;

    public StackNode(int i) {
        item = i;
        above = null;
        below = null;
    }
}