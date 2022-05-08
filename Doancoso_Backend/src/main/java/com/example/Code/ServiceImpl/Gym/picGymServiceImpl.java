package com.example.Code.ServiceImpl.Gym;

import com.example.Code.Entity.Gym.judge_gym;
import com.example.Code.Entity.Gym.picGym;
import com.example.Code.Repository.Gym.picGymRepository;
import com.example.Code.Service.Gym.picGymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class picGymServiceImpl implements picGymService {

    @Autowired
    private picGymRepository picGymRepository;

    @Override
    public List<picGym> getAll() {
        return picGymRepository.findAll();
    }

    @Override
    public void save(picGym picGym) {
        picGymRepository.save(picGym);
    }

    @Override
    public List<picGym> getByGym(int id) {
        List<picGym> picGyms = getAll();
        List<picGym> result = new ArrayList<picGym>();
        for (picGym picGym: picGyms) {
            if(picGym.getGym().getId() == id)
                result.add(picGym);
        }
        return result;
    }

    @Override
    public void delete(int id) {

    }
}
