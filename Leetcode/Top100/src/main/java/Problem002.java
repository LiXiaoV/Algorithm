import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

/**
 * 字母异位词分组
 *
 * @Author: Xiaov
 * @Date: 2024/8/8 09:32
 */
public class Problem002 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strCharArray = str.toCharArray();
            Arrays.sort(strCharArray);
            String key = new String(strCharArray);
            List<String> strList = map.getOrDefault(key, new ArrayList<>());
            strList.add(str);
            map.put(key, strList);
        }
        return new ArrayList<>(map.values());
    }

    public List<List<String>> groupAnagramsFunc2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < str.length(); i++) {
                counts[str.charAt(i) - 'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] > 0) {
                    sb.append('a' + i);
                    sb.append(counts[i]);
                }
            }
            List<String> strList = map.getOrDefault(sb.toString(), new ArrayList<>());
            strList.add(str);
            map.put(sb.toString(), strList);
        }
        return new ArrayList<>(map.values());
    }
}
