package com.example.Code.Controller.Home;

import com.example.Code.Entity.Gym.combo;
import com.example.Code.Entity.Gym.gym;
import com.example.Code.Entity.Gym.judge_gym;
import com.example.Code.Entity.PT.judge_pt;
import com.example.Code.Entity.PT.personal_trainer;
import com.example.Code.Model.*;
import com.example.Code.Service.Gym.comboService;
import com.example.Code.Service.Gym.gymService;
import com.example.Code.Service.Gym.judge_gymService;
import com.example.Code.Service.PT.judge_ptService;
import com.example.Code.Service.PT.personal_trainerService;
import com.example.Code.Service.User.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private gymService _gymService;

    @Autowired
    private personal_trainerService personal_trainerService;

    @Autowired
    private comboService comboService;

    @Autowired
    private judge_gymService judge_gymService;

    @Autowired
    private userService userService ;

    @Autowired
    private judge_ptService judge_ptService;

    @RequestMapping("/getPT")
    public List<PTResponseModel> getPT(){
        List<PTResponseModel> ptModels = new ArrayList<>();
        for (personal_trainer pt :personal_trainerService.getAll()){
            if(pt.getAccount().isEnable()){
                PTResponseModel ptModel = new PTResponseModel(pt);
                ptModel.setRate(getPTRate(ptModel.getId()));
                ptModels.add(ptModel);
            }
        }
        return ptModels;
    }

    @GetMapping("/getGym")
    public List<gymModel> getGym(){
        List<gymModel> res = new ArrayList<>();
        _gymService.getAll().forEach(gym -> {
            gymModel gymModel = new gymModel(gym);
            gymModel.setRate(getGymRate(gym.getId()));
            res.add(gymModel);
        });
        return res;
    }

    public float getGymRate(int id){
        float res = 0;
        int count = 0;
        for (com.example.Code.Entity.Gym.judge_gym judge_gym:judge_gymService.getAll()) {
            res += judge_gym.getGym().getId() == id ? judge_gym.getVote() : 0;
            count += judge_gym.getGym().getId() == id ? 1 : 0;
        }
        return res/count;
    }

    @GetMapping("/getCombo")
    public List<combo> getCombo(){
        return comboService.getAll();
    }

    @GetMapping("/getByGym")
    public List<combo> getByGym(@RequestParam int id){
        return comboService.getByGym(id);
    }

    @RequestMapping("/getPTByGym")
    public List<PTResponseModel> getPTByGym(@RequestParam int id){
        List<PTResponseModel> ptModels = new ArrayList<>();
        for (personal_trainer pt :personal_trainerService.getPTByGym(id)){
            if(pt.getAccount().isEnable()){
                PTResponseModel ptModel = new PTResponseModel(pt);
                ptModel.setRate(getPTRate(pt.getId()));
                ptModels.add(ptModel);
            }
        }
        return ptModels;
    }

    public float getPTRate(int id){
        float res = 0;
        int count = 0;
        for (judge_pt judge_pt:judge_ptService.getByPT(id)) {
            res += judge_pt.getVote();
            count ++;
        }
        return res/count;
    }

    @GetMapping("/getJudgeByGym")
    public List<judge_gymModel> getJudgeByGym(@RequestParam int id){
        List<judge_gymModel> res = new ArrayList<>();
        for (judge_gym judge_gym: judge_gymService.getByGym(id)) {
            judge_gymModel judge_gymModel = new judge_gymModel(judge_gym);
            res.add(judge_gymModel);
        }
        return res;
    }

    @GetMapping("/addComment")
    public String addComment(
            @RequestParam String content,
            @RequestParam float vote ,
            @RequestParam int gymId,
            @RequestParam int userId
    ){
        judge_gym judge_gym = new judge_gym();
        judge_gym.setContent(content);
        judge_gym.setVote(vote);
        judge_gym.setGym(_gymService.findGymById(gymId));
        judge_gym.setUser(userService.findById(userId));
        judge_gymService.save(judge_gym);
        return "successful";
    }


    @GetMapping("/getJudgeByPT")
    public List<judge_PTModel> getJudgeByPT(@RequestParam int id){
        List<judge_PTModel> res = new ArrayList<>();
        for (judge_pt judge_pt: judge_ptService.getByPT(id)) {
            judge_PTModel judge_PTModel = new judge_PTModel(judge_pt);
            res.add(judge_PTModel);
        }
        return res;
    }

    @GetMapping("/addCommentPT")
    public String addCommentPT(
            @RequestParam String content,
            @RequestParam float vote ,
            @RequestParam int ptID,
            @RequestParam int userId
    ){
        judge_pt judge_pt = new judge_pt();
        judge_pt.setComment(content);
        judge_pt.setVote(vote);
        judge_pt.setPersonal_trainer(personal_trainerService.findById(ptID));
        judge_pt.setUser(userService.findById(userId));
        judge_ptService.save(judge_pt);
        return "successful";
    }
}
