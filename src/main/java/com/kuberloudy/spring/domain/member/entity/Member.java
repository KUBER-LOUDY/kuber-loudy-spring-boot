package com.kuberloudy.spring.domain.member.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;

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
    @Nullable
    private String password;

    @Enumerated
    @Column(nullable = false, length = 100)
    private Provider provider;

    @Builder
    public Member(String name, @Nullable String password, Provider provider) {
        this.name = name;
        this.password = password;
        this.provider = provider;
    }
}
