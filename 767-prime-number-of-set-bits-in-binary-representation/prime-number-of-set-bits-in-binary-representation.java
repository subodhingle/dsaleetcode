class Solution {
    public int countPrimeSetBits(int left, int right) {
        
        boolean[] isPrime = new boolean[21];
        isPrime[2] = true;
        isPrime[3] = true;
        isPrime[5] = true;
        isPrime[7] = true;
        isPrime[11] = true;
        isPrime[13] = true;
        isPrime[17] = true;
        isPrime[19] = true;

        int count = 0;

        for (int i = left; i <= right; i++) {
            int setBits = Integer.bitCount(i);
            if (isPrime[setBits]) {
                count++;
            }
        }

        return count;
    }
}