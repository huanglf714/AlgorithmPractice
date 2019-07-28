package offer66;

import java.util.ArrayList;
import java.util.List;

/**
 * @className:FindNumbersWithSum
 * @auther:huanglf714
 * @create:2019/5/18 11:25
 * @decription:
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 **/
public class FindNumbersWithSum {

    /**
     * @author:huanglf714
     * @description:
     * 解题关键：两个数相隔越远，乘积越小
     * 双指针法
     * @date:2019/5/18 11:31
     * @param:[array, sum]
     * @return:java.util.ArrayList<java.lang.Integer>
    **/
    public static ArrayList<Integer> find(int [] array,int sum){
        ArrayList<Integer> result = new ArrayList<>();
        int arrayLen = array.length;
        int head = 0,tail = arrayLen-1;
        while(head<tail){
            int curSum = array[head]+array[tail];
            if(curSum==sum){
                result.add(array[head]);
                result.add(array[tail]);
                break;
            }else if(curSum<sum){
                head++;
            }else{
                tail--;
            }
        }
        return result;
    }

    public static void main(String[] args){

    }
}
