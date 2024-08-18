import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 找到字符串中所有字母异位词
 *
 * @Author: Xiaov
 * @Date: 2024/8/19 03:39
 */
public class Problem009 {
    public List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if (sLen < pLen) {
            return res;
        }

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        for (int i = 0; i < pLen; i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + pLen) - 'a']++;
            if (Arrays.equals(sCount, pCount)) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public List<Integer> findAnagramsFunc2(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        List<Integer> res = new ArrayList<>();
        if (sLen < pLen) {
            return res;
        }

        int[] count = new int[26];

        for (int i = 0; i < pLen; i++) {
            count[s.charAt(i) - 'a']++;
            count[p.charAt(i) - 'a']--;
        }
        int differ = 0;
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) differ++;
        }
        if (differ == 0) {
            res.add(0);
        }

        for (int i = 0; i < sLen - pLen; i++) {
            if (count[s.charAt(i) - 'a'] == 1) {
                differ--;
            }else if(count[s.charAt(i) - 'a'] == 0) {
                differ++;
            }
            count[s.charAt(i) - 'a']--;

            if (count[s.charAt(i + pLen) - 'a'] == -1) {
                differ--;
            }else if(count[s.charAt(i + pLen) - 'a'] == 0) {
                differ++;
            }
            count[s.charAt(i + pLen) - 'a']++;
            if (differ == 0) {
                res.add(i +1);
            }
        }
        return res;
    }
}
