package com.twu.services;

import com.twu.entities.Administrator;
import com.twu.entities.HotSearch;
import com.twu.exception.WrongInputException;
import com.twu.repositories.HotSearchRepository;

import java.util.Scanner;

public class AdminService implements AdminServicesI {

    public void homePage(Administrator administrator) {
        System.out.println(String.format("你好,%s,你可以:", administrator.getName()));
        System.out.println("1.查看热搜排行榜\n2.添加热搜\n3.添加超级热搜\n4.退出");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();
        switch (choice) {
            case "1":
                HotSearchRepository.hotSearchManager.checkHotSearchList();
                homePage(administrator);
                break;
            case "2":
                System.out.println("请输入你要添加的热搜内容：");
                String contentToAdd = scanner.next();
                HotSearchRepository.hotSearchManager.addHotSearch(new HotSearch(contentToAdd));
                homePage(administrator);
                break;
            case "3":
                System.out.println("请输入你要添加的超级热搜内容：");
                String contentToAddSuper = scanner.next();
                HotSearchRepository.hotSearchManager.addSuperHotSearch(new HotSearch(contentToAddSuper, true));
                homePage(administrator);
                break;
            case "4":
                break;
            default:
                throw new WrongInputException("选项输入错误");
        }
    }
}
