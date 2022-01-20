import java.util.ArrayList;
import java.util.List;

/*
You are given an array of integers and an integer. Write a function that moves all instances of
that integer in the array to the end of the array. Return the array.
The function should mutate the input array, i.e. the operation should be performed in place,
and doesn’t need to maintain the order of the integers.
https://blessingadesiji.medium.com/arrays-move-element-to-end-12a39cd3c5fb
O(n) Time and O(1) Space

 */
public class MoveElementToEnd {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(8);
        array.add(2);array.add(1);array.add(2);array.add(2);array.add(2);
        array.add(3);array.add(4);array.add(2);
        List<Integer> result = moveElementToEnd(array, 2);
        for (int i = 0; i < result.size(); i++) {
            System.out.println("Result " +result.get(i));
        }

    }
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            while (i < j && array.get(j) == toMove)
                j--;
                if (array.get(i) == toMove)
                    swap(i, j, array);
                    i++;
            }
        return array;
    }
    public static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }
}
