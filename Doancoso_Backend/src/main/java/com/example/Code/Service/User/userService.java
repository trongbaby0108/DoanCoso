package com.example.Code.Service.User;


import com.example.Code.Entity.User.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userService {
    public void save(user user);

    public user findByUserName(String username);
}
