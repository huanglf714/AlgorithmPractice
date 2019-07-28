package offer66;

import java.util.Scanner;

/**
 * @className:TheNumOf1
 * @auther:huanglf714
 * @create:2019/5/11 19:15
 * @decription:
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。
 * ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）
 *
 * 解决办法：
 * 考虑每位可能取到1的个数，对于数abcde在c位置1的个数要受高位和低位数字一起影响
 * 当c位为1时，c位为1的数字个数受高位和低位同时影响，
 * 当c位为0或者>=2时，c位为1的数字个数只受高位影响。
 * 以百位为例
 * 1、百位为1时例如12143,则百位上取到1的数字有100-199，1100-1199,......,11100-11199，12100-12199，但是12144-12199取不到
 * 2、百位为0时例如12043，则百位上取到1的数字有100-199,......,11100-11199,12000-12043,最后一个区间百位上没有1
 * 3、百位上为>1的数字时例如12543，则100-199,......,11100-11199,12100-12199都能取到
 *
 *
 * 扩展：
 * 数字X出现的次数
 **/
public class TheNumOf1 {

    public static int calculate(int n){
        int count = 0;
        int i = 1;
        int cur,after,before;
        while(i<=n){
            before = n/i/10;
            cur = (n/i)%10;
            after = n-n/i*i;
            switch (cur){
                case 0:
                    count += before*i;
                    break;
                case 1:
                    count += before*i + after +1;
                    break;
                default:
                    count += (before+1)*i;
            }
            i *= 10;
        }
        return count;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int index = in.nextInt();
            System.out.println(calculate(index));
        }

    }
}
