package com.example.Code.ServiceImpl.User;

import com.example.Code.Entity.User.user;
import com.example.Code.Repository.User.userRepository;
import com.example.Code.Service.User.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userRepository userRepository;

    @Override
    public void save(user user) {
        userRepository.save(user);
    }

    @Override
    public user findByUserName(String username) {
        return userRepository.findByUsername(username);
    }


}
