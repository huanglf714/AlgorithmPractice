package others;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @className:Problem3
 * @author:huanglf714
 * @create:2019/7/23 10:57
 * @decription:iHandy2019——比大更大
 * 给定一列非负整数，求这些数连接起来能组成的最大的数。
 * 链接：https://www.nowcoder.com/questionTerminal/8712c1e04b914d19a7e5e195c8c04fbb
 * 来源：牛客网
 *
 * 输入描述:
 * 第一行n>0是一个正整数，表示一共有n个输入。以后每行是一个非负整数，共有n行。
 *
 *
 * 输出描述:
 * n个输入的非负整数连接成的最大的数
 * 示例1
 * 输入
 * 6
 * 9
 * 8
 * 7
 * 65
 * 4
 * 3
 * 输出
 * 9876543
 **/
public class Problem3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] array = new String[n];
        for(int i=0;i<n;i++){
            array[i] = in.next();
        }
        //重写比较器，使数组按照高位排序
        Arrays.sort(array, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String str1 = o1+o2;
                String str2 = o2+o1;
                return str2.compareTo(str1);
            }
        });
        if("0".equals(array[0])){
            System.out.println("0");
        }else{
            StringBuilder stringBuilder = new StringBuilder();
            for(int i=0;i<n;i++){
                stringBuilder.append(array[i]);
            }
            System.out.println(stringBuilder.toString());
        }

    }

}
