package offer66;

import java.util.LinkedList;

/**
 * @className:LastRemaining_Solution
 * @author:huanglf714
 * @create:2019/5/20 10:37
 * @decription:
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 **/
public class LastRemaining_Solution {

    /**
     * @author:huanglf714
     * @description:
     * 抽象建模，圆圈比较容易想到环形链表，可以直接用java类库中的LinkedList
     * 但是LinkedList不是环形的，因此用下标取余可以达到环形的目的
     * @date:2019/5/20 10:59
     * @param:[n, m]
     * @return:int
    **/
    public static int find(int n,int m){
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<n;i++){
            list.add(i);
        }
        int removeIndex = 0;
        while(list.size()>1){
            //可以看成当做环形链表处理
            removeIndex = (removeIndex+m-1)%list.size();
            list.remove(removeIndex);
        }
        return list.size()==1?list.get(0):-1;
    }

    public static void main(String[] args){
        int n = 5,m=3;
        System.out.println(find(n,m));

    }
}
