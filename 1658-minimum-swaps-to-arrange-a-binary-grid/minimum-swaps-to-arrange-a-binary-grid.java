class Solution {

    public int minSwaps(int[][] grid) {

        int n = grid.length;
        int[] zerosAtEnd = new int[n];
        // count trailing zeros for each row
        for (int row = 0; row < n; row++) {
            int count = 0;
            for (int col = n - 1; col >= 0; col--) {
                if (grid[row][col] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            zerosAtEnd[row] = count;
        }
        int totalSwaps = 0;
        for (int i = 0; i < n; i++) {
            int neededZeros = n - i - 1;
            int index = -1;
            // find a suitable row
            for (int j = i; j < n; j++) {
                if (zerosAtEnd[j] >= neededZeros) {
                    index = j;
                    break;
                }
            }

            if (index == -1) {
                return -1;
            }

            // move that row upward using adjacent swaps
            while (index > i) {
                int temp = zerosAtEnd[index];
                zerosAtEnd[index] = zerosAtEnd[index - 1];
                zerosAtEnd[index - 1] = temp;

                totalSwaps++;
                index--;
            }
        }
        return totalSwaps;
    }
}