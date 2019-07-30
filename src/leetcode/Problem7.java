package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @className:Problem7
 * @author:huanglf714
 * @create:2019/7/30 12:40
 * @decription:求众数
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 *
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/majority-element
 **/
public class Problem7 {
    /**
     * @author:huanglf714
     * @description:方法一：哈希表法
     * 通过一轮遍历数组，将数组中每个数及其出现的次数保存在哈希表中
     * 然后遍历哈希表，找到出现次数打印大于{n/2}的元素
     * @date:2019/7/30 12:58
     * @param:[nums]
     * @return:int
    **/
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int count;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                count = 0;
            } else {
                count = map.get(nums[i]);
            }
            count++;
            map.put(nums[i], count);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue()>nums.length/2){
                return entry.getKey();
            }
        }
        return 0;
    }
    /**
     * @author:huanglf714
     * @description:摩尔投票法
     * 众数出现次数大于n/2次，则将众数看成1，其他数看成-1，则所有加起来和一定大于0
     * 选一个数做候选众数，若下一个数等于它，则+1，若不等于它则-1，当count为0时重新挑选下一个遍历到的数为候选众数
     * 最后遍历结束剩下的候选众数就是众数
     * @date:2019/7/30 13:06
     * @param:[nums]
     * @return:int
    **/
    public int majorityElement2(int[] nums) {
        int count = 0;
        int candicate=0;
        for (int num:nums) {
            if (count==0) {
                candicate = num;
            }
            count += (num==candicate)?1:-1;
        }
        return candicate;
    }


}
