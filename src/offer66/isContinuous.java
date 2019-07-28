package offer66;

import java.util.Arrays;

/**
 * @className:isContinuous
 * @author:huanglf714
 * @create:2019/5/19 15:28
 * @decription:
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...
 * 他随机从中抽出了5张牌,想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！
 * “红心A,黑桃3,小王,大王,方片5”,“Oh My God!”不是顺子.....LL不高兴了,
 * 他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。
 * 现在,要求你使用这幅牌模拟上面的过程,然后告诉我们LL的运气如何，
 * 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 **/
public class isContinuous {
    /**
     * @author:huanglf714
     * @description:
     * 关键：
     * 1、若有除0之外相同的数出现则肯定不能形成顺子
     * 2、只要最大值和最小值之间的差值<5
     * @date:2019/5/19 15:41
     * @param:[numbers]
     * @return:boolean
    **/
    public static boolean judge1(int[] numbers){
        if(numbers==null||numbers.length==0){
            return false;
        }
        int[] count = new int[14];
        int len= numbers.length;
        int max =-1,min=15;
        for(int i=0;i<len;i++){
            count[numbers[i]]++;
            if(numbers[i]==0){
                continue;
            }
            //出现除0之外的其他数字重复，则肯定不能形成顺子
            if(count[numbers[i]]>1){
                return false;
            }
            if(numbers[i]>max){
                max = numbers[i];
            }
            if(numbers[i]<min){
                min = numbers[i];
            }
        }
        System.out.println(max+","+min);
        if(max-min<5){
            return true;
        }else{
            return false;
        }
    }

    /**
     * @author:huanglf714
     * @description:方法二
     * 关键：
     * 1、若有除0之外相同的数出现则肯定不能形成顺子
     * 2、判断总共的中间的缺少的间隔数的数目是否<=0的数目
     * @date:2019/5/19 16:16
     * @param:[numbers]
     * @return:boolean
    **/
    public static boolean judge2(int[] numbers){
        if(numbers==null||numbers.length==0){
            return false;
        }
        int countOfZero = 0;
        Arrays.sort(numbers);
        int len= numbers.length;
        for(int i=0;i<len-1;i++) {
            if (numbers[i] == 0) {
                countOfZero++;
                continue;
            }
            int differ = numbers[i+1]-numbers[i];
            switch (differ){
                //出现除0之外的其他数字重复，则肯定不能形成顺子
                case 0:{
                    return false;
                }
                case 1:{
                   break;
                }
                default:{
                    if(differ-1>countOfZero){
                        return false;
                    }else{
                        countOfZero -= differ-1;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        int[] numbers = {1,3,2,5,4};
        System.out.println(judge1(numbers));

    }
}
