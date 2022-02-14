import java.util.ArrayList;
import java.util.List;

/*
Problem Statement :Given a set of distinct integers, nums, return all possible subsets (the power set).
Example 1:Input: nums = [1,2,3]
Output:[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []]
Intuition
The crucial thing in this problem is to figure out a strategy to recurse and generate all combinations.
Let’s break the problem down to:
generate all combinations of length 0 (empty set)
generate all combinations of length 1 (individual elements)
generate all combinations of length 2
… and so on until the length of the given array.
Time Complexity - O(n * 2 ^n) and Space Complexity - O(n * 2 ^n)
 */
public class PowerSet {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(1); input.add(2); input.add(3);
        List<List<Integer>> result = powerSet(input);
        for (List<Integer> eachList : result) {
            System.out.println("Each List Length" +eachList.size());
            for (Integer element : eachList) {
                System.out.println("Each list " + element);
            }
        }
    }
    public static List<List<Integer>> powerSet(List<Integer> array) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for (Integer ele : array) {
            System.out.println("Element" +ele);
            int length = subsets.size();
            System.out.println("Lenegth " +length);
            for (int i = 0; i < length; i++) {
                System.out.println("Subsets of i " +subsets.get(i));
                System.out.println("Elements " +ele);
                List<Integer> currentSubset = new ArrayList<Integer>(subsets.get(i));
                currentSubset.add(ele);
                subsets.add(currentSubset);
            }
        }
        return subsets;
    }
}
