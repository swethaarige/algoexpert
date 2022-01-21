public class ArrayOfProducts {
    public static void main(String[] args) {
        int[] array = {5, 1, 4, 2};
        int[] result = arrayOfProducts(array);
        for (int i = 0; i < result.length; i++) {
            System.out.println(" Array of Products is :" +result[i]);
        }
    }
    //O(n^2) Time and O(n) Space
    public static int[] arrayOfProducts(int[] array) {
        int[] products = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int runningProduct = 1;
            for (int j = 0; j < array.length; j++) {
                if (i != j) {
                    runningProduct *= array[j];
                }
                products[i] = runningProduct;
            }
        }
        return products;
    }

    //O(n) Time and O(n) Space
    public static int[] arrayOfProducts2(int[] array) {
        int[] products = new int[array.length];
        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];
        int leftRunningProduct = 1;
        for (int i = 0; i < array.length; i++) {
            leftProducts[i] = leftRunningProduct;
            leftRunningProduct *= array[i];
        }
        int rightRunningProduct = 1;
        for (int i = array.length - 1; i >= 0; i--) {
            rightProducts[i] = rightRunningProduct;
            rightRunningProduct *= array[i];
        }
        for (int i = 0; i < array.length; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }
        return products;
    }
}
