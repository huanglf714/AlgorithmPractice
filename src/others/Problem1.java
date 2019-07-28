package others;

import java.util.*;
/**
 * @author:huanglf714
 * @description:今日头条——用户爱好
 * 链接：https://www.nowcoder.com/questionTerminal/66b68750cf63406ca1db25d4ad6febbf
 * 来源：牛客网
 *
 * 为了不断优化推荐效果，今日头条每天要存储和处理海量数据。假设有这样一种场景：我们对用户按照它们的注册时间先后来标号，
 * 对于一类文章，每个用户都有不同的喜好值，我们会想知道某一段时间内注册的用户（标号相连的一批用户）中，
 * 有多少用户对这类文章喜好值为k。因为一些特殊的原因，不会出现一个查询的用户区间完全覆盖另一个查询的用户区间
 * (不存在L1<=L2<=R2<=R1)。
 * 链接：https://www.nowcoder.com/questionTerminal/66b68750cf63406ca1db25d4ad6febbf
 * 来源：牛客网
 *
 * 输入描述:
 * 输入： 第1行为n代表用户的个数 第2行为n个整数，第i个代表用户标号为i的用户对某类文章的喜好度
 * 第3行为一个正整数q代表查询的组数  第4行到第（3+q）行，每行包含3个整数l,r,k代表一组查询，
 * 即标号为l<=i<=r的用户中对这类文章喜好值为k的用户的个数。 数据范围n <= 300000,q<=300000 k是整型
 *
 *
 * 输出描述:
 * 输出：一共q行，每行一个整数代表喜好值为k的用户的个数
 *
 * 示例1
 * 输入
 * 5
 * 1 2 3 3 5
 * 3
 * 1 2 1
 * 2 4 5
 * 3 5 3
 *
 * 输出
 * 1
 * 0
 * 2
 *
 * 说明
 * 样例解释:
 * 有5个用户，喜好值为分别为1、2、3、3、5，
 * 第一组询问对于标号[1,2]的用户喜好值为1的用户的个数是1
 * 第二组询问对于标号[2,4]的用户喜好值为5的用户的个数是0
 * 第三组询问对于标号[3,5]的用户喜好值为3的用户的个数是2
 *
 * @date:2019/7/22 22:35
 * @param:
 * @return:
 **/
public class Problem1 {

    public static void main(String[] args) {
        method2();
    }

    /**
     * @author:huanglf714
     * @description:暴力破解法，使用双循环，复杂度为O(n^2)
     * @date:2019/7/22 21:32
     * @param:[]
     * @return:void
     **/
    public static void method1(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] likes = new int[n];
        for(int i=0;i<n;i++){
            likes[i] = in.nextInt();
        }
        int q = in.nextInt();
        int[] result = new int[q];
        for(int i=0;i<q;i++){
            int l = in.nextInt(),r = in.nextInt(), k = in.nextInt();
            int count = 0;
            for(int c=l-1;c<r-1;c++){
                if(likes[c]==k){
                    count++;
                }
            }
            result[i] = count;
        }
        for(int i=0;i<q;i++){
            System.out.println(result[i]);
        }
    }

    /**
     * @author:huanglf714
     * @description:哈希表拉链法，哈希表key是用户的爱好值k，value是爱好值为k的用户的标号组成的单链表
     * 算法复杂度为O(n*logn)，
     * 相比于方法一的暴力求解，方法一遍历的是[l-1..r-1]区间内的所有用户数
     * 而方法二的优化在于在寻找爱好值为k的用户时，遍历的是爱好值确认为k对应的链表长度
     * @date:2019/7/22 22:27
     * @param:[]
     * @return:void
     **/
    public static void method2(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Map<Integer, List<Integer>> likes = new HashMap<>(n);
        List<Integer> indexList;
        for(int i=0;i<n;i++){
            int like = in.nextInt();
            if(likes.containsKey(like)){
                indexList = likes.get(like);

            }else{
                indexList = new LinkedList<>();
            }
            indexList.add(i);
            likes.put(like,indexList);
        }
        int q = in.nextInt();
        for(int i=0;i<q;i++){
            int l = in.nextInt(),r = in.nextInt(), k = in.nextInt();
            int count = 0;
            if(likes.containsKey(k)){
                indexList = likes.get(k);
                Iterator<Integer> iterator = indexList.iterator();
                while (iterator.hasNext()){
                    int ele = iterator.next();
                    if(l-1<=ele&&ele<=r-1){
                        count++;
                    }
                }
            }
            System.out.println(count);

        }
    }
}
