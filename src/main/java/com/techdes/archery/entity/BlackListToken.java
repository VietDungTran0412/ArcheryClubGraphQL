package com.techdes.archery.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "blacklist")
@Table(name = "blacklist")
public class BlackListToken {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "jwt_token")
    private String jwtToken;
    @Column(name = "email")
    private String email;
}
