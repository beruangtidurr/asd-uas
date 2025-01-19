import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        // Example array
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        System.out.println("Original array: " + Arrays.toString(arr));
        
        // Find the maximum number to know number of digits
        int max = Arrays.stream(arr).max().getAsInt();
        
        // Count number of digits in max number
        int d = String.valueOf(max).length();
        
        // Call radix sort
        radixSort(arr, d);
        
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }
    
    // Main radix sort function following the pseudocode
    public static void radixSort(int[] A, int d) {
        for (int i = 1; i <= d; i++) {
            // Use counting sort as the stable sort for each digit
            countingSortByDigit(A, i);
        }
    }
    
    // Counting sort modified to sort by specific digit
    private static void countingSortByDigit(int[] arr, int digit) {
        int n = arr.length;
        int[] output = new int[n];
        
        // Count array for digits 0-9
        int[] count = new int[10];
        Arrays.fill(count, 0);
        
        // Calculate divisor to get the desired digit
        // For example, digit=1 means divisor=1 (ones place)
        // digit=2 means divisor=10 (tens place)
        int divisor = (int) Math.pow(10, digit - 1);
        
        // Store count of occurrences of each digit
        for (int i = 0; i < n; i++) {
            int currentDigit = (arr[i] / divisor) % 10;
            count[currentDigit]++;
        }
        
        // Modify count array to contain actual positions
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        
        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            int currentDigit = (arr[i] / divisor) % 10;
            output[count[currentDigit] - 1] = arr[i];
            count[currentDigit]--;
        }
        
        // Copy the output array to original array
        System.arraycopy(output, 0, arr, 0, n);
    }
}