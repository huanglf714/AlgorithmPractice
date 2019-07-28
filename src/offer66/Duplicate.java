package offer66;

import java.util.HashMap;
import java.util.Map;

/**
 * @className:Duplicate
 * @author:huanglf714
 * @create:2019/5/21 17:08
 * @decription:
 **/
public class Duplicate {
    public static boolean judge(int[] numbers,int length,int[] duplication){
        Map<Integer,Integer> map = new HashMap<>();
        boolean isDuplicate = false;
        for(int i=0;i<length;i++){
            if(map.containsKey(numbers[i])){
                map.put(numbers[i],map.get(numbers)+1);
                isDuplicate = true;
                duplication[0] = numbers[i];
            }else{
                map.put(numbers[i],1);
            }
        }
        return isDuplicate;
    }
}
