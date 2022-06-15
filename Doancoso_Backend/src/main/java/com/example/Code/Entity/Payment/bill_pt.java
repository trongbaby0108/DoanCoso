package com.example.Code.Entity.Payment;
import com.example.Code.Entity.PT.personal_trainer;
import com.example.Code.Entity.User.user;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private LocalDateTime dayStart ;
    private LocalDateTime dayEnd ;
    @ManyToOne
    @JoinColumn(name = "PT_id",nullable = false, referencedColumnName = "ID_pt")
    private personal_trainer personal_trainer;

    @ManyToOne
    @JoinColumn(name = "User_id",nullable = false, referencedColumnName = "ID_user")
    private user user;
}
