public class StackData {
    public int start;
    public int pointer;
    public int size = 0;
    public int capacity;

    public StackData(int start, int capacity) {
        this.start = start;
        this.pointer = start - 1;
        this.capacity = capacity;
    }

    public boolean isWithinStack(int index, int total_size) {
        if(start <= index && index < start + capacity)
            return true;
        else if (start+capacity>total_size && index< (start+capacity)%total_size)
            return true;
        return false;
    }
}