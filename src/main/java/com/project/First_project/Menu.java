package com.project.First_project;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Menu {
    private long id;
    private String itemName;
    private double price;
}
