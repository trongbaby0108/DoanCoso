package com.example.Code.ServiceImpl.PT;

import com.example.Code.Entity.PT.judge_pt;
import com.example.Code.Repository.PT.judge_ptRepository;
import com.example.Code.Service.PT.judge_ptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class judge_ptServiceImpl implements judge_ptService {
    @Autowired
    private judge_ptRepository judge_ptRepository;
    @Override
    public List<judge_pt> getByPT(int id) {
        List<judge_pt> res = new ArrayList<>();
        for(judge_pt judge_pt: judge_ptRepository.findAll()) {
            if(judge_pt.getPersonal_trainer().getId() == id)
                res.add(judge_pt);
        }
        return res;
    }

    @Override
    public void save(judge_pt judge_pt) {
        judge_ptRepository.save(judge_pt);
    }
}
