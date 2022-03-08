import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> permutations = permutations(nums);
        System.out.println("Permutations count is  " +permutations.size());
        for (List<Integer> num : permutations) {
            for (Integer no : num) {
                System.out.println("No " +no);
            }
        }
    }
    public static List<List<Integer>> permutations (int[] nums) {
       List<List<Integer>> list = new ArrayList<>();
       backtrack(list, new ArrayList<Integer>(), nums);
       return list;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums ) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue;
                tempList.add(nums[i]);
                backtrack(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
