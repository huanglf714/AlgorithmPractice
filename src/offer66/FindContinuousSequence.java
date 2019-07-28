package offer66;

import java.util.ArrayList;

/**
 * @className:FindContinuousSequence
 * @auther:huanglf714
 * @create:2019/5/18 10:00
 * @decription:
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 **/
public class FindContinuousSequence {

    /**
     * @author:huanglf714
     * @description:
     * 双指针解决先确定范围，在确定值
     * @date:2019/5/18 10:08
     * @param:[sum]
     * @return:java.util.ArrayList<java.util.ArrayList<java.lang.Integer>>
    **/
    public static ArrayList<ArrayList<Integer>> find(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        //前后指针
        int lowPoint = 1,highPoint = 2;
        //等差求和公式Sn = (a0+an)*n/2;
        int curSum;
        while(lowPoint<highPoint){
            curSum = (highPoint+lowPoint)*(highPoint-lowPoint+1)/2;
            if(curSum==sum){
                ArrayList<Integer> every = new ArrayList<>();
                for(int j=lowPoint;j<=highPoint;j++){
                    every.add(j);
                }
                lowPoint++;
                highPoint++;
                result.add(every);
            }else if(curSum<sum){
                //区间内值的和小于所求和，则大指针往前移一位
                highPoint++;
            }else{
                //区间内值的和大于所求和，则小指针往前移一位
                lowPoint++;
            }
        }
        return result;

    }

    public static void main(String[] args){
        int sum = 9;
        find(sum);
    }
}
