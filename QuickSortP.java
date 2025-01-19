import java.util.Scanner;

public class QuickSortP{
    public static void main(String[] args) {
        Scanner dt = new Scanner(System.in);

        int size = dt.nextInt();

        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = dt.nextInt();
        }

        int[] hasil = new int[size];
        int max = arr[0];

        for(int i = 0; i < size; i++){
            max = Math.max(arr[i], max);
        }

        count(arr, hasil, max);

        for(int i = 0; i < size; i++){
            System.out.print(hasil[i] + " ");
        }
    }

    public static void count(int[] arr, int[] arrB, int k){
        int[] arrC = new int[k + 1];

        for(int i = 0; i <= k; i++){
            arrC[i] = 0;
        }

        for(int j = 0; j < arr.length; j++){
            arrC[arr[j]]++;
        }

        for(int i = 1; i <= k; i++){
            arrC[i] += arrC[i - 1];
        }

        for(int j = arr.length - 1; j >= 0; j--){
            arrB[arrC[arr[j]] - 1] = arr[j];
            arrC[arr[j]] -= 1;
        }
    }

    // public static void countSort(int[] arr){
    //     int max = arr[0];
    //     int n = arr.length;
    //     int i;

    //     for(i = 0; i < n; i++){
    //         max = Math.max(arr[i], max);
    //     }

    //     int[] frek = new int[max + 1];

    //     for(i = 0; i < n; i++){
    //         frek[arr[i]]++;
    //     }

    //     for(i = 1; i <= max; i++){
    //         frek[i] += frek[i-1];
    //     }

    //     int[]hasil = new int[n];

    //     int idx;

    //     for(i = n -1; i >=0; i--){
    //         idx = frek[arr[i]] - 1;
    //         hasil[idx] = arr[i];
    //         frek[arr[i]]--;
    //     }

    //     for(i = 0; i < n; i++){
    //         arr[i] = hasil[i];
    //     }
    // }
}