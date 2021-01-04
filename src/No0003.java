import java.util.HashMap;
import java.util.Map;

/**
 * 无重复字符的最长子串
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author rookie-tx
 * @version 1.0.0 2020/12/18
 */
public class No0003 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(16);
        int ans = 0, n = s.length();
        for (int i = 0, j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }

        return ans;
    }

//    public int lengthOfLongestSubstring(String s) {
//
//        int result = 0;
//        int leftIndex = 0, rightIndex = 0;
//        Set<Character> set = new HashSet<>();
//        for ( ; leftIndex < s.length(); leftIndex++) {
//            while (rightIndex < s.length() && !set.contains(s.charAt(rightIndex))) {
//                set.add(s.charAt(rightIndex));
//                rightIndex++;
//            }
//
//            set.remove(s.charAt(leftIndex));
//            result = Math.max(result, rightIndex - leftIndex);
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
        No0003 no0003 = new No0003();
        System.out.println(no0003.lengthOfLongestSubstring(""));
    }
}
