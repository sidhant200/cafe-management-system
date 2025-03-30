package com.project.First_project;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "menutb")
public class MenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "item_name")
    private String itemName;
    private double price;
}
