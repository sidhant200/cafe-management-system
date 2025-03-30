package com.project.First_project;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "empTb")
public class EmpEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String email;
    private String phone;

}
