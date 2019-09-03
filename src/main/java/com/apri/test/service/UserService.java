package com.apri.test.service;

import com.apri.test.entity.User;
import java.util.List;

public interface UserService extends BaseService<User> {

    List<User> findByUsername(User param);

    List<User> findByUsernameAndPassword(User param);

    User findByUsername(String username);
}
