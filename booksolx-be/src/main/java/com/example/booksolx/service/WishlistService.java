package com.example.booksolx.service;

import com.example.booksolx.model.Wishlist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.booksolx.repository.WishlistRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishlistService {

    @Autowired
    private WishlistRepository wishlistRepsitory;


    public boolean addToWishlist(String userName, String postId) {
        Wishlist wishlist = wishlistRepsitory.findByUserName(userName);
        if(wishlist==null) {
            wishlist = new Wishlist();
            wishlist.setUserName(userName);
            wishlist.setPostIds(new ArrayList<String>());
        }
        if(!wishlist.getPostIds().contains(postId)){
            wishlist.getPostIds().add(postId);
        }
        wishlistRepsitory.save(wishlist);
        return true;
    }

    public List<String> getWishlist(String userName) {
        Wishlist wishlist = wishlistRepsitory.findByUserName(userName);
        if(wishlist==null){
            wishlist = new Wishlist();
            wishlist.setUserName(userName);
            wishlist.setPostIds(new ArrayList<String>());
        }
        return wishlist.getPostIds();
    }

    public boolean inMyWishlist(String userName, String postId) {
        Wishlist wishlist = wishlistRepsitory.findByUserName(userName);
        if(wishlist==null){
            wishlist = new Wishlist();
            wishlist.setUserName(userName);
            wishlist.setPostIds(new ArrayList<String>());
        }
        if(wishlist.getPostIds().contains(postId))
            return true;
        else
            return false;

    }

    public Boolean removeFromWishlist(String userName, String postId) {
        Wishlist wishlist = wishlistRepsitory.findByUserName(userName);
        if(wishlist==null){
            wishlist = new Wishlist();
            wishlist.setUserName(userName);
            wishlist.setPostIds(new ArrayList<String>());
        }
        if(wishlist.getPostIds().contains(postId)){
            wishlist.getPostIds().remove(postId);
        }
        wishlistRepsitory.save(wishlist);
        return true;
    }
}
