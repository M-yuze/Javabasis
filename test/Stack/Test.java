package Stack;

import java.text.SimpleDateFormat;
import java.util.Stack;

public class Test {
    //泛型方法
    public static < E > void printArray( E[] inputArray )
    {
        // 输出数组元素
        for ( E element : inputArray ){
            System.out.printf( "%s ", element );
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(6);
        int search = st.search(6);
        System.out.println(search);
        MyStack ms = new MyStack();
        ms.push(6);
        System.out.println(ms.search(6));

    }
}
