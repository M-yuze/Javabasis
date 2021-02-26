package String;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StringTest {


    public static void main(String[] args) throws UnsupportedEncodingException {
        String str1 = "Strings";
        String str2 = "Strings";
        String str3 = "Strings123";
        String str4 = "STRINGS";
        StringBuffer sb = new StringBuffer("Strings");
        char[] cls = {'a','b','c','S','t','r'};
        Object in = 123;

        //1、连接字符串,将指定字符串连接到此字符串的结尾
        String concat = str1.concat(str2);
        System.out.println(str1);               //Strings
        System.out.println(concat);             //StringsStrings

        //2、返回指定索引处的char值
        char ch = str1.charAt(0);
        System.out.println(ch);                 //S

        //3、按字典顺序比较两个字符串,*深入理解compareTo底层代码*
        int i = str1.compareTo(str2);
        System.out.println(i);                  //0
        int i1 = str1.compareTo(str3);
        System.out.println(i1);                 //-3

        //4、按字典顺序比较两个字符串，不考虑大小写
        int i2 = str1.compareToIgnoreCase(str3);
        System.out.println(i2);                 //-3

        System.out.println("********************************************");

        //5、当且仅当字符串与指定的StringBuffer有相同顺序的字符时候返回真
        boolean b = str1.contentEquals(sb);
        System.out.println(b);                  //true

        //6、返回指定数组中表示该字符序列的 String
        String s = String.copyValueOf(cls);
        System.out.println(s);                  //abcStr

        //7、public static String copyValueOf(char[] data, int offset, int count)
        //返回指定数组中表示该字符序列的 String (类似于截取字符串，从哪开始，截取多长)
        //data -- 字符数组,offset -- 子数组的初始偏移量,count -- 子数组的长度
        String s1 = String.copyValueOf(cls, 1, 4);
        System.out.println(s1);                 //bcSt

        //8、测试此字符串是否以指定的后缀结束
        boolean s2 = str1.endsWith("s");
        System.out.println(s2);                 //true
        boolean s3 = str1.endsWith("a");
        System.out.println(s3);                 //false

        //9、将此字符串与指定的对象比较,返回的的是布尔值，而上面的 compareTo、compareToIgnoreCase返回的是第一个不相等字符的ASCII码整型差值
        boolean equals = str1.equals(in);
        System.out.println(equals);             //false
        boolean equals1 = str1.equals(str2);
        System.out.println(equals1);            //true
        boolean equals2 = str1.equals(str3);
        System.out.println(equals2);            //false

        //10、将此 String 与另一个 String 比较，不考虑大小写
        boolean b1 = str1.equalsIgnoreCase(str4);
        System.out.println(b1);                 //true

        System.out.println("**********************************");

        //11、使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中，*与下面的方法有什么不一样*
        byte[] bytes = str1.getBytes();
        System.out.println(bytes);              //数组对象
        for (byte b2 : bytes) {
            System.out.println(b2);             //字符串响应位置对应的字母的ASCII码
        }
        //另外：返回的 byte[] 数组的长度，与原字符串的长度相等
        System.out.println(bytes.length);

        //12、使用指定的字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中  UTF-8是字符编码
        byte[] bytes1 = str1.getBytes("UTF-8");
        System.out.println(bytes1);             //数组对象
        for (byte b3 : bytes1) {
            System.out.println(b3);             //字符串响应位置对应的字母的ASCII码
        }

        //13、将字符从此字符串复制到目标字符数组
        char[] chs = new char[10];
        str1.getChars(1,5,chs,2);
        for (char c : chs) {
            System.out.println(c);              //trin
        }

        //14、返回此字符串的哈希码
        int i3 = str1.hashCode();
        System.out.println(i3);                 //-217105822

        //15、返回指定字符在此字符串中第一次出现处的索引
        int i4 = str1.indexOf(83);              //0
        System.out.println(i4);

        //16、返回在此字符串中第一次出现指定字符处的索引，从指定的索引开始搜索
        int i5 = str1.indexOf(83,0);
        System.out.println(i5);                 //0

        //17、int indexOf(String str)  int indexOf(String str, int fromIndex)与上面的两个方法类似

        //18、返回字符串对象的规范化表示形式
        String intern = str3.intern();
        System.out.println(intern);             //Strings123

        //19、告知此字符串是否匹配给定的正则表达式
        boolean matches = str1.matches("(.*)tr(.*)");
        System.out.println(matches);            //true

        //20、检测两个字符串在一个区域内是否相等
        //boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)
        //boolean regionMatches(int toffset, String other, int ooffset, int len)
        //ignoreCase -- 如果为 true，则比较字符时忽略大小写
        //toffset -- 此字符串中子区域的起始偏移量
        //other -- 字符串参数
        //ooffset -- 字符串参数中子区域的起始偏移量
        //len -- 要比较的字符数

        //21、字符串替换 返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的,参数使用单引号
        String replace = str1.replace('S', 'A');
        System.out.println(replace);            //Atrings

        //22、使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串 参数使用双引号,成功则返回替换的字符串，失败则返回原始字符串
        String replace1 = str1.replace("B", "A");
        System.out.println(replace1);           //Strings

        //23、使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串 参数使用双引号,成功则返回替换的字符串，失败则返回原始字符串
        String s4 = str1.replaceAll("S", "A");
        System.out.println(s4);                 //Atrings

        //24、 使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串,与上面类似
        // String replaceFirst(String regex, String replacement)

        str1.toLowerCase();
        str1.toLowerCase();
        str1.toLowerCase();
        str1.toLowerCase();
        str1.toLowerCase();
        str1.toLowerCase();

        StringBuilder sb2 = new StringBuilder("123");
    }
}
