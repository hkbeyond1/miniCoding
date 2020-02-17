package com;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Auther: HKZ
 * @Date: 2020/2/15
 * @Description:
 */
public class ConnectionStr {

    String input ; //输入的内容
    static List<String[]> list = new ArrayList<String[]>();
    static {
        initList(list);//实例化字母集
    }


    //需求一
    public String process(String input) {
        StringBuilder output = new StringBuilder(); //需求1输出的内容
        this.input = input;
        if(!verification(input, null)){
            return "";
        }
        input = input.replace("0", "").replace("1", "");
        if (input.length() == 0){
            return "";
        }

        int digit = input.length(); //获取位数（长度）
        //获取数字对应字母组
        String [] lettters = list.get(Integer.parseInt(String.valueOf(input.charAt(0))));
        //只有一位数的情况
        if(digit == 1){
            for (int p = 0; p < lettters.length; p++) {
                output.append(lettters[p]+" ");
            }
        }else{
            //遍历字母组
            for (int i = 0; i <lettters.length; i++) {
                recursion(0, lettters[i], digit-1, output);
            }
        }
        return output.toString().trim();
    }

    /**
     *
     * 递归拼接
     *
     * index：输入的数字的下标
     * appendStr 拼接内容
     * recursionTimes 递归次数 = 位数 -1,即判断是否还有下一位数，有则继续递归
     * output 结果集
     */
    public  void recursion(int index, String appendStr, int recursionTimes, StringBuilder output) {
        if(recursionTimes > 0 ) {
            index = index + 1;
        }
        //获取下一个数字对应的字母集
        String [] lettters = list.get(Integer.parseInt(String.valueOf(input.charAt(index))));
        recursionTimes = recursionTimes - 1;

        //遍历
        for (int j = 0; j < lettters.length; j++) {
            if(recursionTimes > 0){
                //后面还有一位
                recursion(index, appendStr+lettters[j], recursionTimes, output);
            }else {
                //没有则结束拼接，加上空格
                output.append(appendStr+lettters[j]+" ");
            }
        }
    }

    /**
     * -----拓展功能-------需求二
     * @param input 输入字符串
     *  支持0-99的数字转换成英文。
     */
    public String process1(String input) {
        //非法校验
        if(!verification(input,"2")){
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            String [] lettters = list.get(Integer.parseInt(String.valueOf(input.charAt(i))));
            for (int j = 0; j < lettters.length; j++) {
                result.append(lettters[j]);
            }
            result.append(" ");
        }
//        System.out.println("输入数字："+input+" 转换后为："+result.toString());
        return result.toString().trim();
    }

    //组装list
    public static void initList(List<String[]> list) {
        list.add(new String []{"","",""});//0
        list.add(new String []{"","",""});//1
        list.add(new String []{"A","B","C"});
        list.add(new String []{"D","E","F"});
        list.add(new String []{"G","H","I"});
        list.add(new String []{"J","K","L"});
        list.add(new String []{"M","N","O"});
        list.add(new String []{"P","Q","R","S"});
        list.add(new String []{"T","U","V"});
        list.add(new String []{"W","X","Y","Z"});
    }

    /**
     * 正则校验
     * @param input
     * @param s :此参数在需求二方法用到，表示只能输入0-99的数字
     * @return true:校验成功 false：失败
     */
    public static boolean verification(String input, String s) {
        //必须输入长度为0-9，范围为0-9的正整数
        Pattern pattern = Pattern.compile("^\\d{0,9}$");
        //需求二
        if(s != null){
            pattern = Pattern.compile("^\\d{0,2}$");
        }

        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
