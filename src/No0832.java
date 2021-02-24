import java.util.Arrays;

/**
 * 给定一个二进制矩阵A，我们想先水平翻转图像，然后反转图像并返回结果。
 *
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转[1, 1, 0]的结果是[0, 1, 1]。
 *
 * 反转图片的意思是图片中的0全部被1替换，1全部被0替换。例如，反转[0, 1, 1]的结果是[1, 0, 0]。
 *
 * 示例 1：
 *
 * 输入：[[1,1,0],[1,0,1],[0,0,0]]
 * 输出：[[1,0,0],[0,1,0],[1,1,1]]
 * 解释：首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 * 示例 2：
 *
 * 输入：[[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出：[[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释：首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 *
 * 提示：
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j]<=1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipping-an-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author rookie-tx
 * @version 1.0.0 2021/2/24
 */
public class No0832 {

    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0) {
            return new int[][]{};
        }

        for (int row = 0; row < A.length; row++) {
            int left = 0, right = A[row].length - 1;
            while (left < right) {
                A[row][left] = A[row][left] == 0 ? 1 : 0;
                A[row][right] = A[row][right] == 0 ? 1 : 0;

                int temp = A[row][left];
                A[row][left] = A[row][right];
                A[row][right] = temp;

                left++;
                right--;
            }

            if (left == right) {
                A[row][left] = A[row][left] == 0 ? 1 : 0;
            }
        }

        return A;
    }

    public static void main(String[] args) {
        No0832 no0832 = new No0832();
        int[][] test1 = no0832.flipAndInvertImage(new int[][]{
                {1, 1, 0},
                {1, 0, 1},
                {0, 0, 0}
        });

        int[][] test2 = no0832.flipAndInvertImage(new int[][]{
                {1, 1, 0, 0},
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 1, 0}
        });

        for (int[] ints : test1) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println();

        for (int[] ints: test2) {
            System.out.println(Arrays.toString(ints));
        }
    }
}