public class Solution {
    public int binaryGap(int n) {
        int maxDistance = 0;
        int previousIndex = -1;
        int currentIndex = 0;

        while (n > 0) {
            if ((n & 1) == 1) {  
                if (previousIndex != -1) {
                    maxDistance = Math.max(maxDistance, currentIndex - previousIndex);
                }
                previousIndex = currentIndex;
            }
            n >>= 1;  
            currentIndex++;
        }

        return maxDistance;
    }
}