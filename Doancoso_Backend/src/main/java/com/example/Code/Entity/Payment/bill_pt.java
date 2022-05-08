package com.example.Code.Entity.Payment;
import com.example.Code.Entity.PT.personal_trainer_fee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bill_pt")
public class bill_pt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_bill_pt")
    private int id ;
    private Date day ;
    private int money ;
}
