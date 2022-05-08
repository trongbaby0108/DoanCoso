package com.example.Code.Service.Gym;

import com.example.Code.Entity.Gym.picGym;

import java.util.List;

public interface picGymService {
    public List<picGym> getAll();
    public void save(picGym picGym);
    public List<picGym> getByGym(int id);
    public void delete(int id);
}
