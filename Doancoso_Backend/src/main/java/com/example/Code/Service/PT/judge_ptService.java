package com.example.Code.Service.PT;

import com.example.Code.Entity.PT.judge_pt;

import java.util.List;

public interface judge_ptService {
    public List<judge_pt> getByPT(int id);
    public void save(judge_pt judge_pt);
}
