package com.example.Code.Repository.User;


import com.example.Code.Entity.User.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userRepository extends JpaRepository<user,Integer> {
    public user findByUsername(String username);
}
