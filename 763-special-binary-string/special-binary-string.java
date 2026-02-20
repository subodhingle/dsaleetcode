import java.util.*;

class Solution {
    public String makeLargestSpecial(String s) {
        List<String> list = new ArrayList<>();
        int count = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            count += s.charAt(i) == '1' ? 1 : -1;
            if (count == 0) {
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                list.add("1" + inner + "0");
                start = i + 1;
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder result = new StringBuilder();
        for (String str : list) {
            result.append(str);
        }
        return result.toString();
    }
}