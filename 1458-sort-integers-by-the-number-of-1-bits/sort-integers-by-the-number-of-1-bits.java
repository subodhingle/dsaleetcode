import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        
        Arrays.sort(nums, (a, b) -> {
            int bitCompare = Integer.bitCount(a) - Integer.bitCount(b);
            if (bitCompare == 0) {
                return a - b;
            }
            return bitCompare;
        });
        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        
        return arr;
    }
}