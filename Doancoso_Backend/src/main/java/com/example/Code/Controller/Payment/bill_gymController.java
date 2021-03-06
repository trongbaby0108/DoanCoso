package com.example.Code.Controller.Payment;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Code.Entity.Gym.combo;
import com.example.Code.Entity.Gym.gym;
import com.example.Code.Entity.Payment.bill_gym;
import com.example.Code.Entity.User.user;
import com.example.Code.Model.billGymResponse;
import com.example.Code.Service.Gym.comboService;
import com.example.Code.Service.Gym.gymService;
import com.example.Code.Service.Payment.bill_gymService;
import com.example.Code.Service.User.userService;

@RestController
@RequestMapping("/bill_gym")
public class bill_gymController {
    @Autowired
    private bill_gymService bill_gymService;

    @Autowired
    private userService userService;

    @Autowired
    private gymService gymService;

    @Autowired
    private comboService comboService ;

    @RequestMapping("checkout")
    public Boolean checkout(
            @RequestParam("idUser") int idUser,
            @RequestParam("idGym") int idGym,
            @RequestParam("idCombo") int idCombo){
        user user = userService.findById(idUser);
        gym gym = gymService.findGymById(idGym);
        combo combo = comboService.findByid(idCombo);
        if(bill_gymService.getByUser(idUser) != null){
            System.out.println(bill_gymService.getByUser(idUser).toString());
            return false;
        }
        bill_gym bill= new bill_gym();
        bill.setUser(user);
        bill.setGym(gym);
        bill.setCombo(combo);
        bill.setDayStart(LocalDateTime.now());
        bill.setDayEnd(LocalDateTime.now().plusMonths(1));
        bill_gymService.save(bill);
        return true;
    }

    @RequestMapping("checkGymExit")
    public billGymResponse checkGymExit(@RequestParam("idUser") int idUser) {
        billGymResponse billGymResponse = new billGymResponse();
        bill_gym bill = bill_gymService.getByUser(idUser);
        if (bill != null) {
            billGymResponse.setId(bill.getId());
            billGymResponse.setDayStart(bill.getDayStart());
            billGymResponse.setDayEnd(bill.getDayEnd());
            billGymResponse.setGym(bill.getGym());
            billGymResponse.setCombo(bill.getCombo());
            return billGymResponse;
        }
        return billGymResponse;
    }
}
