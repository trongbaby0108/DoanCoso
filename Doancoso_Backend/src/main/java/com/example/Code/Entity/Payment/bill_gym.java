package com.example.Code.Entity.Payment;
import com.example.Code.Entity.Gym.combo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bill_gym")
public class bill_gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_bill")
    private int id ;
    private Date day ;
    private int money ;
}
