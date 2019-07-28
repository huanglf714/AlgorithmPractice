package offer66;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @className:FirstCurrence
 * @auther:huanglf714
 * @create:2019/5/11 20:12
 * @decription:
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）
 * 解决思路
 * 用HashMap存储每个字符出现的次数，然后找到第一个出现次数为1的字符
 **/
public class FirstCurrence {

    public static int firstNotRepeatingChar(String str){
        HashMap<Character,Integer> countMap= new HashMap<>();
        int length = str.length();
        for(int i=0;i<length;i++){
            char cur = str.charAt(i);
            if(countMap.containsKey(cur)){
                countMap.put(cur,countMap.get(cur)+1);
            }else{
                countMap.put(cur,1);
            }
        }
        for(int i=0;i<length;i++){
            char cur = str.charAt(i);
            if(countMap.get(cur)==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str = in.next();
            System.out.println(firstNotRepeatingChar(str));
        }
    }
}
