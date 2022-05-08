package com.example.Code.ServiceImpl.User;

import com.example.Code.Entity.Gym.picGym;
import com.example.Code.Entity.User.picUser;
import com.example.Code.Repository.User.picUserRepository;
import com.example.Code.Service.User.picUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class picUserServiceImpl implements picUserService {

    @Autowired
    private picUserRepository picUserRepository;

    public List<picUser> getAll(){
        return picUserRepository.findAll();
    }

    @Override
    public void save(picUser picUser) {
        picUserRepository.save(picUser);
    }

    @Override
    public List<picUser> findByUser(String username) {
        List<picUser> picUsers = getAll();
        List<picUser> result = new ArrayList<picUser>();
        for (picUser picUser: picUsers) {
            if(picUser.getUser().getUsername().equals(username))
                result.add(picUser);
        }
        return result;
    }
}
