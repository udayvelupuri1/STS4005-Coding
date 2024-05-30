package Sorting;
import java.util.*;
public class SelectionSort {
    static void sort(int arr[],int n){
        for(int i=0;i<n;i++){
            int minIndex = i;
            for(int j=0;j<n;j++){
                if(arr[j]> arr[minIndex]){
                    minIndex =j;
                }
            }
            int temp = arr[minIndex]; //storing min element
            arr[minIndex] = arr[i]; // swapping
            arr[i] = temp; //assigning min to ith index;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sort(arr,n);
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+ " ");
        }
    }
}
