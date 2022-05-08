package com.example.Code.Controller.Gym;

import com.example.Code.Entity.Gym.judge_gym;
import com.example.Code.Service.Gym.judge_gymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("client/judge_gym")
public class judge_gymController {
    @Autowired
    private judge_gymService judge_gymService;

    @GetMapping("/getByGym")
    public List<judge_gym> getByGym(int id){
        return judge_gymService.getByGym(id);
    }
}
