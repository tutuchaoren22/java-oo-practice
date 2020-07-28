package com.twu;

import com.twu.controllers.HotSearchController;

public class Main {
    private static HotSearchController hotSearchController =new HotSearchController();

    public static void main(String[] args) {
        hotSearchController.operateHotSearch();
    }

}
