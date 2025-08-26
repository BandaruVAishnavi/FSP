package org.example;

import java.util.*;

public class DSADriver {
    public static void main(String[] args) {
        DSATemplates dsa = new DSATemplates();

        // 1️⃣ Two Pointers
        System.out.println("Is Palindrome (racecar): " + dsa.isPalindrome("racecar"));

        // 2️⃣ Sliding Window
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Max Sum Subarray (k=3): " + dsa.maxSumSubarray(arr, 3));

        // 3️⃣ Fast & Slow Pointers
        DSATemplates.ListNode n1 = dsa.new ListNode(1);
        DSATemplates.ListNode n2 = dsa.new ListNode(2);
        DSATemplates.ListNode n3 = dsa.new ListNode(3);
        n1.next = n2; n2.next = n3; n3.next = n1; // cycle
        System.out.println("Has Cycle: " + dsa.hasCycle(n1));

        // 4️⃣ Merge Intervals
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merged = dsa.mergeIntervals(intervals);
        System.out.print("Merged Intervals: ");
        for (int[] in : merged) System.out.print(Arrays.toString(in) + " ");
        System.out.println();

        // 5️⃣ Binary Search
        int[] sortedArr = {1, 3, 5, 7, 9};
        System.out.println("Binary Search (target=5): Index = " + dsa.binarySearch(sortedArr, 5));

        // 6️⃣ Dynamic Programming
        System.out.println("Climb Stairs (n=5): " + dsa.climbStairs(5));

        // 7️⃣ Graph BFS
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3));
        graph.put(2, Arrays.asList(4));
        System.out.print("Graph BFS (start=0): ");
        dsa.bfs(0, graph);
        System.out.println();

        // 8️⃣ Graph DFS
        System.out.print("Graph DFS (start=0): ");
        dsa.dfs(0, graph, new HashSet<>());
        System.out.println();

        // 9️⃣ Union-Find
        DSATemplates.UnionFind uf = dsa.new UnionFind(5);
        uf.union(0, 1);
        uf.union(1, 2);
        System.out.println("UnionFind: Are 0 and 2 connected? " + (uf.find(0) == uf.find(2)));

        // 🔟 Backtracking
        System.out.println("Subsets of [1,2]: " + dsa.subsets(new int[]{1, 2}));

        // 1️⃣1️⃣ Monotonic Stack
        int[] nge = dsa.nextGreaterElement(new int[]{2,1,2,4,3});
        System.out.println("Next Greater Elements: " + Arrays.toString(nge));

        // 1️⃣2️⃣ Matrix DFS
        int[][] grid = {
                {1,1,0},
                {1,0,1},
                {0,1,1}
        };
        boolean[][] visited = new boolean[3][3];
        System.out.print("Matrix DFS from (0,0): ");
        dsa.dfsMatrix(grid, 0, 0, visited);
        System.out.println("Visited Matrix = ");
        for (boolean[] row : visited) {
            System.out.println(Arrays.toString(row));
        }
    }
}
