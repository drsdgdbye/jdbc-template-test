package ru.drsdgdbye.jdbctemplatetest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    private Integer id;
    private String name;
    private String lastname;
    private String email;
}
