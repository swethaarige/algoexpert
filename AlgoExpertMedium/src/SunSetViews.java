/*
Given a set of buildings in an array, process the buildings from east to west and return the list
of buildings that have a sunset view.If a building is shorter than another building to its west
then it looses its sunset view.A buidling can see the sunset if its strictly taller than all of the
buidlings that come after it in the direction that it faces.
All of the buidings face the same direction and this direction is either east or west.
In relation to the input array you can intrepret these diretions as right for east and left for west.
Sample Input : buildings = [3,5,4,4,3,1,3,2]
direction = "EAST"
Sample Output : [1, 3, 6, 7]
Time Complexity O(n) and Space Complexity is O(n)
 */

import java.util.ArrayList;
import java.util.Collections;

public class SunSetViews {
    public static void main (String[] args) {
        int[] buildings = {3, 5, 4, 4, 3, 1, 3, 2};
        ArrayList<Integer> buildingsWithSunsetViews = sunsetViews(buildings, "EAST");
        for (Integer idx : buildingsWithSunsetViews) {
            System.out.println(" Building Index is  :" +idx);
        }
    }
    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> buildingsWithSunsetViews = new ArrayList<Integer>();

        int startIdx = buildings.length - 1;
        int step = -1;

        if (direction.equals("WEST")) {
            startIdx = 0;
            step = 1;
        }
        int idx = startIdx;
        int runningHeight = 0;

        while (idx >= 0 && idx < buildings.length) {
            int buildingHeight = buildings[idx];
            if (buildingHeight > runningHeight) {
                buildingsWithSunsetViews.add(idx);
            }
            runningHeight = Math.max(runningHeight, buildingHeight);
            idx += step;
        }
        if (direction.equals("EAST")) {
            Collections.reverse(buildingsWithSunsetViews);
        }
          return buildingsWithSunsetViews;
        }
}
