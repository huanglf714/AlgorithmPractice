package offer66;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * @className:UglyNumber
 * @auther:huanglf714
 * @create:2019/5/11 20:46
 * @decription:
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 *
 * 解决思路
 * 每一个丑数都可以看成是以前的丑数*2或*3或*5得到的
 * 所以每次加入一个比当前最大的丑数大的最小的一个丑数，直到第index个
 **/
public class UglyNumber {

    public static int GetUglyNumber_Solution(int index) {
        if(index==0){
            return 0;
        }
        List<Integer> uglyNum = new ArrayList<>();
        uglyNum.add(1);
        int i=0,j=0,k=0;
        while(uglyNum.size()<index){
            int ii = uglyNum.get(i);
            int jj = uglyNum.get(j);
            int kk = uglyNum.get(k);
            int m_min = Math.min(ii*2,jj*3);
            int min = Math.min(m_min,kk*5);
            uglyNum.add(min);
            if(ii*2==min){
                i++;
            }
            if(jj*3==min){
                j++;
            }
            if(kk*5==min){
                k++;
            }
        }
        return uglyNum.get(uglyNum.size()-1);
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int index = in.nextInt();
            System.out.println(GetUglyNumber_Solution(index));
        }
    }
}
