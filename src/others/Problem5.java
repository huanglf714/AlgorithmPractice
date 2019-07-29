package others;

import java.util.Scanner;

/**
 * @className:Problem5
 * @author:huanglf714
 * @create:2019/7/29 13:13
 * @decription:猿辅导2019拍照队列
 * 猿辅导公司的 N位（N>=4）研发同学组织了一次秋游活动，某同学带了个无人机在高空拍照，活动结束时，
 * 先拍了一张所有同学排成公司猴头Logo的照片， 接着有人提议再排成“猿”的首字母Y字形来拍一张合照。
 *
 * 用字符串中的每一个字符（不是换行符或结束符'\0'）代表一位老师，输出排好后的队形。
 * 要求 Y字除去中心点外，上下半部分等高，按照从左到右，从上到下进行排序。队形中没人的部分用空格占位。
 * 输入数据保证可以排出一个完整的Y字，即长度为 3k+1 （k>=1）
 *
 * 例如: 7个 x ，排成队形为（为了方便说明，这里用‘-’代替空格）：
 * x---x
 * -x-x
 * --x
 * --x
 * --x
 * // 参考程序
 * #include <cstring>
 * #include <iostream>
 * #include <cstdio>
 * using namespace std;
 * char str[1010];
 * int N;
 * int main(){
 *     scanf("%d\n", &N);
 *     // TODO: 读入字符串，注意可能含空格
 *
 *     // TODO: 输出拍照队形，没人用空格占位
 *     printf(" %c\n", str[0]);
 * }
 **/
public class Problem5 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        if(len%3!=1){
            return;
        }
        //多加一行无效的输入行，否则nextLine函数的特性会使str = in.nextLine这一行跳过
        sc.nextLine();
        //必须要用nextLine不能用next函数，因为题目中表示可能会包含空格
        String str = sc.nextLine();
        int height = (len-1)/3;
        //打印上半部分
        for(int i=0;i<height;i++){
            for(int j=0;j<i;j++){
                System.out.print(" ");
            }
            System.out.print(str.charAt(2*i));
            for(int j=0;j<(2*height-1)-2*i;j++){
                System.out.print(" ");
            }
            System.out.println(str.charAt(2*i+1));
        }
        //打印下半部分
        for(int i=0;i<height+1;i++){
            for(int j=0;j<height;j++){
                System.out.print(" ");
            }
            System.out.println(str.charAt(2*height+i));
        }
    }
}
