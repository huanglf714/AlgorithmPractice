package offer66;

/**
 * @className:Sum_Solution
 * @author:huanglf714
 * @create:2019/5/20 11:14
 * @decription:
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 **/
public class Sum_Solution {

    /**
     * @author:huanglf714
     * @description:
     * 总体思想是递归，但是递归的终止条件本题要求不能用if
     * 运用短路原理
     * @date:2019/5/20 11:16
     * @param:[n]
     * @return:int
    **/
    public static int sum(int n){
        int ans = n;
        boolean b = ans!=0 && (ans+=sum(n-1))!=0;
        return ans;
    }

    public static void main(String[] args){
        System.out.println(sum(5));
    }
}
