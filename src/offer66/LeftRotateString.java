package offer66;

/**
 * @className:LeftRotateString
 * @auther:huanglf714
 * @create:2019/5/19 14:24
 * @decription:
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，
 * 就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 **/
public class LeftRotateString {

    /**
     * @author:huanglf714
     * @description:方法一
     * 在源字符串的后面在增加一个字符串长度的空间，用来保存后移的字符
     * 然后截取字符串获得所需字符串
     * @date:2019/5/19 14:36
     * @param:[str, n]
     * @return:java.lang.String
    **/
    public static String leftRotate1(String str,int n){
        if(str==null||str.length()==0){
            return null;
        }
        int len = str.length();
        int k=n%len;
        StringBuffer tmpString = new StringBuffer(str);
        for(int i=0;i<k;i++){
            tmpString.append(str.charAt(i));
        }
        return tmpString.toString().substring(k);

    }

    /**
     * @author:huanglf714
     * @description:方法二
     * 假设要左移的n为字符串组合在一起为X，后面的字符串为Y
     * 现在就是已知XY，要求YX，而YX  = (xTyT)T，因此执行反转三次即可
     * 但是要注意string不可变的特性，应采用stringBuilder来执行
     * @date:2019/5/19 14:39
     * @param:[str, n]
     * @return:java.lang.String
    **/
    public static String leftRotate2(String str,int n){
        if(str==null||str.length()==0){
            return null;
        }
        int len = str.length();
        n = n%len;
        StringBuilder stringBuilder = new StringBuilder(str);
        swap(stringBuilder,0,n-1);
        swap(stringBuilder,n,len-1);
        return swap(stringBuilder,0,len-1).toString();

    }

    public static StringBuilder  swap(StringBuilder stringBuilder,int beginIndex,int endIndex){
        while(beginIndex<endIndex){
            char tmp = stringBuilder.charAt(beginIndex);
            stringBuilder.setCharAt(beginIndex,stringBuilder.charAt(endIndex));
            stringBuilder.setCharAt(endIndex,tmp);
            beginIndex++;
            endIndex--;
        }
        return stringBuilder;
    }

    public static void main(String[] args){
        String str = "abcXYZdef";
        int n=3;
        System.out.println(leftRotate2(str,n));
    }
}
