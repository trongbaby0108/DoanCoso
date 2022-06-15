package com.example.Code.ServiceImpl.Payment;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Code.Entity.Payment.bill_pt;
import com.example.Code.Repository.Payment.bill_ptRepository;
import com.example.Code.Service.Payment.bill_ptService;


@Service
public class bill_ptServiceImpl implements bill_ptService {
    @Autowired
    private bill_ptRepository bill_ptRepository;

    @Override
    public void save(bill_pt bill_pt) {
        bill_ptRepository.save(bill_pt);
    }

    @Override
    public List<bill_pt> getAll() {
        return bill_ptRepository.findAll();
    }

    @Override
    public bill_pt getByUser(int id) {
        bill_pt result = null;
        for (bill_pt bill_pt:bill_ptRepository.findAll()) {
            if(
                    bill_pt.getUser().getId() == id &&
                            bill_pt.getDayStart().isBefore(LocalDateTime.now())&&
                            bill_pt.getDayEnd().isAfter(LocalDateTime.now())
            ){
                result = bill_pt;
            }
        }
        return result;
    }
}
