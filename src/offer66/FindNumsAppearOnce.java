package offer66;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @className:FindNumsAppearOnce
 * @auther:huanglf714
 * @create:2019/5/17 15:46
 * @decription:
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 **/
public class FindNumsAppearOnce {

    /**
     * @author:huanglf714
     * @description:方法一：hashmap法
     * @date:2019/5/17 16:16
     * @param:[array, num1, num2]
     * @return:void
    **/
    public static void find(int [] array,int num1[] , int num2[]) {
        int len = array.length;
        int[] tmp = new int[2];
        int j =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<len;i++){
            if(!map.containsKey(array[i])){
                map.put(array[i],1);
            }else{
                map.put(array[i],map.get(array[i])+1);
            }
        }
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        Iterator<Map.Entry<Integer,Integer>> it = set.iterator();
        while(it.hasNext()){
            Map.Entry<Integer,Integer> entry = it.next();
            System.out.println("key:"+entry.getKey()+",value:"+entry.getValue());
            if(entry.getValue()==1){
                tmp[j] = entry.getKey();
                j++;
            }
        }
        num1[0] = tmp[0];
        num2[0] = tmp[1];
    }

    /**
     * @author:huanglf714
     * @description:方法二：异或法
     * 两个相同的数异或肯定为0，不同的数异或肯定存在1
     * 将所有的数异或起来，相同的数抵消，然后根据结果将数分成两组
     * 每组里面有一个唯一的数
     * @date:2019/5/17 16:16
     * @param:[array, num1, num2]
     * @return:void
    **/
    public static void find2(int [] array,int num1[] , int num2[]){
        int len = array.length;
        int tmp=0;
        num1[0] = 0;
        num2[0] = 0;
        for(int i=0;i<len;i++){
            tmp ^= array[i];
        }
        int indexOf1 = index(tmp);
        for(int i=0;i<len;i++){
            if(isBit(array[i],indexOf1)){
                num1[0] ^= array[i];
            }else{
                num2[0] ^= array[i];
            }
        }
    }

    public static int index(int tmp){
        int indexOf1 = 0;
        if((tmp&1)==0){
            tmp = tmp>>1;
            indexOf1++;
        }
        return indexOf1;
    }

    public static boolean isBit(int num,int indexOf1){
        for(int i=0;i<indexOf1;i++){
            num = num>>1;
        }
        return (num&1)==0?true:false;
    }

    public static void main(String[] args){
        int[] array = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        find2(array,num1,num2);
        System.out.println(num1[0]+","+num2[0]);
    }

}
