package Stack;

import java.util.Vector;

/**
 * 手写一个栈
 */
public class MyStack extends Vector {
    final int maxsize = 100;
    protected int elementCount;
    int elem[] = new int[maxsize];
    int top;
    public MyStack(){
        top = 0;
    }

    public void clear(){
        top = 0;
    }

    //2.判断栈是否为空
    public boolean isEmpty(){
        if(top > 0)
            return false;
        else
            return true;
    }

    //3.进栈操作
    public void push(int data){
        if(top==maxsize)
            System.out.print("stack overflow");
        else
            elem[top++] = data;//进栈
    }

    //4.出栈操作
    public int pop(){
        if(top==0)
            return 0;
        else
            top--;//栈顶指针减1
        return elem[top];//返回原栈顶元素
    }

    //5.求栈深操作
    public int size(){
        return top;
    }

    //6.读取栈顶元素
    public int top(){
        if(top==0)
            return 0;
        else
            return elem[top-1];
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return lastIndexOf(o, elementCount-1);
    }

    public synchronized int search(Object o) {
        int i = lastIndexOf(o);

        if (i >= 0) {
            return size() - i;
        }
        return -1;
    }
}
