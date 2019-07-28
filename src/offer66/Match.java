package offer66;

/**
 * @className:Match
 * @author:huanglf714
 * @create:2019/5/21 21:39
 * @decription:
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 **/
public class Match {
    public boolean match(char[] str, char[] pattern){
        if(str==null||pattern==null){
            return false;
        }
        return matchHelp(str,0,pattern,0);
    }

    public boolean matchHelp(char[] str,int strIndex,char[] pattern,int pattIndex){
        if(strIndex==str.length&&pattIndex==pattern.length){
            return true;
        }
        if(pattIndex==pattern.length&&strIndex<str.length){
            return false;
        }
        //模式的后一位为*
        if(pattIndex+1<pattern.length&&pattern[pattIndex+1]=='*'){
            if(str[strIndex]==pattern[pattIndex]||pattern[pattIndex]=='.'){
                return matchHelp(str,strIndex+1,pattern,pattIndex)
                        || matchHelp(str,strIndex,pattern,pattIndex+2);
            }
            //若字符串第一个与模式第一个不一样
            else{
                return matchHelp(str,strIndex,pattern,pattIndex+2);
            }

        }
        //模式的后一位不为*，且当前源字符与模式字符匹配或者模式字符为.则后移一位，否则返回false
        if(strIndex<str.length&&str[strIndex]==pattern[pattIndex]
                ||(strIndex<str.length&&pattern[pattIndex]=='.')){
            return matchHelp(str,strIndex+1,pattern,pattIndex+1);
        }
        return false;
    }

}
