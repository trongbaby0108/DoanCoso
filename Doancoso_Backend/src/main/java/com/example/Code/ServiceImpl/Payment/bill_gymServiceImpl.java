package com.example.Code.ServiceImpl.Payment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Code.Entity.Payment.bill_gym;
import com.example.Code.Repository.Payment.bill_gymRepository;
import com.example.Code.Service.Payment.bill_gymService;

@Service
public class bill_gymServiceImpl implements bill_gymService {

    @Autowired
    private bill_gymRepository bill_gymRepository;

    @Override
    public void save(bill_gym bill_gym) {
        bill_gymRepository.save(bill_gym);
    }

    @Override
    public List<bill_gym> getAll() {
        return bill_gymRepository.findAll();
    }

    @Override
    public bill_gym getByUser(int id) {
        bill_gym result = null;
        for (bill_gym bill_gym:bill_gymRepository.findAll()) {
           if(
                   bill_gym.getUser().getId() == id &&
                   bill_gym.getDayStart().isBefore(LocalDateTime.now())&&
                   bill_gym.getDayEnd().isAfter(LocalDateTime.now())
           ){
               result = bill_gym;
           }
        }
        return result;
    }
}
