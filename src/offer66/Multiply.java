package offer66;

/**
 * @className:Multiply
 * @author:huanglf714
 * @create:2019/5/21 21:08
 * @decription:
 **/
public class Multiply {

    public static int[] judge(int[] A){
        int len = A.length;
        int[] B = new int[len];
        B[0] = 1;
        //计算下三角乘积
        for(int i=1;i<len;i++){
            B[i] = B[i-1]*A[i-1];
        }
        int temp = 1;
        //自下而上计算上三角乘积
        for(int i=len-2;i>=0;i--){
            temp *= A[i+1];
            B[i] *= temp;
        }
        return B;
    }

    public static void main(String[] args){

    }
}
