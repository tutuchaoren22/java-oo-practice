package com.twu.entities;

public class User {
    private String name;
    private int voteCount;

    public User(String name) {
        this.name = name;
        this.voteCount = 10;
    }

    public String getName() {
        return name;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
