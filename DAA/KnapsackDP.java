import java.util.*;

public class KnapsackDP {

    // Function to compute maximum profit using Dynamic Programming
    static int knapsackDP(List<Integer> weights, List<Integer> profits, int capacity) {
        int n = weights.size();
        int[][] dp = new int[n + 1][capacity + 1];

        // Build DP table
        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= capacity; w++) {
                if (weights.get(i - 1) <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w],
                            profits.get(i - 1) + dp[i - 1][w - weights.get(i - 1)]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacity];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        List<Integer> weights = new ArrayList<>();
        List<Integer> profits = new ArrayList<>();

        System.out.println("Enter weight and profit of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " -> Weight: ");
            weights.add(sc.nextInt());
            System.out.print("           Profit: ");
            profits.add(sc.nextInt());
        }

        System.out.print("Enter capacity of knapsack: ");
        int capacity = sc.nextInt();

        int maxProfit = knapsackDP(weights, profits, capacity);

        System.out.println("\nMaximum Profit (0-1 Knapsack): " + maxProfit);

        sc.close();
    }
}
