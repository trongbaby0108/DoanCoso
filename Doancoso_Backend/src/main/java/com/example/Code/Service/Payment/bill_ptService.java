package com.example.Code.Service.Payment;


import java.util.List;

import com.example.Code.Entity.Payment.bill_pt;

public interface bill_ptService {
    public void save(bill_pt bill_pt);
    public List<bill_pt> getAll();
    public bill_pt getByUser(int id);
}
