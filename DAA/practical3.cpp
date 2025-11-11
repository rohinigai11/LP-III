#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


struct Item {
    float weight;
    float profit;
};


bool compare(Item a, Item b) {
    float r1 = a.profit / a.weight;
    float r2 = b.profit / b.weight;
    return r1 > r2;  // descending order
}


float fractionalKnapsack(vector<Item> &items, float capacity) {

    // Step 1: Sort items by profit/weight ratio
    sort(items.begin(), items.end(), compare);

    float totalProfit = 0.0f;

    // Step 2: Pick items in sorted order
    for (auto &item : items) {
        if (capacity == 0) break;  // Knapsack full

        if (item.weight <= capacity) {
            // Take whole item
            totalProfit += item.profit;
            capacity -= item.weight;
        } else {
            // Take fractional part
            float fraction = capacity / item.weight;
            totalProfit += item.profit * fraction;
            capacity = 0;  // Knapsack now full
        }
    }

    return totalProfit;
}


int main() {
    int n;
    float capacity;

    cout << "Enter number of items: ";
    cin >> n;

    vector<Item> items(n);

    cout << "Enter weight and profit of each item:\n";
    for (int i = 0; i < n; i++) {
        cout << "Item " << i + 1 << " -> Weight: ";
        cin >> items[i].weight;
        cout << "           Profit: ";
        cin >> items[i].profit;
    }

    cout << "Enter capacity of knapsack: ";
    cin >> capacity;

    float maxProfit = fractionalKnapsack(items, capacity);

    cout << "\nMaximum Profit (Greedy): " << maxProfit << endl;


    return 0;
}
