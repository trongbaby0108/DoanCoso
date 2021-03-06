package com.example.Code.Controller.PT;

import com.example.Code.Entity.PT.judge_pt;
import com.example.Code.Entity.PT.personal_trainer;
import com.example.Code.Entity.User.user;
import com.example.Code.Model.PTResponseModel;
import com.example.Code.Model.userInfoResponse;
import com.example.Code.Service.PT.judge_ptService;
import com.example.Code.Service.PT.personal_trainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personal_trainerAdmin")
public class personal_trainerAdminController {
    @Autowired
    private personal_trainerService personal_trainerService;
    @Autowired
    private com.example.Code.Service.PT.judge_ptService judge_ptService;

    @RequestMapping("/getALlPT")
    public List<PTResponseModel> getALlPT(){
        List<PTResponseModel> res = new ArrayList<>();
        for (personal_trainer pt : personal_trainerService.getAll()) {
            if (pt.getAccount().getRole().getText() == "PERSONAL_TRAINER"){
                PTResponseModel ptResponseModel = new PTResponseModel(pt);
                ptResponseModel.setRate(getPTRate(ptResponseModel.getId()));
                res.add(ptResponseModel);
            }
        }
        return res ;
    }

    public float getPTRate(int id){
        float res = 0;
        int count = 0;
        for (com.example.Code.Entity.PT.judge_pt judge_pt:judge_ptService.getByPT(id)) {
            res += judge_pt.getVote();
            count ++;
        }
        return res/count;
    }


    @RequestMapping("/disablePT")
    public String disablePT(@RequestParam("idPT") int idPT){
        personal_trainer pt = personal_trainerService.findById(idPT);
        pt.getAccount().setEnable(false);
        personal_trainerService.save(pt);
        return "Successful";
    }

    @RequestMapping("/enablePT")
    public String enablePT(@RequestParam("idPT") int idPT){
        personal_trainer pt = personal_trainerService.findById(idPT);
        pt.getAccount().setEnable(true);
        personal_trainerService.save(pt);
        return "Successful";
    }
}
