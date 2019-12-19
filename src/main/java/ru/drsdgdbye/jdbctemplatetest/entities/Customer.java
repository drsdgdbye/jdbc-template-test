package ru.drsdgdbye.jdbctemplatetest.entities;

import lombok.Data;

@Data
public class Customer {
    private Integer id;
    private String name;
    private String lastname;
    private String email;
}
