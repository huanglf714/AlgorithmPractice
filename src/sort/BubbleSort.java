package sort;


import java.util.Arrays;

/**
 * @className:BubbleSort
 * @author:huanglf714
 * @create:2019/7/27 17:10
 * @decription:冒泡排序
 * 时间复杂度：O(n^2) 最好时间复杂度：O(n) 最坏时间复杂度：O(n^2)
 * 空间复杂度：O（1）
 * 稳定性：稳定
 **/
public class BubbleSort {
    public static void main(String[] args){
        int[] array = {49, 38, 65, 97, 76, 13, 27, 49};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array){
        Boolean didSwap = false;
        for(int i=0;i<array.length;i++){
            for(int j=1;j<array.length-i;j++){
                if(array[j-1]>array[j]){
                    swap(array,j-1,j);
                    didSwap = true;
                }
            }
            if(didSwap==false){
                return;
            }
        }
    }

    private static void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
