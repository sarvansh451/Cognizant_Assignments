public class FinancialForecasting {

    public static void explainRecursion() {
        System.out.println("========== Recursion Explained ==========");
        System.out.println("Recursion is when a method calls itself to solve smaller sub-problems.");
        System.out.println("It's useful when a problem can be broken into smaller repetitive steps.");
        System.out.println("Example: futureValue(n) = futureValue(n-1) * (1 + growthRate)");
        System.out.println("=========================================\n");
    }

    public static double forecastRecursive(int years, double currentValue, double growthRate) {
        if (years == 0) return currentValue;
        return forecastRecursive(years - 1, currentValue, growthRate) * (1 + growthRate);
    }

    public static double forecastMemoized(int years, double currentValue, double growthRate, double[] memo) {
        if (years == 0) return currentValue;
        if (memo[years] != 0) return memo[years];
        memo[years] = forecastMemoized(years - 1, currentValue, growthRate, memo) * (1 + growthRate);
        return memo[years];
    }

    public static void explainTimeComplexity() {
        System.out.println("========== Time Complexity ==========");
        System.out.println("Naive Recursion: O(n) time and O(n) stack space.");
        System.out.println("Memoization: O(n) time and O(n) space. Avoids repeated calculations.");
        System.out.println("=====================================\n");
    }

    public static void main(String[] args) {
        explainRecursion();

        double currentValue = 1000;
        double growthRate = 0.1;
        int years = 5;

        double resultRecursive = forecastRecursive(years, currentValue, growthRate);
        System.out.println("📊 Future Value (Recursive): " + resultRecursive);

        double[] memo = new double[years + 1];
        double resultMemoized = forecastMemoized(years, currentValue, growthRate, memo);
        System.out.println("📈 Future Value (Memoized): " + resultMemoized);

        explainTimeComplexity();

        System.out.println("✅ Recommendation:");
        System.out.println("- Use memoization or loops when forecasting for many years (to avoid stack overflow).");
        System.out.println("- Recursion is clean but should be optimized for large inputs.");
    }
}
