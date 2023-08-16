package com.example.restapi.Entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class telephone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String code;
    private String number;
}
