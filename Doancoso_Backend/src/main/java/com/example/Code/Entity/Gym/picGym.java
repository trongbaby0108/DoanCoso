package com.example.Code.Entity.Gym;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class picGym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_bill_pt")
    private int id;
    private String img ;

    @ManyToOne
    @JoinColumn(name = "gym_id",nullable = false, referencedColumnName = "ID_gym")
    private gym gym;
}
