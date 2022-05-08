package com.example.Code.Entity.Gym;

import com.example.Code.Entity.User.picUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "gym")
public class gym {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_gym")
    private int id ;
    private String username ;
    private String password ;
    private String name ;
    private String address ;
    private String phone ;
    private String email ;
    private String avatar;
//    @OneToMany(mappedBy = "gym",cascade = CascadeType.ALL)
//    private Set<picGym> picGyms;
//
//    @OneToMany(mappedBy = "gym",cascade = CascadeType.ALL)
//    private Set<discount> discounts;
//
//    @OneToMany(mappedBy = "gym",cascade = CascadeType.ALL)
//    private Set<combo> combos;
//
//    @OneToMany(mappedBy = "gym",cascade = CascadeType.ALL)
//    private Set<judge_gym> judge_gyms;

}
