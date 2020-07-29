package com.twu.entities;

import com.twu.exception.VoteFailException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class HotSearchManager {
    private List<HotSearch> hotSearchList = new ArrayList<>();
    private List<Integer> hotSearchPrice = new ArrayList<>();

    public HotSearchManager() {
    }

    public HotSearchManager(List<HotSearch> hotSearchList, List<Integer> hotSearchPrice) {
        this.hotSearchList = hotSearchList;
        this.hotSearchPrice = hotSearchPrice;
    }

    public List<HotSearch> getHotSearchList() {
        return hotSearchList;
    }

    public void setHotSearchList(List<HotSearch> hotSearchList) {
        this.hotSearchList = hotSearchList;
    }

    public List<Integer> getHotSearchPrice() {
        return hotSearchPrice;
    }

    public void setHotSearchPrice(List<Integer> hotSearchPrice) {
        this.hotSearchPrice = hotSearchPrice;
    }


    //热搜排行榜的方法
    //1.查看热搜
    public void checkHotSearchList() {
        this.hotSearchList.stream().sorted((h1, h2) -> h2.getVote()-h1.getVote()).forEach(System.out::println);//还没按是否买热搜排名
    }
    //2.添加热搜
    public void addHotSearch(HotSearch hotSearch){
        this.hotSearchList.add(hotSearch);
    }
    //3.添加超级热搜
    public void addSuperHotSearch(HotSearch hotSearch){
        this.hotSearchList.add(hotSearch);
    }

    //4.给热搜投票
    public void voteForHotSearch(User user,String content,int vote){
        if (vote > user.getVoteCount()){
            throw new VoteFailException("剩余票数不足");
        }else{
            for (HotSearch hotSearch : this.hotSearchList) {
                if(hotSearch.getContent().equals(content)){
                    hotSearch.setVote(hotSearch.getVote() + vote);
                    user.setVoteCount(user.getVoteCount() - vote);
                    break;
                }
            }
        }

    }
    //5.购买热搜
    public void buyHotSearch(String content,int rank){

    }
}
