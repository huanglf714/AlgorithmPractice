package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @className:Problem11
 * @author:huanglf714
 * @create:2019/7/30 19:47
 * @decription:找到消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 *
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Problem11 {
    /**
     * @author:huanglf714
     * @description:将以nums[index]为索引位置的值改为其相反数
     * 那么最后仍为整数的位置则其下标数不存在
     * @date:2019/7/30 19:47
     * @param:
     * @return:
    **/
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int index = Math.abs(nums[i])-1;
            nums[index] = -Math.abs(nums[index]);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
}
