package com.example.Code.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_user")
    private int id ;
    private String username ;
    private String password;
    private String name ;
    private String phone ;

//    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
//    private Set<picUser> picUsers;

}
