package offer66;

/**
 * @className:StrToInt
 * @author:huanglf714
 * @create:2019/5/21 16:50
 * @decription:
 **/
public class StrToInt {

    public static int revert(String str){
        if(str==null||str.length()==0){
            return 0;
        }
        int len = str.length();
        int result = 0;
        boolean isNagative = false;
        for(int i=0;i<len;i++){
            int temp = str.charAt(i)-'0';
            if(temp >=0 && temp<=9){
                result = result*10+temp;
            }else{
                if(str.charAt(i)=='+'&&i==0){

                }else if(str.charAt(i)=='-'&&i==0){
                    isNagative = true;
                }else{
                    return 0;
                }
            }
        }
        if(isNagative){
            return 0-result;
        }else {
            return result;
        }
    }

    public static void main(String[] args){
        System.out.println(revert("+12398"));
        System.out.println(revert("-56"));
        System.out.println(revert("kk08"));
        System.out.println(revert("12o"));
        System.out.println(revert("00908"));
    }
}
