import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int countI = Integer.bitCount(arr[i]);
                int countJ = Integer.bitCount(arr[j]);
                
                if (countI > countJ || 
                   (countI == countJ && arr[i] > arr[j])) {
                    
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}