package com.example.Code.Service.Gym;


import com.example.Code.Entity.Gym.combo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface comboService{
    public List<combo> getAll();
    public void save(combo combo);
    public List<combo> getByGym(int id);
    public void delete(int id);
}
