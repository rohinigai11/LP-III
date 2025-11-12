import java.util.*;

class Item {
    float weight;
    float profit;

    Item(float weight, float profit) {
        this.weight = weight;
        this.profit = profit;
    }
}

public class FractionalKnapsack {

    // Comparator to sort items by profit/weight ratio in descending order
    static class Compare implements Comparator<Item> {
        public int compare(Item a, Item b) {
            float r1 = a.profit / a.weight;
            float r2 = b.profit / b.weight;
            return Float.compare(r2, r1); // Descending order
        }
    }

    // Function to calculate maximum profit using Greedy approach
    static float fractionalKnapsack(List<Item> items, float capacity) {

        // Step 1: Sort items by profit/weight ratio
        Collections.sort(items, new Compare());

        float totalProfit = 0.0f;

        // Step 2: Pick items in sorted order
        for (Item item : items) {
            if (capacity == 0) break; // Knapsack full

            if (item.weight <= capacity) {
                // Take whole item
                totalProfit += item.profit;
                capacity -= item.weight;
            } else {
                // Take fractional part
                float fraction = capacity / item.weight;
                totalProfit += item.profit * fraction;
                capacity = 0; // Knapsack full
            }
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        List<Item> items = new ArrayList<>();

        System.out.println("Enter weight and profit of each item:");
        for (int i = 0; i < n; i++) {
            System.out.print("Item " + (i + 1) + " -> Weight: ");
            float weight = sc.nextFloat();
            System.out.print("           Profit: ");
            float profit = sc.nextFloat();
            items.add(new Item(weight, profit));
        }

        System.out.print("Enter capacity of knapsack: ");
        float capacity = sc.nextFloat();

        float maxProfit = fractionalKnapsack(items, capacity);

        System.out.println("\nMaximum Profit (Greedy): " + maxProfit);

        sc.close();
    }
}
