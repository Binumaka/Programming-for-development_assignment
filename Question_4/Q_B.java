package Question_4;

import java.util.ArrayList;
import java.util.List;

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

public class Q_B {
    public List<Integer> closestValues(TreeNode root, double target, int x) {
        List<Integer> closestValues = new ArrayList<>();
        closestValuesHelper(root, target, x, closestValues);
        return closestValues;
    }

    private void closestValuesHelper(TreeNode node, double target, int x, List<Integer> closestValues) {
        if (node == null) {
            return;
        }

        // Traverse left subtree
        closestValuesHelper(node.left, target, x, closestValues);

        // Check if the current node's value is closer to the target
        if (closestValues.size() < x) {
            closestValues.add(node.val);
        } else {
            double diff1 = Math.abs(target - node.val);
            double diff2 = Math.abs(target - closestValues.get(0));
            if (diff1 < diff2) {
                closestValues.remove(0);
                closestValues.add(node.val);
            } else {
                return; // Values already collected and sorted
            }
        }

        // Traverse right subtree
        closestValuesHelper(node.right, target, x, closestValues);
    }

    public static void main(String[] args) {
        // Example usage
        Q_B solution = new Q_B();

        // Create the binary search tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);

        // Find closest values to target 3.8, with x = 2
        List<Integer> closest = solution.closestValues(root, 3.8, 2);
        System.out.println("Closest values to 3.8: " + closest); 
    }
}

