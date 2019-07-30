package leetcode;

/**
 * @className:Problem10
 * @author:huanglf714
 * @create:2019/7/30 18:36
 * @decription:移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 **/
public class Problem10 {
    /**
     * @author:huanglf714
     * @description:方法一：遇到非零元素则放到index处（index为最后一个非零元素的指针）
     * 然后剩下[index,nums.length]处用0填充
     * @date:2019/7/30 18:58
     * @param:[nums]
     * @return:void
    **/
    public void moveZeroes(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                nums[index] = nums[i];
                index++;
            }
        }
        for(int i=index;i<nums.length;i++){
            nums[i] = 0;
        }
    }

    /**
     * @author:huanglf714
     * @description:方法二：双指针法，用一个指针遍历数组元素，另外一个指针指向零元素,遇到非零元素则交换
     * 最后零元素就都在尾部
     * @date:2019/7/30 19:03
     * @param:[nums]
     * @return:void
    **/
    public void moveZeroes2(int[] nums) {
        int index = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                swap(nums,i,index++);
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        if(i==j){
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
