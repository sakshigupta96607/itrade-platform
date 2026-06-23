package com.bank.itrade.auth.entity;



import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "profiles")
public class Profile {

    @Id
    private String code;

    private String description;

    @Column(name = "operator_id")
    private String operatorId;
}