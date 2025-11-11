#include <iostream>
#include <queue>
#include <vector>
#include <unordered_map>
using namespace std;


struct Node {
    char ch;                // Character
    int freq;               // Frequency
    Node *left, *right;     // Left and Right child pointers

    Node(char c, int f) {
        ch = c;
        freq = f;
        left = right = nullptr;
    }
};


struct Compare {
    bool operator()(Node* a, Node* b) {
        return a->freq > b->freq;
    }
};


void printCodes(Node* root, string code) {
    if (!root) return;

    // If leaf node, print character and its code
    if (!root->left && !root->right) {
        cout << "  " << root->ch << "  :  " << code << endl;
        return;
    }

    printCodes(root->left, code + "0");
    printCodes(root->right, code + "1");
}


void huffmanEncoding(vector<char> &characters, vector<int> &frequency) {
    // Step 1: Create a Min-Heap (Priority Queue)
    priority_queue<Node*, vector<Node*>, Compare> minHeap;

    // Step 2: Insert all characters into heap
    for (int i = 0; i < characters.size(); i++) {
        Node* newNode = new Node(characters[i], frequency[i]);
        minHeap.push(newNode);
    }

    // Step 3: Combine two smallest nodes until one remains
    while (minHeap.size() > 1) {
        Node* left = minHeap.top(); minHeap.pop();
        Node* right = minHeap.top(); minHeap.pop();

        // Create new internal node with combined frequency
        Node* newNode = new Node('$', left->freq + right->freq);
        newNode->left = left;
        newNode->right = right;

        minHeap.push(newNode);
    }

    // Step 4: Root of the heap is the root of Huffman Tree
    Node* root = minHeap.top();

    cout << "\nHuffman Codes:\n";
    cout << "--------------------\n";
    printCodes(root, "");
}


int main() {
    int n;
    cout << "Enter number of characters: ";
    cin >> n;

    vector<char> characters(n);
    vector<int> frequency(n);

    cout << "Enter characters:\n";
    for (int i = 0; i < n; i++) {
        cin >> characters[i];
    }

    cout << "Enter corresponding frequencies:\n";
    for (int i = 0; i < n; i++) {
        cin >> frequency[i];
    }

    // Call Huffman Encoding
    huffmanEncoding(characters, frequency);



    return 0;
}
