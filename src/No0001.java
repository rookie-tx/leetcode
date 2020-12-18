import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * 给定一个整数数组 nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author rookie-tx
 * @version 1.0.0 2020/12/18
 */
public class No0001 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> cache = new HashMap<>(4);
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (cache.containsKey(num)) {
                return new int[] {cache.get(num), i};
            } else {
                cache.put(nums[i], i);
            }
        }

        return null;
    }

    public static void main(String[] args) {
        No0001 no0001 = new No0001();
        System.out.println(Arrays.toString(no0001.twoSum(new int[]{2, 3, 4, 5, 6, 7}, 7)));
    }
}
