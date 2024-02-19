package Question_1;
public class Q_A {

    public static int minCostToDecorateVenues(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length;
        int k = costs[0].length;

        // Initialize a 2D dp array to store the minimum cost
        int[][] dp = new int[n][k];

        // Initialize the first row with the costs of decorating the first venue
        System.arraycopy(costs[0], 0, dp[0], 0, k);

        // Iterate through the venues and calculate the minimum cost
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                // Calculate the minimum cost for each theme, considering the adjacency constraint
                dp[i][j] = costs[i][j] + min(dp[i - 1], j);
            }
        }

        // Return the minimum cost from the last row
        return min(dp[n - 1]);
    }

    private static int min(int[] arr, int excludeIndex) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (i != excludeIndex) {
                min = Math.min(min, arr[i]);
            }
        }
        return min;
    }

    private static int min(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            min = Math.min(min, value);
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] costMatrix = {{1, 3, 2}, {4, 6, 8}, {3, 1, 5}};
        int result = minCostToDecorateVenues(costMatrix);
        System.out.println(result); 
    }
}
