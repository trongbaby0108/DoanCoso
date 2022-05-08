package com.example.Code.Entity.Gym;

import com.example.Code.Entity.User.user;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "judge_gym")
public class judge_gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_judge")
    private int id ;
    private String content ;
    private float vote ;
    @ManyToOne
    @JoinColumn(name = "gym_id",nullable = false, referencedColumnName = "ID_gym")
    private gym gym;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false, referencedColumnName = "ID_user")
    private user user;
}
