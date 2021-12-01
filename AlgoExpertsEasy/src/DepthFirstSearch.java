/*
Depth-first Search
Understanding the problem
I am given an acyclic tree-like graph. Each node in this graph is going to be an instance of a Node class.
Each node is going to have a name and optionally have some children nodes.
I am asked to write a depthFirstSearch method on the Node class, that is going to performs a
depth-first search on the graph. The method is going to accept an empty array as argument.
As it traverses the graph, it is going to get the names of all nodes, put them in the input array
and return that array. The nodes should be visited from left to right.

Approach
Since the depthFirstSearch() is a method of the Node class, each Node instance is going to have
the method and the method can access the calling node's name and its children nodes with this.
In addition, since the graph is acyclic and tree-like, meaning it is directed and all the nodes
except the root node has only one parent, there is no need to use a data structure to keep
track of the nodes that have been visited. The depthFirstSearch() method is going to grab
the calling node's name and append it to the input array; then it would loop through the calling
node's children, at each child node, it is going to call the child node's depthFirstSearch()
method passing in the input array; lastly it would return the input array.

Time & Space Complexity
O(v+e) time | O(v) space, where v is the number of nodes(vertices) in the input graph and
e is the number of edges in the input graph.

The time complexity of DFS is O(|V| + |E|) when the graph is represented as an adjacency list.
The total time of DFS is number of subproblems * time per subproblem, in other words,
we can get the total time of DFS by summing up all of the subproblems' time.
Since we visit each vertex v once, the number of subproblems is equal to the number of
vertices in the graph. Therefore we can write:

total time = ∑v ∈ V(time for subproblem)

At each vertex v, we mark v as visited(in our problem, we append v's name to an array),
loop over its adjacent vertices and invoke the recursive function on each adjacent vertex.
Let mv denotes the number of edges coming out of the vertex v. The time for subproblem is 1 + mv.
Therefore,total time = ∑v ∈ V(1 + mv) = |V| + ∑v ∈ Vmv

In a directed graph, ∑v ∈ Vmv is equal to |E|, whereas in an undirected graph, we have ∑v ∈ Vmv = 2|E|.
Thus the time complexity of DFS is O(|V| + |E|).

Reference: Verifying DFS complexity for directed and un-directed graph

 */

import java.util.ArrayList;
import java.util.List;

public class DepthFirstSearch {
    static class Node {
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

        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for (int i = 0; i < children.size(); i++) {
                children.get(i).depthFirstSearch(array);
            }
            return array;
        }
    }
}
