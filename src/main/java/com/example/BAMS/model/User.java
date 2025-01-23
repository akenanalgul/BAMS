package com.example.BAMS.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity     // It indicates that this class represents a database table.
@Table(name = "users")  // It specifies which table in the database this class represents

public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)   // it indicates/refers that column of the database
    private String name;

    @Column(name = "email",unique = true,nullable = false)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;

    @Column(name = "created_at",nullable = false)
    private LocalDateTime createdAt;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }


    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }


    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}


    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public void setCreatedAt(LocalDateTime createdAt){
        this.createdAt=createdAt;
    }
}

