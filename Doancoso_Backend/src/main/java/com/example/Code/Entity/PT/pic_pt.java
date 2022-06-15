package com.example.Code.Entity.PT;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class pic_pt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID_pic_pt")
    private int id;
    private String img ;
    @ManyToOne
    @JoinColumn(name = "ptID",referencedColumnName = "ID_pt")
    private personal_trainer personal_trainer;
}
