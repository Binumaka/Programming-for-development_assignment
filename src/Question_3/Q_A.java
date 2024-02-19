package Question_3;

import java.util.*;

// Class to track scores and calculate the median dynamically
class ScoreTracker {
    PriorityQueue<Double> maxHeap; // MaxHeap to store the lower half of elements
    PriorityQueue<Double> minHeap; // MinHeap to store the higher half of elements

    // Constructor to initialize the two heaps
    public ScoreTracker() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    // Method to add a score and balance the heaps
    public void addScore(double score) {
        if (maxHeap.isEmpty() || score <= maxHeap.peek()) {
            maxHeap.offer(score); // Add score to the maxHeap if it is less than or equal to the root
        } else {
            minHeap.offer(score); // Add score to the minHeap if it is greater than the root
        }

        // Balance the heaps if necessary
        if (maxHeap.size() > minHeap.size() + 1) {
            minHeap.offer(maxHeap.poll());
        } else if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // Method to calculate and return the median score
    public double getMedianScore() {
        if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0; // If the sizes are equal, return the average of roots
        } else {
            return maxHeap.peek(); // Otherwise, return the root of the maxHeap
        }
    }
}

public class Q_A {
    public static void main(String[] args) {
        ScoreTracker scoreTracker = new ScoreTracker(); // Create an instance of ScoreTracker

        // Add scores to the tracker
        scoreTracker.addScore(85.5);
        scoreTracker.addScore(92.3);
        scoreTracker.addScore(77.8);
        scoreTracker.addScore(90.1);

        // Get and print the median score
        double median1 = scoreTracker.getMedianScore();
        System.out.println("Median 1: " + median1);

        // Add more scores
        scoreTracker.addScore(81.2);
        scoreTracker.addScore(88.7);

        // Get and print the updated median score
        double median2 = scoreTracker.getMedianScore();
        System.out.println("Median 2: " + median2);
    }
}
