package offer66;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @className:MaxInWindows
 * @author:huanglf714
 * @create:2019/5/24 14:12
 * @decription:
 **/
public class MaxInWindows {
    public static ArrayList<Integer> find(int [] num, int size)
    {
        ArrayList<Integer> result = new ArrayList<>();
        if(num==null||num.length==0||size<=0){
            return result;
        }
        int max= -999;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<size;i++){
            deque.offer(num[i]);
            max = max>num[i]?max:num[i];
        }
        result.add(max);
        int len = num.length;
        for(int i=size;i<len;i++){
            int leave = deque.poll();
            if(leave!=max){
                max = max>num[i]?max:num[i];
                result.add(max);
            }else{
                max = findMaxInQueue(new LinkedList<>(deque));
                result.add(max);
            }
            deque.offer(num[i]);
        }
        return result;
    }

    public static int findMaxInQueue(LinkedList<Integer> queue){
        int max = -999;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            max = max>tmp?max:tmp;
        }
        return max;
    }

    /**
     * @author:huanglf714
     * @description:方法二
     * 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
     * 1.判断当前最大值是否过期
     * 2.新增加的值从队尾开始比较，把所有比他小的值丢掉
     * @date:2019/5/24 15:20
     * @param:[num, size]
     * @return:java.util.ArrayList<java.lang.Integer>
    **/
    public ArrayList<Integer> method2(int[] num,int size){

        ArrayList<Integer> res = new ArrayList<>();
        if(size == 0) {return res;}
        int begin;
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i = 0; i < num.length; i++){
            begin = i - size + 1;
            if(q.isEmpty()){
                q.add(i);
            }
            //判断队列头部的最大值是否过期
            else if(begin > q.peekFirst()){
                q.pollFirst();
            }
            //从后往前移除队列前面小于当前值的值，因为它们不可能成为最大值
            while((!q.isEmpty()) && num[q.peekLast()] <= num[i]){
                q.pollLast();
            }
            q.add(i);
            //begin用来控制向res中添加max的次数
            if(begin >= 0){
                res.add(num[q.peekFirst()]);
            }
        }
        return res;
    }


    public static void main(String[] args){
        int[] num = {16,14,12,10,8,6,4};
        int size = 5;
        ArrayList<Integer> result = find(num,size);
        for(int t:result){
            System.out.print(t+",");
        }
    }
}
