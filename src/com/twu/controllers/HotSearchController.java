package com.twu.controllers;

import com.twu.services.HotSearchService;
import com.twu.services.HotSearchServiceI;

import java.util.Scanner;

public class HotSearchController {
    private HotSearchServiceI hotSearchService = new HotSearchService();
    public  void operateHotSearch(){
        hotSearchService.operateHotSearch();
    }
}
