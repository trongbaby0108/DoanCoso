package com.example.Code.Controller.Gym;

import com.example.Code.Entity.Gym.combo;
import com.example.Code.Service.Gym.comboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.*;
import java.util.List;

@RestController
@RequestMapping("/client/combo")
public class comboController {
    @Autowired
    private comboService comboService;
    @GetMapping("getByGym")
    public List<combo> getByGym(@RequestParam int id){
        return comboService.getByGym(id);
    }

    @PostMapping("addCombo")
    public String addCombo(@RequestBody combo combo){
        comboService.save(combo);
        return "Success";
    }
}
