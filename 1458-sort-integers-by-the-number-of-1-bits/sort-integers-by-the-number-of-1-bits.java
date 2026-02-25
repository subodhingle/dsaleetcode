import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(nums, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            if (countA == countB) {
                return a - b;
            }
            return countA - countB;
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }
}



