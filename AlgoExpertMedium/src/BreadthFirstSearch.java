/*
The implementation can be done using a queue [a queue is a data structure used to store objects
, where objects are inserted and removed according to the first-in-first-out (FIFO) principle]:
1. Start with root node. Mark it visited.
2. Push its left child node and right child node to the queue.
3. Pop a node from the queue and mark it as visited. Push its left child node and right child node to the queue.
4. Repeat Step 3 until the queue is empty.
Time complexity
The time complexity is the same as DFS—O(V+E), where V is the number of vertices and E is the number of edges.
Space complexity
The space complexity is O(l), where l is the maximum number of nodes in a single level.
Applications
BFS is used to find the shortest path between two nodes.
It’s used to find neighbouring locations in GPS systems.
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearch {
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }
        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
        //O(v+e) Time and O(v) space
        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> queue = new LinkedList<>();
            queue.add(this);
            while (!queue.isEmpty()) {
                Node current = queue.poll();
                array.add(current.name);
                queue.addAll(current.children);
            }
            return array;
        }
    }
}
