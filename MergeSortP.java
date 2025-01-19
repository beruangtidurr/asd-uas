import java.util.Scanner;

public class MergeSortP{
    public static void main(String[] args) {
        Scanner dt = new Scanner(System.in);

        int size = dt.nextInt();

        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = dt.nextInt();
        }

        MergeSort(arr, 0, size -1);

        for(int i = 0; i < size; i++){
            System.out.print(arr[i] + " ");
        }
    }   

    public static void merge(int[]arr, int p, int q, int r){
        int nLeft = q - p + 1;
        int nRight = r - q;

        int[] arrL = new int[nLeft + 1];
        int[] arrR = new int[nRight + 1];

        arrL[nLeft] = Integer.MAX_VALUE;
        arrR[nRight] = Integer.MAX_VALUE;
 
        System.arraycopy(arr, p, arrL, 0, nLeft);
        System.arraycopy(arr, q + 1, arrR, 0, nRight);

        int i = 0; 
        int j = 0;

        for(int k  = p; k <= r; k++){
            if(arrL[i] <= arrR[j]){
                arr[k] = arrL[i];
                i++;
            } else {
                arr[k] = arrR[j];
                j++;
            }
        }
    }

    public static void MergeSort(int[] arr, int p , int r){
        if(p < r){
            int q = (p + r) / 2;
            MergeSort(arr, p, q);
            MergeSort(arr, q +1, r);
            merge(arr, p, q,r);
        } 
    }
}