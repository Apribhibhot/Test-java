package com.apri.test.service.impl;

import com.apri.test.dao.UserDAO;
import com.apri.test.entity.User;
import com.apri.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> findByUsername(User param) {
        return userDAO.findByUsername(param);
    }

    @Override
    public User save(User param) {
        return userDAO.save(param);
    }

    @Override
    public User update(User param) {
        return userDAO.update(param);
    }

    @Override
    public int delete(User param) {
        return userDAO.delete(param);
    }

    @Override
    public User findById(int id) {
        return userDAO.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userDAO.findAll();
    }

    public List<User> findByUsernameAndPassword(User param) {
        return userDAO.findByUsernameAndPassword(param);
    }

    public User findByUsername(String username) {
        return userDAO.findByUsername(username);
    }
}