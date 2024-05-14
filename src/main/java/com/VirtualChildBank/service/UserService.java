package com.VirtualChildBank.service;

import com.VirtualChildBank.dao.UserDao;
import com.VirtualChildBank.model.User;

import java.util.List;

public class UserService {
    private UserDao userDao;
    private static User currentUser; // 静态变量存储当前用户


    public UserService() {
        this.userDao = new UserDao(); // 确保 UserDao 被正确初始化
    }

    // 验证用户登录
    public boolean authenticate(String username, String password) {
        List<User> users = userDao.getUsersFromJson();
        if (users == null) {
            return false;
        }
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user; // 登录成功时设置当前用户
                return true;
            }
        }
        return false;
    }


    // 更新用户信息并重新计算总余额
    public void updateUserAndRecalculateBalance(User user) {
        user.calculateTotalBalance(); // 重新计算总余额
        userDao.saveUser(user); // 保存更新后的用户信息
    }

    // 用户注册方法
    public void registerUser(String username, String password) {
        User user = new User(username, password);
        userDao.addUser(user);
    }

    // 更新用户信息
    public void updateUser(User user) {
        userDao.saveUser(user); // 使用 UserDao 的 saveUser 方法更新用户数据
    }

    public User getCurrentUser() {
        return currentUser;
    }

    // 设置当前用户
    public void setCurrentUser(User user) {
        currentUser = user;
    }
}
