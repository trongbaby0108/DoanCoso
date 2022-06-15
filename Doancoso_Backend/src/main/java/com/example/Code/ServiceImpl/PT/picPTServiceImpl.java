package com.example.Code.ServiceImpl.PT;

import com.example.Code.Entity.PT.pic_pt;
import com.example.Code.Repository.Gym.picPTRepository;
import com.example.Code.Service.PT.picPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class picPTServiceImpl implements picPTService {

    @Autowired
    private picPTRepository picPTRepository;

    @Override
    public void save(pic_pt pic_pt) {
        picPTRepository.save(pic_pt);
    }

    @Override
    public List<pic_pt> getByPT(int pt) {
        List<pic_pt> res = new ArrayList<>();
        for (pic_pt pic_pt: picPTRepository.findAll()) {
            if(pic_pt.getPersonal_trainer().getId() == pt){
                res.add(pic_pt);
            }
        }
        return res;
    }
}
