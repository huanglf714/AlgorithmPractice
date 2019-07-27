package sort;

import java.util.Arrays;

/**
 * @className:ShellSort
 * @author:huanglf714
 * @create:2019/7/27 15:25
 * @decription:希尔排序(缩小增量排序)——优化版的直接插入排序
 * 因为直接插入排序在n较小的时候和数据基本有序的时候效率还是很高的，因此可以将数组分成几个小分组，
 * 各小分组内局部有序之后再排序效率就会比较理想
 * 平均时间复杂度：O(nlogn) 最好时间复杂度：O(n) 最坏时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 **/
public class ShellSort {
    public static void main(String[] args){
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] array){
        //默认步长为数组长度/2
        int step = array.length;
        int k;
        while(step>1){
            step = step/2;
            //确定分组
            for(int i=0;i<step;i++){
                //分组内进行直接插入排序
                for(int j=i+step;j<array.length;j+=step){
                    int temp = array[j];
                    for(k=j-step;k>=0;k-=step){
                        if(array[k]>temp){
                            array[k+step] = array[k];
                        }else{
                            break;
                        }
                    }
                    array[k+step] = temp;
                }
            }
        }
    }
}
