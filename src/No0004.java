import java.util.HashSet;
import java.util.Set;

/**
 * 寻找两个正序数组的中位数
 *
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 *
 * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 *
 * 示例 1：
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * 示例 2：
 * 输入：nums1 = [1,2], nums2 = [3,4]
 * 输出：2.50000
 * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
 *
 * 示例 3：
 * 输入：nums1 = [0,0], nums2 = [0,0]
 * 输出：0.00000
 *
 * 示例 4：
 * 输入：nums1 = [], nums2 = [1]
 * 输出：1.00000
 *
 * 示例 5：
 * 输入：nums1 = [2], nums2 = []
 * 输出：2.00000
 *
 * 提示：
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 *
 * @author rookie-tx
 * @version 1.0.0 2021/1/4
 */
public class No0004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        Set<Integer> targetIndex = new HashSet<>(2);
        targetIndex.add(length / 2);
        if (length % 2 == 0) {
            targetIndex.add(length / 2 + 1);
        }

        int n = 0, m = 0, index = 0;
        int result = 0;
        while (n < nums1.length || m < nums2.length) {
            int n1 = n < nums1.length ? nums1[n] : Integer.MAX_VALUE;
            int m1 = m < nums2.length ? nums2[m] : Integer.MAX_VALUE;
            if (targetIndex.contains(index)) {
                result += Math.min(n1, m1);
            }

            if (n1 > m1) {
                m++;
            } else {
                n++;
            }

            index++;
        }

        return result / (double) targetIndex.size();
    }

    public static void main(String[] args) {
        No0004 no0004 = new No0004();
        System.out.println(no0004.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}
