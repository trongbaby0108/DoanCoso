package com.example.Code.Service.User;

import com.example.Code.Entity.User.picUser;

import java.util.List;

public interface picUserService {
    public void save(picUser picUser);
    public List<picUser> findByUser(String username);
}
