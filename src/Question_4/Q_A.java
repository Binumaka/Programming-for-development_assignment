package Question_4;

import java.util.*;

public class Q_A {
    
    // Class to represent a state in the maze
    static class State {
        int x;
        int y;
        int keys;
        
        public State(int x, int y, int keys) {
            this.x = x;
            this.y = y;
            this.keys = keys;
        }
    }
    
    public static int shortestPathAllKeys(String[] grid) {
        int m = grid.length;
        int n = grid[0].length();
        int allKeys = 0;
        
        // Find the starting position and count the number of keys
        int startX = 0, startY = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char cell = grid[i].charAt(j);
                if (cell == 'S') {
                    startX = i;
                    startY = j;
                } else if (cell >= 'a' && cell <= 'f') {
                    allKeys |= 1 << (cell - 'a');
                }
            }
        }
        
        // Initialize visited set and queue for BFS
        Set<String> visited = new HashSet<>();
        Queue<State> queue = new LinkedList<>();
        
        // Add the starting state to the queue
        queue.offer(new State(startX, startY, 0));
        visited.add(startX + "," + startY + ",0");
        
        // Directions for movement: up, down, left, right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int steps = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                State state = queue.poll();
                int x = state.x;
                int y = state.y;
                int keys = state.keys;
                
                // Check if all keys are collected
                if (keys == allKeys) {
                    return steps;
                }
                
                // Explore all four directions
                for (int[] dir : dirs) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        char cell = grid[newX].charAt(newY);
                        if (cell == 'W') {
                            continue; // Cannot pass through walls
                        } else if (cell >= 'A' && cell <= 'F' && (keys & (1 << (cell - 'A'))) == 0) {
                            continue; // Need key to unlock the door
                        }
                        
                        int newKeys = keys;
                        if (cell >= 'a' && cell <= 'f') {
                            newKeys |= 1 << (cell - 'a'); // Collect the key
                        }
                        
                        // Add the new state to the queue if not visited
                        String newState = newX + "," + newY + "," + newKeys;
                        if (!visited.contains(newState)) {
                            queue.offer(new State(newX, newY, newKeys));
                            visited.add(newState);
                        }
                    }
                }
            }
            steps++;
        }
        
        return -1; // Cannot collect all keys and reach the exit
    }

    public static void main(String[] args) {
        String[] grid = {"SPPPE", "WPWPW", "bPAPB"};
        int result = shortestPathAllKeys(grid);
        System.out.println("Minimum number of moves: " + result);
    }
}

