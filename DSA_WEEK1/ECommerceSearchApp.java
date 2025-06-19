import java.util.Arrays;
import java.util.Comparator;

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return "[" + productId + "] " + productName + " - " + category;
    }
}

class SearchService {

    // 🔍 Linear Search - O(n)
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    // 🔍 Binary Search - O(log n)
    public static Product binarySearch(Product[] products, String name) {
        // Binary search requires the array to be sorted
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));

        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = name.compareToIgnoreCase(products[mid].productName);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) right = mid - 1;
            else left = mid + 1;
        }
        return null;
    }
}

public class ECommerceSearchApp {

 
    public static void explainBigONotation() {
        System.out.println("========== Big O Notation ==========");
        System.out.println("Big O describes how the performance of an algorithm changes with input size (n).");
        System.out.println("Linear Search: O(n) - Check each item one by one.");
        System.out.println("Binary Search: O(log n) - Split the list in half each time (needs sorted data).");
        System.out.println("Best Case (both): O(1) - Item found at the start.");
        System.out.println("Average Case:");
        System.out.println("  - Linear: O(n)");
        System.out.println("  - Binary: O(log n)");
        System.out.println("Worst Case:");
        System.out.println("  - Linear: O(n)");
        System.out.println("  - Binary: O(log n)");
        System.out.println("====================================\n");
    }

    public static void main(String[] args) {
        explainBigONotation();

        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Shoes", "Footwear"),
            new Product(104, "Watch", "Accessories"),
            new Product(105, "Tablet", "Electronics")
        };

        System.out.println("===== Linear Search =====");
        Product result1 = SearchService.linearSearch(products, "Phone");
        System.out.println(result1 != null ? "Found: " + result1 : "Product not found");

        System.out.println("\n===== Binary Search =====");
        Product result2 = SearchService.binarySearch(products, "Phone");
        System.out.println(result2 != null ? "Found: " + result2 : "Product not found");

        System.out.println("\n===== Analysis =====");
        System.out.println("Linear Search:");
        System.out.println("  - Time Complexity: O(n)");
        System.out.println("  - Best when list is small or unsorted.");

        System.out.println("Binary Search:");
        System.out.println("  - Time Complexity: O(log n)");
        System.out.println("  - Best when list is large and sorted.");

        System.out.println("\n✅ Recommendation:");
        System.out.println("Use Binary Search for large datasets (sorted), and Linear Search for small or unsorted lists.");
    }
}
