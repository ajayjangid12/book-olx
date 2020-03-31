package com.example.booksolx.service;

import com.example.booksolx.model.LoginCheck;
import com.example.booksolx.model.User;
import com.example.booksolx.model.UserCheck;
import com.example.booksolx.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User create(User user){
        user.setUserImgUrl("https://encrypted-tbn0.gstatic.com/images?q=tbn%3AANd9GcSVgzXNuTzFxUvXCVUdSHwPKLkSOLjauUHY6h2Bzzq8_EEU3r7r");
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User update(User userTemp) {
        User user = userRepository.findByUserName(userTemp.getUserName());
        user.setEmail(userTemp.getEmail());
        user.setMobileNumber(userTemp.getMobileNumber());
        user.setPassword(userTemp.getPassword());
        user.setLocationState(userTemp.getLocationState());
        user.setLocationCountry(userTemp.getLocationCountry());
        user.setFirstName(userTemp.getFirstName());
        user.setLastName(userTemp.getLastName());
        user.setUserImgUrl(userTemp.getUserImgUrl());
        return userRepository.save(user);
    }

    public boolean deleteUser(String userName){
        User tempUser = userRepository.findByUserName(userName);
        userRepository.delete(tempUser);
        return true;
    }

    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    public void deleteAll() {
        userRepository.deleteAll();
    }

    public User checkLogin(LoginCheck credentials) {
        User user = userRepository.findByEmailAndPassword(credentials.getEmail(),credentials.getPassword());
        if(user==null)
            return null;
        else{
            return user;
        }
    }

    public UserCheck userCheck(User user) {
        UserCheck userCheck = new UserCheck();
        User userTemp = userRepository.findByUserName(user.getUserName());
        if(userTemp==null)
            userCheck.setUserNameValid(true);
        else userCheck.setUserNameValid(false);
        userTemp = userRepository.findByEmail(user.getEmail());
        if(userTemp==null)
            userCheck.setEmailValid(true);
        else userCheck.setEmailValid(false);
        userTemp = userRepository.findByMobileNumber(user.getMobileNumber());
        if(userTemp==null)
            userCheck.setMobileNumberValid(true);
        else userCheck.setMobileNumberValid(false);
        return userCheck;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserCheck updateUserCheck(User user) {
        UserCheck userCheck = new UserCheck();
        userCheck.setUserNameValid(true);
        User userTemp = userRepository.findByEmail(user.getEmail());
        if(userTemp==null)
            userCheck.setEmailValid(true);
        else if(userTemp.getUserName().equals(user.getUserName()))
            userCheck.setEmailValid(true);
        else userCheck.setEmailValid(false);
        userTemp = userRepository.findByMobileNumber(user.getMobileNumber());
        if(userTemp==null)
            userCheck.setMobileNumberValid(true);
        else if(userTemp.getUserName().equals(user.getUserName()))
            userCheck.setMobileNumberValid(true);
        else userCheck.setMobileNumberValid(false);
       return userCheck;
    }
}
