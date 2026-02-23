class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        
        if (n - k + 1 < (1 << k)) {
            return false;
        }
        
        boolean[] seen = new boolean[1 << k];
        int count = 0;
        int num = 0;
        
        for (int i = 0; i < n; i++) {
            num = ((num << 1) & ((1 << k) - 1)) | (s.charAt(i) - '0');
            
            if (i >= k - 1) {
                if (!seen[num]) {
                    seen[num] = true;
                    count++;
                    
                    if (count == (1 << k)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}