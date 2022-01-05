package java.day17.demo1;

import java.util.Scanner;

public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("****欢迎使用用户注册系统****");
            System.out.println("请选择操作：");
            System.out.println("1、注册");
            System.out.println("2、登录");
            switch (sc.nextInt()) {
                case 1:
                    System.out.println("用户名：");
                    String next1 = sc.next();
                    System.out.println("密码：");
                    String next2 = sc.next();
                    
                    break;
                case 2:
                    break;
                default:
                    System.out.println("输入有误");
                    break;
            }
        }
    }
}