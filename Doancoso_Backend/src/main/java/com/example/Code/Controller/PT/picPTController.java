package com.example.Code.Controller.PT;

import com.example.Code.Entity.PT.personal_trainer;
import com.example.Code.Entity.PT.pic_pt;
import com.example.Code.Model.Uploader;
import com.example.Code.Model.ptIMGModel;
import com.example.Code.Service.PT.personal_trainerService;
import com.example.Code.Service.PT.picPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/picPT")
public class picPTController {
    @Autowired
    private picPTService picPTService;

    @Autowired
    private personal_trainerService personal_trainerService;

    @PostMapping("/save")
    public String save(
            @RequestParam("id") int id,
            @RequestParam("pic")MultipartFile pic
    ){
        Uploader uploader = new Uploader();
        pic_pt pic_pt = new pic_pt();
        pic_pt.setPersonal_trainer(personal_trainerService.findById(id));
        pic_pt.setImg(uploader.uploadFile(pic));
        picPTService.save(pic_pt);
        return "Successful";
    }

    @RequestMapping("/getByPt")
    public List<ptIMGModel> getByPt(
            @RequestParam("id") int id
    ){
        List<ptIMGModel> res = new ArrayList<>();
        for (pic_pt pic_pt: picPTService.getByPT(id)) {
            ptIMGModel ptIMGModel = new ptIMGModel(pic_pt);
            res.add(ptIMGModel);
        }
        return res;
    }
}
