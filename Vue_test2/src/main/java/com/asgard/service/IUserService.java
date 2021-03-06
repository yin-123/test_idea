package com.asgard.service;

import com.asgard.pojo.User;

import java.util.List;

public interface IUserService {
    List<User> selectAllUser();
    List<User> selectUserByName(String username);
    void insertUser(User user);
    void updateUser(User user);
    User doUpdate(int id);
    void deleteUser(int id);
}
