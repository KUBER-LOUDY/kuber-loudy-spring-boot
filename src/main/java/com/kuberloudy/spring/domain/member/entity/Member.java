package com.kuberloudy.spring.domain.member.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "member")
public class Member {

    @Id
    private String memberId;

    @Column(length = 200)
    private String memberName;

    @Column(nullable = false, length = 100)
    private String provider;
}
