package com.example.Code.Model;

import com.example.Code.Entity.PT.pic_pt;
import lombok.Data;

@Data
public class ptIMGModel {
    private PTResponseModel ptResponseModel;
    private String img;

    public ptIMGModel(pic_pt pic_pt) {
        this.ptResponseModel = new PTResponseModel(pic_pt.getPersonal_trainer());
        this.img = pic_pt.getImg();
    }
}
