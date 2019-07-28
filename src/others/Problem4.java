package others;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @className:Problem4
 * @author:huanglf714
 * @create:2019/7/28 19:38
 * @decription:猿辅导校招2019
 * 某天猿辅导 HR 组织大家去漂流，早上，参加团建的同学都到齐了，并且按到达公司的先后顺序排好队了。
 * 由于员工太多，一个大巴车坐不下，需要分多个车，车是足够的，但所有人需要按一定顺序上车，
 * 按如下规则安排上车的顺序：
 * 假设大巴车容量为 m，从队首开始，每 m 个人分成一个小组，每个小组坐一辆车。
 * 同时只有一个车打开车门供员工上车。 小组之间按从队尾到队首顺序依次上车，同一小组内先到的同学先上，
 * 求所有人上车的顺序。
 *
 * 例如： 员工数 8， 车容量 3， 员工到达顺序为 1 2 3 4 5 6 7 8， 3个人一个小组，
 * 分三个小组， 小组一： 1， 2， 3， 小组二： 4， 5， 6，小组三： 7，8。
 * 小组上车顺序为： 小组三，小组二，小组一 。 所有员工上车顺序为 7 8 4 5 6 1 2 3
 **/
public class Problem4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int peopleCount = in.nextInt();
        int carCapacity = in.nextInt();
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i=0;i<peopleCount;i++){
            numbers.add(in.nextInt());
        }
        //method1(peopleCount,carCapacity,numbers);
        method2(peopleCount,carCapacity,numbers);

    }

    /**
     * @author:huanglf714
     * @description:解法一：因为最早一组先来后上车，符合栈先进后出的规律，因为可用栈来保存小组，组内则按序输出
     * 这一种思路更容易想到
     * @date:2019/7/28 20:18
     * @param:[peopleCount, carCapacity, numbers]
     * @return:void
    **/
    public static void method1(int peopleCount,int carCapacity,ArrayList<Integer> numbers){
        ArrayList<Integer> temp = new ArrayList<>();
        Stack<ArrayList<Integer>> groups = new Stack<>();
        int count = 0;
        for(int i=0;i<peopleCount;i++){
            count++;
            temp.add(numbers.get(i));
            if(count==carCapacity){
                //注意这里是new了一个ArrayList放到栈里，否则下一步temp一清空，栈里的数组也是空的
                groups.push((new ArrayList<>(temp)));
                temp.clear();
                count = 0;
            }
        }
        //最后一组未满员的情况
        if(count!=0){
            groups.push(temp);
        }
        while(!groups.isEmpty()){
            temp = groups.pop();
            for(int i=0;i<temp.size();i++){
                System.out.print(temp.get(i)+" ");
            }
        }
    }

    /**
     * @author:huanglf714
     * @description:解法二：利用数组下标，设置每一组的开始和结束指针
     * 找到最先上车的小组的起始位置，等第一组上车完毕之后，开始和结束指针往前移carCapacity个单位开始第二小组
     * @date:2019/7/28 20:34
     * @param:[peopleCount, carCapacity, numbers]
     * @return:void
    **/
    public static void method2(int peopleCount,int carCapacity,ArrayList<Integer> numbers){
        int start = peopleCount/carCapacity*carCapacity,end = peopleCount-1;
        int index = start;
        for (int i=0;i<peopleCount;i++){
            if(index>end){
                index = start -= carCapacity;
                end = start+carCapacity-1;
            }
            System.out.print(numbers.get(index++)+" ");
        }
    }

}
