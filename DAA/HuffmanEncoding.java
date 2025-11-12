import java.util.*;

// Node class representing each character and its frequency
class Node {
    char ch;        // Character
    int freq;       // Frequency
    Node left, right;  // Left and right child nodes

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = this.right = null;
    }
}

// Comparator for priority queue (Min-Heap based on frequency)
class Compare implements Comparator<Node> {
    public int compare(Node a, Node b) {
        return a.freq - b.freq;
    }
}

public class HuffmanEncoding {

    // Recursive function to print Huffman Codes
    static void printCodes(Node root, String code) {
        if (root == null)
            return;

        // If leaf node, print character and its code
        if (root.left == null && root.right == null) {
            System.out.println("  " + root.ch + "  :  " + code);
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    // Function to build Huffman Tree and display codes
    static void huffmanEncoding(List<Character> characters, List<Integer> frequency) {
        // Step 1: Create a Min-Heap (Priority Queue)
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Compare());

        // Step 2: Insert all characters into the heap
        for (int i = 0; i < characters.size(); i++) {
            Node newNode = new Node(characters.get(i), frequency.get(i));
            minHeap.add(newNode);
        }

        // Step 3: Combine two smallest nodes until one remains
        while (minHeap.size() > 1) {
            Node left = minHeap.poll();
            Node right = minHeap.poll();

            // Create new internal node with combined frequency
            Node newNode = new Node('$', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;

            minHeap.add(newNode);
        }

        // Step 4: Root of the heap is the root of Huffman Tree
        Node root = minHeap.peek();

        System.out.println("\nHuffman Codes:");
        System.out.println("--------------------");
        printCodes(root, "");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        List<Character> characters = new ArrayList<>();
        List<Integer> frequency = new ArrayList<>();

        System.out.println("Enter characters:");
        for (int i = 0; i < n; i++) {
            characters.add(sc.next().charAt(0));
        }

        System.out.println("Enter corresponding frequencies:");
        for (int i = 0; i < n; i++) {
            frequency.add(sc.nextInt());
        }

        // Call Huffman Encoding
        huffmanEncoding(characters, frequency);

        sc.close();
    }
}
