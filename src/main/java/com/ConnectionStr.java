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

    String arr[] = new String [9];
    String input ; //���������
    static List<String[]> list = new ArrayList<String[]>();
    static {
        initList();//ʵ������ĸ��
    }


    //����һ
    public String process(String input) {
        StringBuilder output = new StringBuilder(); //����1���������
            this.input = input;
            if(!verification(input, null)){
                return "";
            }
            input = input.replace("0", "").replace("1", "");
            if (input.length() == 0){
                return "";
            }

            int digit = input.length(); //��ȡλ�������ȣ�
            //��ȡ���ֶ�Ӧ��ĸ��
            String [] lettters = list.get(Integer.parseInt(String.valueOf(input.charAt(0))));
            //ֻ��һλ�������
            if(digit == 1){
                for (int p = 0; p < lettters.length; p++) {
                    output.append(lettters[p]+" ");
                }
            }else{
                //������ĸ��
                for (int i = 0; i <lettters.length; i++) {
                    recursion(0, lettters[i], digit-1, output);
                }
            }
        return output.toString().trim();
    }

    /**
     *
     * �ݹ�ƴ��
     *
     * index����������ֵ��±�
     * appendStr �����
     * recursionTimes �ݹ���� = λ�� -1,���ж��Ƿ�����һλ������������ݹ�
     */
    public  void recursion(int index, String appendStr, int recursionTimes, StringBuilder output) {
        if(recursionTimes > 0 ) {
            index = index + 1;
        }
        //��ȡ��һ�����ֶ�Ӧ����ĸ��
        String [] lettters = list.get(Integer.parseInt(String.valueOf(input.charAt(index))));
        recursionTimes = recursionTimes - 1;

        //����
        for (int j = 0; j < lettters.length; j++) {
            if(recursionTimes > 0){
                //���滹��һλ
                recursion(index, appendStr+lettters[j], recursionTimes, output);
            }else {
                //û�������ƴ�ӣ����Ͽո�
                output.append(appendStr+lettters[j]+" ");
            }
        }
    }

    /**
     * -----��չ����-------�����
     * @param input �����ַ���
     *  ֧��0-99������ת����Ӣ�ġ�
     */
    public String process1(String input) {
        //�Ƿ�У��
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
//        System.out.println("�������֣�"+input+" ת����Ϊ��"+result.toString());
        return result.toString().trim();
    }

    //��װlist
    public static void initList() {
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
     * ����У��
     * @param input
     * @param s :�˲���������������õ�����ʾֻ������0-99������
     * @return true:У��ɹ� false��ʧ��
     */
    public static boolean verification(String input, String s) {
        //�������볤��Ϊ0-9����ΧΪ0-9��������
        Pattern pattern = Pattern.compile("^[0-9]\\d{0,9}$");

        if(s != null){
            pattern = Pattern.compile("^[0-2]\\d{0,9}$");
        }

        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
