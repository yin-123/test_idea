package com.asgard.service;

import com.asgard.mapper.UserMapper;
import com.asgard.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserMapper mapper;


    @Override
    public List<User> selectAllUser() {
        return mapper.selectAllUser();
    }

    @Override
    public List<User> selectUserByName(String username) {
        return mapper.selectUserByName(username);
    }

    @Override
    public void insertUser(User user) {
        mapper.insertUser(user);
    }

    @Override
    public void updateUser(User user) {
        mapper.updateUser(user);
    }

    @Override
    public User doUpdate(int id) {
        return mapper.doUpdate(id);
    }

    @Override
    public void deleteUser(int id) {
        mapper.deleteUser(id);
    }
}
