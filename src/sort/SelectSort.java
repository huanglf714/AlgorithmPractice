package sort;

import java.util.Arrays;

/**
 * @className:SelectSort
 * @author:huanglf714
 * @create:2019/7/27 16:58
 * @decription:直接选择排序：每次选择一个最大（最小）元素放到前面
 * 时间复杂度：O(n^2) 最好时间复杂度：O(n^2) 最坏时间复杂度：O(n^2)
 * 空间复杂度：O(1)
 * 稳定性：不稳定
 **/
public class SelectSort {
    public static void main(String[] args){
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void selectSort(int[] array){
        for(int i=0;i<array.length;i++){
            int min = array[i],pos = i;
            for(int j=i+1;j<array.length;j++){
                if(min>array[j]){
                    min = array[j];
                    pos = j;
                }
            }
            swap(array,i,pos);
        }
    }

    private static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
