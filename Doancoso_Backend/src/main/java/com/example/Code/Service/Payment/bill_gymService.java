package com.example.Code.Service.Payment;


import java.util.List;

import com.example.Code.Entity.Payment.bill_gym;

public interface bill_gymService {
    public void save(bill_gym bill_gym);
    public List<bill_gym> getAll();
    public bill_gym getByUser(int id);
}
