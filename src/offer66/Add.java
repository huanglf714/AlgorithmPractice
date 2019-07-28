package offer66;

import java.util.Stack;

/**
 * @className:Add
 * @author:huanglf714
 * @create:2019/5/20 11:24
 * @decription:
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 **/
public class Add {

    /**
     * @author:huanglf714
     * @description:
     * 用位运算来代替+、-、*、/
     * 难点在于进位的考虑
     * @date:2019/5/21 16:47
     * @param:[num1, num2]
     * @return:int
    **/
    public static int add(int num1,int num2){
        while(num2!=0){
            //按位异或，相当于不带进位的+
            int temp = num1 ^ num2;
            //按位与并左移一位，求得进位,若此数不为空则表示还有进位
            num2 = (temp&num2)<<1;
            num1 = temp;
        }
        return num1;
    }

    public static void main(String[] args){
        System.out.println(add(111,899));
    }
}
