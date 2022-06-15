package com.example.Code.Service.PT;

import com.example.Code.Entity.PT.pic_pt;

import java.util.List;

public interface picPTService {
    public void save(pic_pt pic_pt);
    public List<pic_pt> getByPT(int pt);
}
