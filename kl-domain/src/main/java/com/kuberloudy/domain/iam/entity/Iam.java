package com.kuberloudy.domain.iam.entity;

import com.kuberloudy.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.IdGeneratorType;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "iam_user")
public class Iam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iamId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false)
    private String iamAccessKey;

    @Column(nullable = false, length = 400)
    private String iamSecretKey;

    @Column(nullable = false, length = 400)
    @CreatedDate
    private LocalDateTime permissionDate;

    @Column(nullable = false)
    private LocalDateTime lastAccessDate;

}
