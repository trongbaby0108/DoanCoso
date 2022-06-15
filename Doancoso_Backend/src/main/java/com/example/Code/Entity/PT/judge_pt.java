package com.example.Code.Entity.PT;

import com.example.Code.Entity.User.user;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "judge_pt")
public class judge_pt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_judge")
    private int id;
    private String comment;
    private float vote;

    @ManyToOne
    @JoinColumn(name = "ptID",referencedColumnName = "ID_pt")
    private personal_trainer personal_trainer;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false, referencedColumnName = "ID_user")
    private com.example.Code.Entity.User.user user;
}
