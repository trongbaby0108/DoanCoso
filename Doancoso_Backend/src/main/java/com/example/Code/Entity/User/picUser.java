package com.example.Code.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class picUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_bill_pt")
    private int id;
    private String img ;
    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false, referencedColumnName = "ID_user")
    private user user;
}
