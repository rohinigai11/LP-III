#include <iostream>
using namespace std;

int fibonacci_recursive(int n) {
    if (n <= 1)
        return n;
    return fibonacci_recursive(n - 1) + fibonacci_recursive(n - 2);
}


void fibonacci_iterative(int n) {
    int a = 0, b = 1, c;

    cout << "\nFibonacci Series (Iterative): ";
    if (n >= 1) cout << a << " ";
    if (n >= 2) cout << b << " ";

    for (int i = 2; i < n; i++) {
        c = a + b;
        cout << c << " ";
        a = b;
        b = c;
    }
}


int main() {
    int n;

    cout << "Enter number of terms: ";
    cin >> n;

    // ----- Non-Recursive (Iterative) Approach -----
    fibonacci_iterative(n);

    // ----- Recursive Approach -----
    cout << "\nFibonacci Series (Recursive): ";
    for (int i = 0; i < n; i++) {
        cout << fibonacci_recursive(i) << " ";
    }

    return 0;
}
