package com.example.Code.Entity.Gym;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class combo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_combo")
    private int id ;
    private String name ;
    private int price ;
    private boolean enable = true;
    @ManyToOne
    @JoinColumn(name = "gym_id",nullable = false, referencedColumnName = "ID_gym")
    private gym gym;
}
