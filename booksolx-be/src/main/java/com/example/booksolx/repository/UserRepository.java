package com.example.booksolx.repository;

import com.example.booksolx.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    public User findByUserName(String userName);

    User findByEmail(String email);

    User findByMobileNumber(String mobileNumber);

    User findByEmailAndPassword(String email,String password);
}
