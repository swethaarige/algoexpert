/*
Understanding the problem
I am given two non-empty arrays of positive integers. The first array is going to represent
the heights of students wearing red shirts and the second array is going to represent the
heights of students wearing blue shirts. The two arrays will always have the same length.
I am asked to write a function that is going to find out if we can take a photo of these students
that adheres to the following constraints:

All the students that are wearing red shirts must be in the same row;
All of the students that are wearing blue shirts must be in the same row;
The photo must have exactly two rows and the two rows must have the same number of students in them.
Every student in the front row must be shorter than the student directly behind them in the back row.
The function is going to arrange the students and return true if we can take a photo that follows
these constraints; otherwise return false.

Better Approach
Suppose the two arrays are [4, 6, 2, 7] and [8, 3, 5, 9]. To arrange the students under the aforementioned
constraints, first I am going to find out the tallest student in the two arrays, because all of the
other students are shorter than that student and they can not stand behind him. The height of the tallest
student is 9 from the second array. It also means all of the students from the second array should be in the
back row.

First array(red shirt): [4, 6, 2, 7]
Second array(blue shirt): [8, 3, 5, 9]

Tallest student in the two arrays: 9

Back row(blue shirt):  9
Front row(red shirt):
Then I am going to find out who is going to be in front of the student with height of 9.
The student must come from the first array. I am going to select the tallest student in the
first array, because the tallest student in the first array might be taller than all of the
rest students in the second array. The tallest student in the first array is 7.
First array(red shirt): [4, 6, 2, 7]
Second array(blue shirt): [8, 3, 5]
Tallest student in the first array: 7
Back row(blue shirt):  9
Front row(red shirt):  7
Now I am going to find out who is going to be the next student that stands in the back row.
I am going to choose the tallest student in the remaining second array, and compare it to the
tallest student in the remaining first array. If the tallest student in the first array is taller
than the tallest student in the second array, then the photo can not be taken, because no student
in the rest of the second array is going to be able to stand behind the student from the first array.
The tallest student in the remaining second array is 8, and the tallest student in the remaining
first array is 6. Since 6 is smaller than 8, so the photo can be taken.
First array(red shirt): [4, 6, 2]
Second array(blue shirt): [8, 3, 5]
Tallest student in the second array: 8
Tallest student in the first array: 6
Back row(blue shirt):  9, 8
Front row(red shirt):  7, 6
Repeat that process until the end of the both arrays is reached or I find out such a photo cannot be taken,
which means the tallest student in the remaining second array is shorter than the tallest student in the remaining first array.
Back row(blue shirt):  9, 8, 5, 3
Front row(red shirt):  7, 6, 4, 2
So that means I need to sort both arrays at the very beginning in the descending order and compare the
tallest student in the first array to the tallest student in the second array to find out whether or not
the students wearing red shirts are going to be in the front row. I would use a Boolean to store the
comparison result. Iterate through the two sorted arrays starting from index 0, because I need to handle
the case where the tallest students in the two arrays have the same height, for instance, the two arrays
are [6, 5] and [6, 4]. At each iteration, compare the heights at current index in the two arrays.
If the students wearing red shirts are going to be in the front row, then the height from the second array
should be greater than the height from the first array; otherwise it should be smaller. Return false,
if that is not the case. When I get out of the loop without returning the result, return true.

Time & Space Complexity
O(nlog(n)) time | O(1) space, where n is the number of integers(students).
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ClassPhotos {

    public static void main (String[] args) {
        int [] redShirts = {5, 8, 1, 3, 4};

        int [] blueShirts ={6, 9, 2, 4, 5};
        ArrayList<Integer> redShirtsHeights = Arrays.stream(redShirts)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        ArrayList<Integer> blueShirtHeights = Arrays.stream(blueShirts)
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        System.out.println("class Photos can be possible :" +classPhotos(redShirtsHeights, blueShirtHeights));
    }
    public static boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeights, Collections.reverseOrder());

        String firstRow =   (redShirtHeights.get(0) > blueShirtHeights.get(0)) ? "BLUE" : "RED" ;

        for( int idx = 0; idx < redShirtHeights.size(); idx++) {
            int redShirtHeight = redShirtHeights.get(idx);
            int blueShirtHeight = blueShirtHeights.get(idx);

            if (firstRow == "RED") {
                if(redShirtHeight >= blueShirtHeight) {
                    return false;
                }
            }
            else {
                if(blueShirtHeight >= redShirtHeight) {
                    return false;
                }
            }
        }
        return true;
    }
}
