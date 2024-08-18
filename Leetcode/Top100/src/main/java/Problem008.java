import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * @Author: Xiaov
 * @Date: 2024/8/19 02:27
 */
public class Problem008 {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int left = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charIndexMap.containsKey(s.charAt(i)) && charIndexMap.get(s.charAt(i)) >= 0) {
                while (left < i && left <= charIndexMap.get(s.charAt(i))) {
                    charIndexMap.put(s.charAt(left), -1);
                    left++;
                }
            }else {
                res = Math.max(res, i - left + 1);
            }
            charIndexMap.put(s.charAt(i), i);
        }
        return res;
    }

    public static int lengthOfLongestSubstringFunc2(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int left = -1;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charIndexMap.containsKey(s.charAt(i)) ) {
                left = Math.max(left, charIndexMap.get(s.charAt(i)));
            }
            charIndexMap.put(s.charAt(i), i);
            res = Math.max(res, i - left);
        }
        return res;
    }

    // dp
    public static int lengthOfLongestSubstringFunc3(String s) {
        if (s.length() == 0) return 0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        int leftMaxSize = 0;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int leftCharIndex = charIndexMap.getOrDefault(s.charAt(i), -1);
            leftMaxSize = leftMaxSize < i - leftCharIndex ? leftMaxSize + 1 : i - leftCharIndex;
            charIndexMap.put(s.charAt(i), i);
            res = Math.max(res, leftMaxSize);
        }
        return res;
    }




    public static void main(String[] args) {
        String s = "abcabcbb";
        int res = lengthOfLongestSubstring(s);
        System.out.println("res = " + res);
    }
}
