package com.example.Code.Entity.PT;

import javax.persistence.*;

@Entity
@Table(name = "personal_trainer")
public class personal_trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_pt")
    private int id ;

    @Column(name= "Name")
    private String name ;

    @Column(name= "Phone")
    private String Phone ;

    @Column(name= "Password")
    private String Password ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
