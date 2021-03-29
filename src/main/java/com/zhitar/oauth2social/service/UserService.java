package com.zhitar.oauth2social.service;

import com.zhitar.oauth2social.mapper.UserMapper;
import com.zhitar.oauth2social.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public User findByEmail(String email) {
        return userMapper.findByEmail(email);
    }

    public User findById(Long id) {
        return userMapper.findBYId(id);
    }

    public User insert(User user) {
        int insert = userMapper.insert(user);
        if (insert == 1) {
            return userMapper.findByEmail(user.getEmail());
        } else {
            throw new UsernameNotFoundException("user not found");
        }
    }

    public User update(User user) {
        int update = userMapper.update(user);
        if (update == 1) {
            return userMapper.findByEmail(user.getEmail());
        } else {
            throw new UsernameNotFoundException("user not found");
        }
    }
}
