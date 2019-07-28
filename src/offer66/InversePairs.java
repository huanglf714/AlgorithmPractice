package offer66;

import org.omg.PortableInterceptor.INACTIVE;

import javax.swing.plaf.PanelUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @className:InversePairs
 * @auther:huanglf714
 * @create:2019/5/17 9:15
 * @decription:
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 **/
public class InversePairs {
    /**
     * @author:huanglf714
     * @description:
     * 方法一：遍历算法的改良算法，用一个栈保存已经排序过的前n个数，第n+1个数过来
     * 找到栈中第一个小于它的数，放入栈中，在这之前出栈的总次数即为逆序对总数目
     * 但是算法复杂度为仍然为O(n2)
     * @date:2019/5/17 9:55
     * @param:[array]
     * @return:int
    **/
    public static int method1(int[] array){
        if(array==null||array.length==0||array.length==1){
            return 0;
        }
        int len = array.length,count = 0,everyCount;
        List<Integer> tmpArray = new ArrayList<>();
        Stack<Integer> stack = new Stack();
        stack.push(array[0]);
        for(int i=1;i<len;i++){
            everyCount = 0;
            while(!stack.isEmpty()&&stack.peek()>array[i]){
                tmpArray.add(stack.pop());
                everyCount++;
            }
            stack.push(array[i]);
            int tmpArrayLen;
            while(!tmpArray.isEmpty()){
                tmpArrayLen = tmpArray.size();
                stack.push(tmpArray.remove(tmpArrayLen-1));
            }
            count += everyCount;
        }
        return count%1000000007;
    }

    /**
     * @author:huanglf714
     * @description:
     *
     * @date:2019/5/17 9:57
     * @param:[array]
     * @return:int
    **/
    public static int method2(int[] array){
        int count = 0;
        return count;

    }

    public static void main(String[] args){
        int[] array = {364,637,341,406,747,995,234,971,571,219,993,
                407,416,366,315,301,601,650,418,355,460,505,360,965,
                516,648,727,667,465,849,455,181,486,149,588,233,144,
                174,557,67,746,550,474,162,268,142,463,221,882,576,
                604,739,288,569,256,936,275,401,497,82,935,983,583,
                523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,
                735,784,3,671,433,630,425,930,64,266,235,187,284,665,
                874,80,45,848,38,811,267,575};
        System.out.println(method2(array));
    }
}
