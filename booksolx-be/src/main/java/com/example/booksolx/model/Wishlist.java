package com.example.booksolx.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class Wishlist {
    @Id
    String id;

    private String userName;
    private List<String> postIds;

    public Wishlist(String userName, List<String> postIds) {
        this.userName = userName;
        this.postIds = postIds;
    }

    public Wishlist() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<String> getPostIds() {
        return postIds;
    }

    public void setPostIds(List<String> postIds) {
        this.postIds = postIds;
    }
}
