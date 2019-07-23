import java.util.Scanner;

/**
 * @className:Problem2
 * @author:huanglf714
 * @create:2019/7/23 10:19
 * @decription:iHandy2019——最后一词
 * 给定一个可能由任意数量的字母和空格组成的字符串序列，
 * 序列中每个只包含字母，不包含任何空格的子序列称为一个单词。请输出一个序列中最后一个单词的长度。
 * 例如hello word输出4
 * 两种解决办法：
 * 1、用split方法将字符串分割成一个个字符数组，求数组最后一个元素的字符长度
 * 2、用trim方法首先去除首尾空格，然后从最后一个字符往前计数直到遇到空格就停止
 **/
public class Problem2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        String string = str.trim();
        int count = 0;
        for(int i=string.length()-1;i>=0;i--){
            if(' '!=string.charAt(i)){
                count++;
            }else{
                break;
            }

        }
        System.out.println(count);
    }
}
