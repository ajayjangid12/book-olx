package com.example.booksolx.controller;

import com.example.booksolx.model.LoginCheck;
import com.example.booksolx.model.Report;
import com.example.booksolx.model.User;
import com.example.booksolx.model.UserCheck;
import com.example.booksolx.service.ReportService;
import com.example.booksolx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.util.List;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private ReportService reportService;

    @PostMapping("/user/create")
    public User create(@RequestBody User user){
        User userTemp = userService.create(user);
        return userTemp;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/username/{userName}")
    public User getUserByUserName(@PathVariable String userName){
        return userService.findByUserName(userName);
    }

    @GetMapping("/user/email/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }

    @GetMapping("/user/delete/{userName}")
    public boolean deleteUser(@PathVariable String userName){
        return userService.deleteUser(userName);
    }

    @GetMapping("user/deleteAll")
    public String deleteAll(){
        userService.deleteAll();
        return "all users deleted";
    }

    @PostMapping("/user/update")
    public User update(@RequestBody User userTemp){
        User user = userService.update(userTemp);
        return user;
    }

    @PostMapping("/user/checkLogin")
    public User checkLogin(@RequestBody LoginCheck credentials){
        return userService.checkLogin(credentials);
    }

    @PostMapping("/user/dataValid")
    public UserCheck dataValid(@RequestBody User user){
        UserCheck userCheck = userService.userCheck(user);
        return userCheck;
    }

    @PostMapping("/user/updateDataValid")
    public UserCheck updateDataValid(@RequestBody User user){
        UserCheck userCheck = userService.updateUserCheck(user);
        return userCheck;
    }

    @PostMapping("/user/reportUser")
    public Report reportUser(@RequestBody Report report){
        return reportService.reportUser(report);
    }

    @GetMapping("/user/reports")
    public List<Report> getReports(){
        return reportService.getReports();
    }


}
