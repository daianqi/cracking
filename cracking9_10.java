/*
You have a stack of n boxes, with widths w1, heights h1, and depth d1. The boxes cannot be rotated and can only be stacked on
top of one another if each box in the stack is strictly larger than the box above it in width, height, and depth Implement a
method to build the tallest stack possible, where height of a stack is the sum of the heights of each box.
*/

import java.util.ArrayList;
import java.util.HashMap;

public class cracking9_10 {
    
    public ArrayList<Box> createStackR(Box[] boxes, Box bottom) {
        int max_height = 0;
        ArrayList<Box> max_stack = null;
        for(int i = 0;i<boxes.length;i++) {
            if(boxes[i].canBeAbove(bottom)) {   //stupid mind cant understand
                ArrayList<Box> new_stack = createStackR(boxes, boxes[i]);
                int new_height = stackHeight(new_stack);
                if(new_height > max_height) {
                    max_height = new_height;
                    max_stack = new_stack;
                }
            }
        }

        if(max_stack == null) {
            max_height = new ArrayList<box>();
        }
        if(bottom!=null) {
            max_stack.add(0,bottom);
        }
        return max_stack;
    }

    public ArrayList<Box> createStackDP(Box[] boxes, Box bottom, HashMap<Box, ArrayList<Box>> stack_map) {
        if(bottom != null && stack_map.containsKey(bottom)) {
            return stack_map.get(bottom);
        }

        int max_height = 0;
        ArrayList<Box> max_stack = null;
        for(int i = 0; i< boxes.length;i++) {
            if(boxes[i].canBeAbove(bottom)) {
                ArrayList<Box> new_stack = createStackDP(boxes,boxes[i],stack_map);
                int new_height = stackHeight(new_stack);
                if(new_height > max_height) {
                    max_height = new_height;
                    max_stack = new_stack;
                }
            }
        }
        if(max_stack == null) max_stack = new ArrayList<Box>();
        if(bottom != null) max_stack.add(0,bottom);

        stack_map.put(bottom,max_stack);

        return (ArrayList<Box>)max_stack.clone(); //genuis
    }
}
