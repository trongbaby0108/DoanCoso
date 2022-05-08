package com.example.Code.Service.Gym;


import com.example.Code.Entity.Gym.discount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface discountService {
    public List<discount> getAll();
    public void save(discount discount);
    public List<discount> getByGym(int id);
    public void delete(int id);
}
