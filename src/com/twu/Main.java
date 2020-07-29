package com.twu;

import com.twu.services.HotSearchService;
import com.twu.services.HotSearchServiceI;

public class Main {
    private static HotSearchServiceI hotSearchService = new HotSearchService();

    public static void main(String[] args) {
        hotSearchService.operateHotSearch();


//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add("d");
//        list.add("e");
//
//        //将e买热搜第二位 变为[a e b c d]
//        if (list.contains("d")) {
//            List<String> newList = new ArrayList<>();
//            newList.addAll(list.subList(0, 1));
//            newList.add("d");
//            newList.addAll(list.subList(1, list.size()));
//            for (String s : newList) {
//                System.out.println(s);
//            }
//            newList.remove(newList.lastIndexOf("d"));
//            for (String s : newList) {
//                System.out.println(s);
//            }
//        } else {
//            throw new RuntimeException("没有选项，购买热搜失败");
//        }


    }

}
