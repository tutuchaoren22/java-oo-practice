package com.twu.entities;

import com.twu.exception.VoteFailException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class HotSearchManager {
    private List<HotSearch> hotSearchList = new ArrayList<>();

    public HotSearchManager() {
    }

    public List<HotSearch> getHotSearchList() {
        List<HotSearch> list = this.hotSearchList.stream().sorted((h1, h2) -> h2.getVote() - h1.getVote()).collect(Collectors.toList());
        List<HotSearch> willSortHotSearch = new ArrayList<>();
        for (HotSearch hotSearch : list) {
            if (hotSearch.isBuyHotSearch()) {
                willSortHotSearch.add(hotSearch);
            }
        }
        for (HotSearch hotSearch : willSortHotSearch) {
            list = sortByRanking(list, hotSearch);
        }
        this.hotSearchList = list;
        return list;
    }

    public List<HotSearch> sortByRanking(List<HotSearch> list, HotSearch hotSearch) {
        List<HotSearch> newList;
        newList = new ArrayList<>(list.subList(0, hotSearch.getRanking() - 1));
        newList.add(hotSearch);
        newList.addAll(list.subList(hotSearch.getRanking() - 1, list.size()));
        newList.remove(newList.lastIndexOf(hotSearch));
        return newList;
    }

    //1.查看热搜
    public void checkHotSearchList() {
        List<HotSearch> hotSearchList = getHotSearchList();
        hotSearchList.forEach(i -> System.out.println(hotSearchList.indexOf(i) + 1 + " " + i));
    }

    //2.添加热搜
    public void addHotSearch(HotSearch hotSearch) {
        this.hotSearchList.add(hotSearch);
    }

    //3.添加超级热搜
    public void addSuperHotSearch(HotSearch hotSearch) {
        this.hotSearchList.add(hotSearch);
    }

    //4.给热搜投票
    public void voteForHotSearch(User user, String content, int vote) {
        if (vote > user.getVoteCount()) {
            throw new VoteFailException("投票失败：剩余票数不足");
        } else {
            boolean voteSuccess = false;
            for (HotSearch hotSearch : this.hotSearchList) {
                if (hotSearch.getContent().equals(content)) {
                    int voteToAdd = vote;
                    if (hotSearch.isSuperHotSearch()) {
                        voteToAdd = vote * 2;
                    }
                    hotSearch.setVote(hotSearch.getVote() + voteToAdd);
                    user.setVoteCount(user.getVoteCount() - vote);
                    voteSuccess = true;
                    System.out.println("投票成功！");
                    break;
                }
            }
            if (!voteSuccess) {
                throw new VoteFailException("投票失败：热搜不存在");
            }
        }
    }

    //5.购买热搜
    public void buyHotSearch(String content, int ranking, int price) {
        boolean canBuyIt = false;
        List<HotSearch> hotSearchList = getHotSearchList();
        for (HotSearch hotSearch : hotSearchList) {
            if (hotSearch.getContent().equals(content) && price > hotSearchList.get(ranking - 1).getPrice()) {
                canBuyIt = true;
                hotSearch.setBuyHotSearch(true);
                hotSearch.setRanking(ranking);
                hotSearch.setPrice(price);
                if (hotSearchList.get(ranking - 1).isBuyHotSearch()) {
                    hotSearchList.remove(ranking - 1);
                }
            }
        }
        String resultOfBuyHotSearch = canBuyIt ? "购买成功" : "购买失败";
        System.out.println(resultOfBuyHotSearch);
    }
}
