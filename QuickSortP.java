import java.util.Scanner;

public class QuickSortP {
    public static void main(String[] args) {
        Scanner dt = new Scanner(System.in);

        int size = dt.nextInt();

        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = dt.nextInt();
        }

        quickSort(arr, 0, size -1);

        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void quickSort(int[] arr, int p , int r){
        if(p < r){
            int q = lomuto(arr, p, r);
            quickSort(arr, p, q -1);
            quickSort(arr, q + 1, r);
        }
    }

    public static int lomuto(int[] arr, int p, int r){
        int x = arr[r];
        int i = p - 1;
        for(int j = p; j < r; j++){
            if(arr[j] <= x){
                i+=1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i+=1;
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;
        return i;
    }

    public static int lomutoPartition(int[] arr, int left, int right){
        int pivot = arr[right];
        int i = left -1;
        for(int j = left; j < right; j++){
            if(arr[j] <= pivot){
                i += 1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
 
        i += 1;
        int temp = arr[i];
        arr[i] = arr[right];
        arr[right] = temp;
        return i;
    }
}
