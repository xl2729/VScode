package Java.day17.demo1;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest1 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList<>();
        list.add("a");
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("c");
        System.out.println("a:"+listTest(list, "a"));
        System.out.println("b:"+listTest(list, "b"));
        System.out.println("c:"+listTest(list, "c"));
        System.out.println("xxx:"+listTest(list, "xxx"));
    }

    //定义方法listTest()统计集合中指定元素出现的次数
    public static int listTest(Collection<String> list, String s){
        int count = 0;
        for(String string : list){
            if(s.equals(string)){
                count++;
            }
        }
        return count;
    }
}
