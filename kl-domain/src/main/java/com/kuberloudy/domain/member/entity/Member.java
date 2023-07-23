package com.kuberloudy.domain.member.entity;


import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 200)
    private String name;

    @OneToOne
    @JoinColumn(name = "member_id")
    private Password password;

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
