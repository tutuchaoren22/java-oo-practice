package com.twu.services;

import com.twu.entities.Administrator;
import com.twu.entities.User;
import com.twu.exception.WrongInputException;
import com.twu.repositories.HotSearchRepository;
import com.twu.repositories.HotSearchRepositoryI;

import java.util.Scanner;

public class HotSearchService implements HotSearchServiceI {
    private HotSearchRepositoryI hotSearchRepository = new HotSearchRepository();
    private UserServiceI userService = new UserService();
    private AdminServicesI adminServices = new AdminServices();

    @Override
    public void operateHotSearch(){
        while (true){
            try{
                System.out.println("欢迎来到热搜排行榜，你是?\n1.用户\n2.管理员\n3.退出");
                Scanner scanner = new Scanner(System.in);
                String choice = scanner.next();
                if(choice.equals("3")){
                    System.out.println("系统已退出");
                    operateHotSearch();
                }
                handle(choice);
            }catch (WrongInputException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void handle(String choice){
        Scanner scanner = new Scanner(System.in);
        if (choice.equals("1")){
            System.out.println("请输入你的昵称:");
            User user =new User(scanner.next()) ;
            userService.homePage(user);
        }else if (choice.equals("2")){
            System.out.println("请输入你的昵称:");
            String name = scanner.next() ;
            System.out.println("请输入你的密码:");
            String passWord = scanner.next() ;
            Administrator administrator = new Administrator();
            if (name.equals(administrator.getName()) && passWord.equals(administrator.getPassWord())){
                adminServices.homePage(administrator);
            }else {
                System.out.println("密码输入错误");
                operateHotSearch();
            }
        }else {
            throw new WrongInputException("选项输入错误");
        }
    }
}
