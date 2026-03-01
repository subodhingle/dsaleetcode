import java.util.ArrayList;
import java.util.List;

class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, 0, 0, "", ans);
        return ans;
    }

    private void solve(int n, int openUsed, int closeUsed, String str, List<String> ans) {

        if (str.length() == 2 * n) {
            ans.add(str);
            return;
        }

        if (openUsed < n) {
            solve(n, openUsed + 1, closeUsed, str + "(", ans);
        }

        if (closeUsed < openUsed) {
            solve(n, openUsed, closeUsed + 1, str + ")", ans);
        }
    }
}