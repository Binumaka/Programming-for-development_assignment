package Question_5;

import java.util.*;

public class Q_B {

    public static List<Integer> findImpactedDevices(int[][] edges, int targetDevice) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
        }

        List<Integer> impactedDevices = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(targetDevice);
        visited.add(targetDevice);

        while (!queue.isEmpty()) {
            int currentDevice = queue.poll();
            List<Integer> neighbors = graph.getOrDefault(currentDevice, Collections.emptyList());
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor) && neighbor != targetDevice) {
                    visited.add(neighbor);
                    impactedDevices.add(neighbor);
                    queue.offer(neighbor);
                }
            }
        }

        return impactedDevices;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 6}, {2, 4}, {4, 6}, {4, 5}, {5, 7}};
        int targetDevice = 4;
        
        List<Integer> impactedDevices = findImpactedDevices(edges, targetDevice);
        System.out.println("Impacted Device List: " + impactedDevices); // Output: [5, 7]
    }
}
