package leetcode;

/**
 * @className:Problem2
 * @author:huanglf714
 * @create:2019/7/30 10:01
 * @decription:汉明距离
 * 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *
 * 给出两个整数 x 和 y，计算它们之间的汉明距离。
 *
 * 注意：
 * 0 ≤ x, y < 231.
 *
 * 示例:
 *
 * 输入: x = 1, y = 4
 *
 * 输出: 2
 *
 * 解释:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ↑   ↑
 *
 * 上面的箭头指出了对应二进制位不同的位置。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/hamming-distance
 *
 *
 * 解题思路：用异或求出x^y的值，然后用位运算判断这个值的二进位表示中中有几个1
 **/
public class Problem2 {
    public int hammingDistance(int x, int y) {
        int result = x^y;
        int count = 0;
        while(result!=0){
            if((result&1)==1){
                count++;
            }
            result >>>= 1;
        }
        return count;
    }
}
