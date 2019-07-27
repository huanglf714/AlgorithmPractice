package sort;

import java.util.Arrays;

/**
 * @className:InsertSort
 * @author:huanglf714
 * @create:2019/7/27 14:50
 * @decription:插入排序——在已排好序的数组中插入一个元素使数组仍旧有序
 * 平均时间复杂度：O(n^2) 最好时间复杂度：O(n)(数组本身就是有序数组) 最坏时间复杂度：O(n^2)
 * 空间复杂度：O（1）
 * 稳定性：稳定
 **/
public class InsertSort {
    public static void main(String[] args){
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        insertSort(array);
        System.out.println(Arrays.toString(array));

    }

    private static void insertSort(int[] array){
        int j;
        for(int i=1;i<array.length;i++){
            if(array[i]<array[i-1]){
                //待排序元素
                int temp = array[i];
                //从后往前遍历元素，找到待排序元素插入的位置，将比其大的数字依次后移
                for(j=i-1;j>=0;j--){
                    if(array[j]>temp){
                        array[j+1] = array[j];
                    }else{
                        break;
                    }
                }
                //将待排序元素插入到合适位置
                array[j+1] = temp;
            }
        }
    }

}
