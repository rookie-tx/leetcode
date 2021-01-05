/**
 * 6. Z 字形变换
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *       LCIRETOESIIGEDHN
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * @author rookie-tx
 * @version 1.0.0 2021/1/5
 */
public class No0006 {

    public String convert(String s, int numRows) {
        if (s == null || s.length() <= numRows) {
            return s;
        }

        int len = numRows == 1 ? 1 : numRows * 2 - 2;
        int col = s.length() % len == 0 ? s.length() / len : s.length() / len + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < col; j++) {
                int index = j * len + i;
                if (index < s.length()) {
                    sb.append(s.charAt(index));
                }

                if (i != 0 && i != numRows - 1) {
                    if (j * len + len - i < s.length()) {
                        sb.append(s.charAt(j * len + len - i));
                    }
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        No0006 no0006 = new No0006();
        System.out.println(no0006.convert("A", 1));
    }
}
