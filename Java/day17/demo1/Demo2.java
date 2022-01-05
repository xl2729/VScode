package Java.day17.demo1;

import java.util.ArrayList;

public class Demo2 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5};
        ArrayList<Integer> list = listTest(arr);
        System.out.println(list);
    }

    public static ArrayList<Integer> listTest(int[] arr){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int a : arr){
            list.add(a);
        }
        return list;
    }
}
