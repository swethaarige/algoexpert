public class SearchInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,4,7}, {2, 3,9}, {5,8,9}};
        int[] result = searchInSortedMatrix(matrix, 3);
        System.out.println("Result " + result[0] +result[1]);
    }
    //O(n+m) Time and O(1) Space
    public static int[] searchInSortedMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return new int[] {row, col};
            }
        }
        return new int[] {-1, -1};
    }
}
