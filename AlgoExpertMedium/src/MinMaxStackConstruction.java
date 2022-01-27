/*
Write a MinMaxStack class for a Min Max Stack. The Class should support:
Pushing and popping values on and off the stack
Peeking at the value at the top of the Stack
Getting both the maximum and minimum values in the stack at any given point in time.
All Class methods when considered independently, should run in the constant time and constant space
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinMaxStackConstruction {
    static class MinMaxStack {
        List<Map<String, Integer>> minMaxStack = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();

        //O(1) Time and O(1) Space
        public int peek() {
            return stack.get(stack.size() - 1);
        }

        //O(1) Time and O(1) Space
        public int pop() {
            minMaxStack.remove(minMaxStack.size() - 1);
            return stack.remove(stack.size() - 1);
        }

        //O(1) Time and O(1) Space
        public void push(Integer number) {
            Map<String, Integer> newMinMax = new HashMap<>();
            newMinMax.put("min", number);
            newMinMax.put("max", number);
            if (minMaxStack.size() > 0) {
                Map<String, Integer> lastMinMax = new HashMap<>();
                newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
                newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
            }
            minMaxStack.add(newMinMax);
            stack.add(number);
        }

        //O(1) Time and O(1) Space
        public int getMin() {
            return minMaxStack.get(minMaxStack.size() - 1).get("min");
        }

        //O(1) Time and O(1) Space
        public int getMax() {
            return minMaxStack.get(minMaxStack.size() - 1).get("max");
        }
    }
}
