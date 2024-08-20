import java.util.HashSet;
import java.util.Set;

/**
 * 最小覆盖子串
 *
 * @Author: Xiaov
 * @Date: 2024/8/20 04:10
 */
public class Problem012 {
    // 滑动窗口思路
    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] count = new int[128];
        Set<Character> tSet = new HashSet<>();
        int differ = 0;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            count[ch - 'A']--;
            if (!tSet.contains(ch)) {
                tSet.add(ch);
                differ++;
            }
        }

        int right = 0;
        int left = 0;
        int resLen = Integer.MAX_VALUE;
        String resStr = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (count[ch - 'A'] == -1){
                differ--;
            }
            count[ch - 'A']++;
            if (differ == 0){
                right = i;
                while (!tSet.contains(s.charAt(left)) || count[s.charAt(left) - 'A'] - 1 >= 0) {
                    count[s.charAt(left) - 'A']--;
                    left++;
                }
                String tmpStr = s.substring(left, right + 1);
                resStr = resLen > tmpStr.length() ? tmpStr : resStr;
                resLen = resStr.length();

                // 计算了一次的最小串之后，要将left+1算下一个
                count[s.charAt(left) - 'A']--;
                left++;
                differ++;
            }
        }
        return resStr;
    }

    public static void main(String[] args) {
        String res = minWindow("cabwefgewcwaefgcf", "cae");
        System.out.println("res = " + res);
    }
}
