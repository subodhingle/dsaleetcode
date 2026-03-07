class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String t = s + s;

        int alt1 = 0;
        int alt2 = 0;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < t.length(); i++) {

            char e1 = (i % 2 == 0) ? '0' : '1';
            char e2 = (i % 2 == 0) ? '1' : '0';

            if (t.charAt(i) != e1) alt1++;
            if (t.charAt(i) != e2) alt2++;

            if (i >= n) {
                char p1 = ((i - n) % 2 == 0) ? '0' : '1';
                char p2 = ((i - n) % 2 == 0) ? '1' : '0';

                if (t.charAt(i - n) != p1) alt1--;
                if (t.charAt(i - n) != p2) alt2--;
            }

            if (i >= n - 1) {
                ans = Math.min(ans, Math.min(alt1, alt2));
            }
        }

        return ans;
    }
}