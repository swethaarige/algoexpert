import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//O(nlogn) Time and O(n) space where n is length of the array
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] arr = {{1, 2}, {3, 5},{4, 7}, {6, 8}, {9, 10} };
        int[][] mergedIntervals = mergeOverlappingIntervals(arr);
        for (int[] mergedInterval : mergedIntervals) {
            System.out.println("Merge Overlapping Intervals for the given array are :" +mergedInterval[0] + mergedInterval[1]);
        }
    }
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        int[][] sortedIntervals = intervals.clone();
        Arrays.sort(sortedIntervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] cuurentInterval = sortedIntervals[0];
        mergedIntervals.add(cuurentInterval);

        for (int[] nextInterval : sortedIntervals) {
            int currentIntervalEnd = cuurentInterval[1];
            int nextIntervalStart = nextInterval[0];
            int nextIntervalEnd = nextInterval[1];
            if (currentIntervalEnd >= nextIntervalStart) {
                cuurentInterval[1] = Math.max(currentIntervalEnd, nextIntervalEnd);
            } else {
                cuurentInterval = nextInterval;
                mergedIntervals.add(cuurentInterval);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}
