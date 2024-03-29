package offer66;

/**
 * @className:ReverseSentence
 * @author:huanglf714
 * @create:2019/5/19 15:05
 * @decription:
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 **/
public class ReverseSentence {
    /**
     * @author:huanglf714
     * @description:
     * 将string按照空格分成几个字符串放在数组里面，然后和上一题类似，互换首尾位置即可
     * @date:2019/5/19 15:23
     * @param:[str]
     * @return:java.lang.String
    **/
    public static String reverse(String str){
        if(str==null||str.length()==0){
            return "";
        }
        String[] strings = str.split(" ");
        int len = strings.length;
        if(len==0){
            return " ";
        }
        int beginIndex = 0, endIndex = len-1;
        while(beginIndex<endIndex){
            String tmp = strings[beginIndex];
            strings[beginIndex] = strings[endIndex];
            strings[endIndex] = tmp;
            beginIndex++;
            endIndex--;
        }
        String result = "";
        for(int i=0;i<len-1;i++){
            result = result+strings[i]+" ";
        }
        result += strings[len-1];
        return result;
    }

    public static void main(String[] args){
        String str =" ";
//        String str = "student. a am I";
        System.out.println(reverse(str));
    }
}
