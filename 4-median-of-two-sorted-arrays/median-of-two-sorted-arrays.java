class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //subodhingle
        // Ensure nums1 is smaller
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length;
        int n = nums2.length;

        int low = 0, high = m;

        while (low <= high) {
            
            int i = (low + high) / 2;
            int j = (m + n + 1) / 2 - i;

            int nums1Left = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int nums1Right = (i == m) ? Integer.MAX_VALUE : nums1[i];

            int nums2Left = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int nums2Right = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (nums1Left <= nums2Right && nums2Left <= nums1Right) {

                // If total length is even
                if ((m + n) % 2 == 0) {
                    return (Math.max(nums1Left, nums2Left) + 
                            Math.min(nums1Right, nums2Right)) / 2.0;
                } 
                // If total length is odd
                else {
                    return Math.max(nums1Left, nums2Left);
                }
            }
            else if (nums1Left > nums2Right) {
                high = i - 1; // move left
            }
            else {
                low = i + 1; // move right
            }
        }

        throw new IllegalArgumentException();
    }
}