package com.example.booksolx.repository;

import com.example.booksolx.model.Wishlist;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistRepository extends MongoRepository<Wishlist,String> {


    Wishlist findByUserName(String userName);
}
