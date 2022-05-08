package com.example.Code.ServiceImpl.Gym;

import com.example.Code.Entity.Gym.discount;
import com.example.Code.Repository.Gym.discountRepository;
import com.example.Code.Service.Gym.discountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;

@Service
public class discountServiceImpl implements discountService {

    @Autowired
    private discountRepository discountRepository;

    @Override
    public List<discount> getAll() {
        return discountRepository.findAll();
    }

    @Override
    public void save(discount discount) {
        discountRepository.save(discount);
    }

    @Override
    public List<discount> getByGym(int id) {
        List<discount> discounts = getAll();
        List<discount> result = new ArrayList<discount>();
        for (discount discount: discounts) {
            if(discount.getGym().getId() == id)
                result.add(discount);
        }
        return result;
    }

    @Override
    public void delete(int id) {
        discountRepository.deleteById(id);
    }
}
