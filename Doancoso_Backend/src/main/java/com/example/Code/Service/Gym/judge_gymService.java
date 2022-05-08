package com.example.Code.Service.Gym;



import com.example.Code.Entity.Gym.judge_gym;

import java.util.List;

public interface judge_gymService {
    public List<judge_gym> getAll();
    public void save(judge_gym judge_gym);
    public List<judge_gym> getByGym(int id);
    public void delete(int id);
}
