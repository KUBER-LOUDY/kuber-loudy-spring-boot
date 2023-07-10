package com.kuberloudy.spring.domain.iam.entity;

import com.kuberloudy.spring.domain.member.entity.Member;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Table(name = "iam_user")
public class Iam {

    @Id
    private String iamId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

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
