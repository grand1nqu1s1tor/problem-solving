import static java.lang.Math.PI;

public class EstimateZeta2 {

    // Method to estimate Zeta(2)
    public static double estimateZeta2() {
        double trueValue = PI * PI / 6; // True value of ζ(2)
        double sum = 0.0;
        int n = 1;
        double tolerance = 0.00001;

        // Loop until the absolute difference is smaller than the tolerance
        while (Math.abs(trueValue - sum) > tolerance) {  // Correct condition
            sum += 1.0 / Math.pow(n, 2);
            n++;
        }

        // Output the estimated value and number of iterations
        System.out.println("Zeta(2) is estimated as " + sum + " after " + (n - 1) + " iterations");
        return sum;
    }

    // Main method to run the program
    public static void main(String[] args) {
        estimateZeta2();  // Call the estimateZeta2 method
    }
}