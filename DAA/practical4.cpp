#include <iostream>
#include <vector>
using namespace std;

int knapsackDP(vector<int> &weights, vector<int> &profits, int capacity) {
    int n = weights.size();
    vector<vector<int>> dp(n + 1, vector<int>(capacity + 1, 0));

    // Build DP table
    for (int i = 1; i <= n; i++) {
        for (int w = 1; w <= capacity; w++) {
            if (weights[i-1] <= w) {
                dp[i][w] = max(dp[i-1][w], profits[i-1] + dp[i-1][w - weights[i-1]]);
            } else {
                dp[i][w] = dp[i-1][w];
            }
        }
    }

    return dp[n][capacity];
}


int main() {
    int n, capacity;

    cout << "Enter number of items: ";
    cin >> n;

    vector<int> weights(n), profits(n);

    cout << "Enter weight and profit of each item:\n";
    for (int i = 0; i < n; i++) {
        cout << "Item " << i+1 << " -> Weight: ";
        cin >> weights[i];
        cout << "           Profit: ";
        cin >> profits[i];
    }

    cout << "Enter capacity of knapsack: ";
    cin >> capacity;

    int maxProfit = knapsackDP(weights, profits, capacity);

    cout << "\nMaximum Profit (0-1 Knapsack): " << maxProfit << endl;

    return 0;
}
