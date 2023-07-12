package com.kuberloudy.api.member.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 200)
    private String name;

    @Column(length = 200)
    private String email;

    @Enumerated
    @Column(nullable = false, length = 100)
    private Provider provider;

    @Builder
    public Member(String name, String email, Provider provider) {
        this.name = name;
        this.email = email;
        this.provider = provider;
    }
}
