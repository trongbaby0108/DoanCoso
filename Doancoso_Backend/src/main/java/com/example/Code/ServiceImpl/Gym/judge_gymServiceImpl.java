package com.example.Code.ServiceImpl.Gym;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Code.Entity.Gym.judge_gym;
import com.example.Code.Repository.Gym.judge_gymRepository;
import com.example.Code.Service.Gym.judge_gymService;

@Service
public class judge_gymServiceImpl implements judge_gymService {

    @Autowired
    private judge_gymRepository judge_gymRepository;

    @Override
    public List<judge_gym> getAll() {
        return judge_gymRepository.findAll();
    }

    @Override
    public void save(judge_gym judge_gym) {
        judge_gymRepository.save(judge_gym);
    }

    @Override
    public List<judge_gym> getByGym(int id) {
        List<judge_gym> judge_gyms = getAll();
        List<judge_gym> result = new ArrayList<judge_gym>();
        for (judge_gym judge_gym: judge_gyms) {
            if(judge_gym.getGym().getId() == id)
                result.add(judge_gym);
        }
        return result;
    }

    @Override
    public void delete(int id) {
        judge_gymRepository.deleteById(id);
    }
}
