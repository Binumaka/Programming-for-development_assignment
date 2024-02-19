package Question_2;

public class Q_A {

    // Method to calculate the minimum number of moves required to equalize dresses among sewing machines
    public static int minMovesEqualizeDresses(int[] sewingMachines) {
        int totalDresses = 0;
        int n = sewingMachines.length;
        
        // Calculate the total number of dresses in all sewing machines
        for (int dresses : sewingMachines) {
            totalDresses += dresses;
        }

        // Calculate the target number of dresses each machine should have
        int targetDresses = totalDresses / n;

        // Check if equal distribution is possible
        if (totalDresses % n != 0) {
            return -1; // Return -1 if equal distribution is not possible
        }

        int moves = 0;
        int surplus = 0;

        // Calculate surplus (or deficit) dresses on each machine and total moves needed
        for (int dresses : sewingMachines) {
            surplus += dresses - targetDresses;
            moves += Math.abs(surplus);
        }

        return moves / 2; // Return the minimum number of moves required (each move involves two machines)
    }

    public static void main(String[] args) {
        // Input array representing the number of dresses in each sewing machine
        int[] sewingMachines = {1, 0, 5};

        // Calculate the minimum number of moves required and print the result
        int minMoves = minMovesEqualizeDresses(sewingMachines);
        System.out.println("Minimum number of moves required: " + minMoves);
    }
}
