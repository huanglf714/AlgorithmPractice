package sort;

import java.util.Arrays;

/**
 * @className:QuicSort
 * @author:huanglf714
 * @create:2019/7/27 13:01
 * @decription:快速排序——挖坑填数+分治法
 * 基本思想：找到一个基准数，将比基数大的数放到基数的左边，比基数小的数放到基数的右边，重复N次直至数据有序
 * 平均时间复杂度：O(nlogn) 最好时间复杂度：O(nlogn) 最坏时间复杂度：O(n^2)
 * 空间复杂度: O(logn)
 * 稳定性：非稳定性，不稳定性发生在基数与array[i]交换的时刻
 * 优化思路：快排的时间复杂度和基准数的选择有关，基准数的选择有三种方式：固定基准数，随机基准数，三数取中
 * 参考资料：https://juejin.im/post/5b55660ee51d4519202e2003
 **/
public class QuickSort {
    public static void main(String[] args){
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array){
        sort(array,0,array.length-1);
    }

    public static void sort(int[] array,int low,int high){
        if(array ==null || low>=high || array.length<=1){return;}
        int i = low,j = high,target = array[low];
        //初始值坑为array[i]
        while(j>i){
            //从后面找到比target小的数——找数
            while(i<j&&array[j]>=target){
                j--;
            }
            //——填旧坑，新坑为array[j]
            if(i<j){
                array[i] = array[j];
                i++;
            }
            //从前面找到比target大的数——找数
            while(i<j&&array[i]<=target){
                i++;
            }
            //——填旧坑，新坑为array[i]
            if(i<j){
                array[j] = array[i];
                j--;
            }
        }
        //将基数填入最后一个坑
        array[i] = target;
        //递归循环
        sort(array,low,i-1);
        sort(array,i+1,high);
    }
}
