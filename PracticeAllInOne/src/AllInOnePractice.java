

import com.sun.source.tree.BinaryTree;

import java.util.*;

public class AllInOnePractice {
    // Validate Subsequence
    public static boolean validateSubsequence(List<Integer> array, List<Integer> subsequence) {
        int arrayIdx = 0;
        int subArrayIdx = 0;
        while (arrayIdx < array.size() && subArrayIdx < subsequence.size()) {
            if (array.get(arrayIdx).equals(subsequence.get(subArrayIdx))) {
                subArrayIdx++;
            }
            arrayIdx++;
        }
        return subArrayIdx == subsequence.size();
    }

    //Two Number Sum Time O(n^2) Space O(n)
    public static int[] twoNumberSolution1(int[] array, int targetSum) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == targetSum) {
                    return new int[]{array[i], array[j]};
                }
            }
        }
        return new int[]{0};
    }

    //Two Number Sum Time O(n) Space O(n)
    public static int[] twoNumberSolution2(int[] array, int targetSum) {
        Set<Integer> nums = new HashSet<>();
        for (int num : array) {
            int potentialMatch = targetSum - num;
            if (nums.contains(potentialMatch)) {
                return new int[]{potentialMatch, num};
            }
            nums.add(num);
        }
        return new int[]{0};
    }

    //Two Number Sum Time O(nlogn) Space O(1)
    public static int[] twoNumberSolution3(int[] array, int targetSum) {
        Arrays.sort(array);
        int leftIdx = 0;
        int rightIdx = array.length - 1;
        while (leftIdx < rightIdx) {
            int currentSum = array[leftIdx] + array[rightIdx];
            if (currentSum == targetSum) {
                return new int[]{array[leftIdx], array[rightIdx]};
            }
            if (currentSum < targetSum) {
                leftIdx++;
            }
            if (currentSum > targetSum) {
                rightIdx--;
            }
        }
        return new int[]{0};
    }

    //Sorted Squares Time O(n^2) Space O(n) Space
    public static int[] sortedSquares(int[] array) {
        int[] sortedSquares = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            sortedSquares[i] = value * value;
        }
        Arrays.sort(sortedSquares);
        return sortedSquares;
    }
    /**
     * O(n) Time and O(n) Space
     *
     */
    public static int[] sortedSquaresSol2(int[] array) {
        int[] sortedSquares = new int[array.length];
        int smallerIdx = 0;
        int largerIdx = array.length - 1;
        for (int i = array.length - 1; i >= 0; i--) {
            int smallerIdxValue = array[smallerIdx];
            int largerIdxValue = array[largerIdx];
            if (Math.abs(smallerIdxValue) > Math.abs(largerIdxValue)) {
                sortedSquares[i] = smallerIdxValue * smallerIdxValue;
                smallerIdx++;
            } else {
                sortedSquares[i] = largerIdxValue * largerIdxValue;
                largerIdx--;
            }
        }
        return sortedSquares;
    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBst(tree, target, tree.value);
    }

    public static int findClosestValueInBst(BST tree, int target, int closest) {
        BST currentNode = tree;
        while (currentNode != null) {
            if (Math.abs(target - closest) > Math.abs(target - currentNode.value)) {
                closest = currentNode.value;
            }
            if (currentNode.value < target) {
                currentNode = currentNode.right;
            } else if (currentNode.value > target) {
                currentNode = currentNode.left;
            } else {
                break;
            }
        }
        return closest;
    }

    //O(n) Time n is Number of competitions and k is number of teams
    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions,
                                          ArrayList<Integer> results) {
        int HOME_TEAM_WON = 1;
        String currentBestTeam = "";
        HashMap<String, Integer> scores = new HashMap<String, Integer>();
        scores.put(currentBestTeam, 0);

        for (int idx = 0; idx < competitions.size(); idx++) {
            ArrayList<String> competition = competitions.get(idx);
            String homeTeam = competition.get(0);
            String awayTeam = competition.get(1);
            int result = results.get(idx);
            String winningTeam = (result == HOME_TEAM_WON) ? homeTeam : awayTeam;
            updateScores(winningTeam, 3, scores);
            if (scores.get(winningTeam) > scores.get(currentBestTeam)) {
                currentBestTeam = winningTeam;
            }
        }
        return currentBestTeam;
    }

    public static void updateScores(String team, int points, HashMap<String, Integer> scores) {
        if (!scores.containsKey(team)) {
            scores.put(team, 0);
        }
        scores.put(team, scores.get(team) + points);
    }

    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currentChangeCreated = 0;
        for (int coin : coins) {
            if (coin > currentChangeCreated + 1) {
                return currentChangeCreated + 1;
            }
            currentChangeCreated += coin;
        }
        return currentChangeCreated + 1;
    }

    public static class BinaryTree2 {
        int value;
        BinaryTree2 left;
        BinaryTree2 right;

        BinaryTree2(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

        public static List<Integer> branchSums(BinaryTree2 root) {
            List<Integer> sums = new ArrayList<>();
            calculateBranchSums(root, 0, sums);
            return sums;
        }
        // O(n) Time and O(n) Space
        public static void calculateBranchSums(BinaryTree2 root, int runningSum,
                                               List<Integer> sums) {
            if (root == null) return;

            int newRunningSum = runningSum + root.value;
            if (root.left == null && root.right == null) {
                sums.add(newRunningSum);
                return;
            }
            calculateBranchSums(root.left, newRunningSum, sums);
            calculateBranchSums(root.right, newRunningSum, sums);
        }
        // O(n) Time - n is number of nodes 0(h) - h is the height of the binary tree
        public static int nodeDepths(BinaryTree2 root) {
         return nodeDepthsHelper(root, 0);
        }

        public static int nodeDepthsHelper(BinaryTree2 root, int depth) {
        if (root == null) return 0;
        return depth + nodeDepthsHelper(root.left, depth + 1) +
                nodeDepthsHelper(root.right, depth + 1);
        }

        public static class Node {
           String name;
           List<Node> children = new ArrayList<Node>();

           public Node(String name) {
               this.name = name;
           }

           public Node addChild(String name) {
               Node child = new Node(name);
               children.add(child);
               return this;
           }
            /**
             * O(n) Time and O(n) Space
             *
             */
           public List<String> depthFirstSearch(List<String> array) {
               array.add(this.name);
               for (int i = 0; i < children.size(); i++) {
                   children.get(i).depthFirstSearch(array);
               }
               return array;
           }

        }
        //Minimum Waiting Time
        public static int minimumWaitingTime(int[] queries) {
           Arrays.sort(queries);
           int totalMinimumWaitingTime = 0;
           for (int idx = 0; idx < queries.length; idx++) {
               int duration = queries[idx];
               int queriesLeft = queries.length -(idx + 1);
               totalMinimumWaitingTime += duration * queriesLeft;
           }
           return totalMinimumWaitingTime;
        }

    public static boolean classPhotos(
            ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights, Collections.reverseOrder());
        Collections.sort(blueShirtHeights, Collections.reverseOrder());
        String firstRow = redShirtHeights.get(0) > blueShirtHeights.get(0) ? "BLUE" : "RED";
        for (int idx = 0; idx < redShirtHeights.size(); idx++) {
            int redShirtHeight = redShirtHeights.get(idx);
            int blueShirtHeight = blueShirtHeights.get(idx);
            if (firstRow == "BLUE") {
                if (blueShirtHeight >= redShirtHeight) {
                    return false;
                }
            } else {
                if (blueShirtHeight <= redShirtHeight) {
                    return false;
                }
            }
        }
        return true;
    }
    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        if (!fastest) {
           reverseInPlace(redShirtSpeeds);
        }
        int totalSpeed = 0;
        for (int idx = 0; idx < redShirtSpeeds.length; idx++) {
            int rider1 = redShirtSpeeds[idx];
            int rider2 = blueShirtSpeeds[redShirtSpeeds.length - idx - 1];
            totalSpeed += Math.max(rider1, rider2);
        }
        return totalSpeed;
    }

    public  static void reverseInPlace(int[] array) {
        int startIdx = 0;
        int endIdx = array.length - 1;
        while (startIdx < endIdx) {
            int temp = array[startIdx];
            array[startIdx] = array[endIdx];
            array[endIdx] = temp;
            startIdx++;
            endIdx--;
        }
    }

    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }
    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList currentNode = linkedList;
        while (currentNode != null) {
            LinkedList distinctNextNode = currentNode.next;
            while (distinctNextNode != null && distinctNextNode.value == currentNode.value) {
                distinctNextNode = distinctNextNode.next;
            }
            currentNode.next = distinctNextNode;
            currentNode = distinctNextNode;
        }
        return linkedList;
    }
     // O(2^n) Time O(n) Space
    public static int getNthFib(int n) {
        if (n == 1) {
            return 0;
        }
        else if (n == 2) {
            return 1;
        } else {
            return getNthFib(n - 1) + getNthFib(n - 2);
        }
    }

    // O(n) Time O(n) Space
    public static int getNthFib2(int n) {
        Map<Integer, Integer> memoize = new HashMap<>();
        memoize.put(1, 0);
        memoize.put(2, 1);
        return getNthFib(n - 1, memoize);
    }

    public static int getNthFib(int n, Map<Integer, Integer> memoize) {
        if (memoize.containsKey(n)) {
            return memoize.get(n);
        }
         memoize.put(n,  getNthFib(n - 1, memoize) +
                getNthFib(n - 2, memoize));
        return memoize.get(n);
    }

    public static int getNthFib3(int n) {
        int[] lastTwo = {0, 1};
        int counter = 3;
        while (counter <= n) {
            int nextFib = lastTwo[0] + lastTwo[1];
            lastTwo[0] = lastTwo[1];
            lastTwo[1] = nextFib;
            counter++;
        }
        return n > 1 ? lastTwo[1] : lastTwo[0];
    }

    //O(n) Time n is total number of elements including sub elements
    //O(d) d is the depth of special array.
    public static int productSum(List<Object> array) {
        return productSumHelper(array, 1);
    }
    public static int productSumHelper(List<Object> array, int multiplier) {
        int sum = 0;
        for (Object el : array) {
            if (el instanceof ArrayList) {
                ArrayList<Object> ls = (ArrayList<Object>) el;
                sum += productSumHelper(ls, multiplier + 1);
            } else {
                sum += (int)el;
            }
        }
        return sum * multiplier;
    }
    // O(logn) Space and O(logn) Time
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }
   // O(logn) time and O(logn) Space
    public static int binarySearch(int[] array, int target, int left, int right) {
        while (left <= right) {
            int middle = (left + right) / 2;
            int potentialMatch = array[middle];
            if (target == potentialMatch) {
                return middle;
            } else if (target < potentialMatch) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
    // O(n) Time
    //O(1) Space
    public static int[] findThreeLargestNumbers(int[] array) {
        int[] threeLargest = {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for (int num : array) {
            updateLargest(threeLargest, num);
        }
        return threeLargest;
    }

    public static void updateLargest(int[] threeLargest, int num) {
        if (num > threeLargest[2]) {
            shiftAndUpdate(threeLargest, num, 2);
        } else if (num > threeLargest[1]) {
            shiftAndUpdate(threeLargest, num, 1);
        } else if(num > threeLargest[0]) {
            shiftAndUpdate(threeLargest, num, 0);
        }
    }
    public static void shiftAndUpdate(int[] array, int num, int idx) {
       for (int i = 0; i < idx; i++) {
           if (i == idx) {
               array[i] = num;
           } else {
               array[i] = array[i + 1];
           }
       }
    }
    //Best Time O(n) Space O(1)
    //Worst and Average O(n^2) and O(1)
    public static int[] bubbleSort(int[] array) {
        if (array.length == 0) {
            return new int[] {};
        }
        boolean isSorted = false;
        int counter = 0;
        while (!isSorted) {
            for (int i = 0; i < array.length - 1 - counter; i++) {
                isSorted = true;
                if (array[i] > array[i + 1]) {
                    swap(i, i + 1, array);
                    isSorted = false;
                }
            }
            counter++;
        }
        return array;
    }
    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
    //Best, Worst, Average Time O(n^2) Space O(1)
    public static int[] insertionSort(int[] array) {
        if (array.length == 0) {
            return new int[] {};
        }
        for (int i = 1; i < array.length; i++) {
            int j = i;
            while (j > 0 && array[i] < array[i - 1]) {
                swap(i, i - 1, array);
            }
            j -= 1;
        }
        return array;
    }
    //Best, Worst, Average Time O(n^2) Space O(1)

    public static int[] selectionSort(int[] array) {
        int startIdx = 0;
        while (startIdx < array.length - 1) {
            int smallestIdx = startIdx;
            for (int i = startIdx + 1; i < array.length; i++) {
                if (array[smallestIdx] > array[i]) {
                    smallestIdx = i;
                }
            }
            swap(smallestIdx, startIdx, array);
            startIdx++;
        }
        return array;
    }
    //O(n) Time O(n) Space
    public static boolean isPalindrome(String str) {
        StringBuilder reverseString = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            reverseString.append(str.charAt(i));
        }
       return str.equals(reverseString.toString());
    }
    //O(n) Time O(1) Space
    public static boolean isPalindrome2(String str) {
        int leftIdx = 0;
        int rightIdx = str.length() - 1;
        while (leftIdx < rightIdx) {
            if(str.charAt(leftIdx) != str.charAt(rightIdx)) {
                return false;
            }
            leftIdx++;
            rightIdx--;
        }
        return true;
    }
    //O(n) Time and O(n) Space
    public static String caesarCypherEncryptor(String str, int key) {
        int newKey = key % 26;
        char newLetters[] = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            newLetters[i] = generateNewLetter(str.charAt(i), newKey);
        }
        return new String(newLetters);
    }
    public static char generateNewLetter(char letter, int key) {
        int newLetter = letter + key;
        return newLetter <= 122 ? (char)newLetter : (char)(96 + newLetter % 122);
    }
    //O(n) Time O(n) Space
    public String runLengthEncoding(String string) {
        int currentRunLength = 1;
        StringBuilder encodedString = new StringBuilder();
        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) != string.charAt(i - 1) || currentRunLength == 9) {
                encodedString.append(Integer.valueOf(currentRunLength));
                encodedString.append(string.charAt(i - 1));
                currentRunLength = 0;
            }
            currentRunLength += 1;
        }
            encodedString.append(Integer.valueOf(currentRunLength));
            encodedString.append(string.charAt(string.length() - 1));
        return encodedString.toString();
    }
    //O(n + m) Time where n is number of characters in 1st String and m is number of character in document
    //O(c) Space c is the number of unique characters in both.
    public boolean generateDocument(String characters, String document) {
        HashMap<Character, Integer> characterCounts = new HashMap<>();
        for (int i = 0 ; i < characters.length(); i++) {
            characterCounts.put(characters.charAt(i),
                    characterCounts.getOrDefault(characters.charAt(i), 0) + 1);
        }
        for (int i = 0; i < document.length(); i++) {
            if (!characterCounts.containsKey(document.charAt(i)) ||
                    characterCounts.get(document.charAt(i)) == 0) {
                return false;
            }
            characterCounts.put(document.charAt(i),
                    characterCounts.get(document.charAt(i)) - 1);
        }
        return true;
    }
    // O(n) Time where n is number of characters in String
    // O(1) Space as the input string contains only english small letters hence the max space of
    //hash table will be only 26 character frequencies
    public static int firstNonRepeatingCharacter(String string) {
        HashMap<Character, Integer> characterFrequencies = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            characterFrequencies.put(string.charAt(i),
                    characterFrequencies.getOrDefault(string.charAt(i), 0) + 1);
        }
        for (int i = 0; i < string.length(); i++) {
            if (characterFrequencies.get(string.charAt(i)) == 1) {
                return i;
            }
        }
        return  - 1;
    }
    //O(n^2) Time and O(n) Space
    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        Arrays.sort(array);
        List<Integer[]> triplets = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            int leftIdx = i + 1;
            int rightIdx = array.length - 1;
            while (leftIdx < rightIdx) {
                int currentSum = array[i] + array[leftIdx] + array[rightIdx];
                if (targetSum == currentSum) {
                    Integer[] newTriplet = new Integer[]{array[i], array[leftIdx], array[rightIdx]};
                    triplets.add(newTriplet);
                    leftIdx++;
                    rightIdx--;
                } else if (targetSum < currentSum) {
                    rightIdx--;
                } else if (targetSum > currentSum){
                    leftIdx++;
                }
            }
        }
        return triplets;
    }
    //O(nlogn) + O(mlogm) Time
    //O(1) Space
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int oneIdx = 0;
        int twoIdx = 0;
        int currentSum = Integer.MAX_VALUE;
        int smallestSum = Integer.MAX_VALUE;
        int[] smallestPair = new int[2];
        while(oneIdx < arrayOne.length && twoIdx < arrayTwo.length) {
            int firstNum = arrayOne[oneIdx];
            int secondNum = arrayTwo[twoIdx];
            if (firstNum < secondNum) {
                currentSum = secondNum - firstNum;
                oneIdx++;
            } else if (secondNum < firstNum) {
                currentSum = firstNum - secondNum;
                twoIdx++;
            } else {
                return new int[] {firstNum, secondNum};
            }
            if (smallestSum > currentSum) {
                smallestSum = currentSum;
                smallestPair = new int[] {firstNum, secondNum};
            }
        }
        return smallestPair;
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int i = 0;
        int j = array.size() - 1;
        while (i < j) {
            while (i < j && array.get(j) == toMove)
                j--;
                if (array.get(i) == toMove) {
                    swap(i, j, array);
                    i++;
                }
            }
        return array;
    }

    public static void swap(int i, int j, List<Integer> array) {
        int temp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, temp);
    }
}



