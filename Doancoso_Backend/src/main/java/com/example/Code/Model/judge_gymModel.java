package com.example.Code.Model;

import com.example.Code.Entity.Gym.judge_gym;
import lombok.Data;

@Data
public class judge_gymModel {
    private int id ;
    private String content ;
    private float vote ;
    private String name ;
    private String avatar;

    public judge_gymModel(judge_gym judge_gym) {
        this.id = judge_gym.getId();
        this.content = judge_gym.getContent();
        this.vote = judge_gym.getVote();
        this.avatar = judge_gym.getUser().getAvatar();
        this.name= judge_gym.getUser().getName();
    }
}
