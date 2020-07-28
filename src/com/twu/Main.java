package com.twu;

import com.twu.entities.Administrator;
import com.twu.entities.HotSearchManager;
import com.twu.entities.User;

import java.util.Scanner;

public class Main {
    private HotSearchManager hotSearchManager = new HotSearchManager();

    public static void main(String[] args) {
        operateHotSearch();
    }

    public static void operateHotSearch(){
        while (true){
            System.out.println("欢迎来到热搜排行榜，你是?\n1.用户\n2.管理员\n3.推出");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.next();
            if(choice.equals("3")){
                System.out.println("系统已退出");
                operateHotSearch();
            }
            handle(choice);
        }
    }

    public static void handle(String choice){
        Scanner scanner = new Scanner(System.in);
        if (choice.equals("1")){
            System.out.println("请输入你的昵称:");
            User user =new User(scanner.next()) ;
            homePage(user);
        }else if (choice.equals("2")){
            System.out.println("请输入你的昵称:");
            String name = scanner.next() ;
            System.out.println("请输入你的密码:");
            String passWord = scanner.next() ;
            Administrator administrator = new Administrator();
            if (name.equals(administrator.getName()) && passWord.equals(administrator.getPassWord())){
                homePage(administrator);
            }else {
                System.out.println("密码输入错误");
                operateHotSearch();
            }
        }
    }

    public static void homePage(User user){
        System.out.println(String.format("你好,%s,你可以:",user.getName()));
        System.out.println("1.查看热搜排行榜\n2.给热搜事件投票\n3.购买热搜\n4.添加热搜\n5.退出");
    }

    public static void homePage(Administrator administrator){
        System.out.println(String.format("你好,%s,你可以:",administrator.getName()));
        System.out.println("1.查看热搜排行榜\n2.添加热搜\n3.添加超级热搜\n4.退出");
    }
}
