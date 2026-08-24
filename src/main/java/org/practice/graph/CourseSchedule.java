package org.practice.graph;

import java.util.*;

class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> adj = new ArrayList<>();
        // Array to store the in-degree (number of incoming prerequisites) for each course
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build the graph and calculate in-degrees
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int pre = pair[1];
            adj.get(pre).add(course);
            inDegree[course]++;
        }

        // Queue for courses with 0 in-degree (no prerequisites remaining)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;

            // For every course that depends on the current course
            for (int neighbor : adj.get(current)) {
                inDegree[neighbor]--;
                // If in-degree becomes 0, all prerequisites are met
                if (inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }


        // If the number of finished courses equals numCourses, it's possible
        return count == numCourses;
    }


}