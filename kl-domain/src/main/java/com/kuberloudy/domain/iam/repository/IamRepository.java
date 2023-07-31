package com.kuberloudy.domain.iam.repository;

import com.kuberloudy.domain.iam.entity.Iam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IamRepository extends JpaRepository<Iam,Long> {
    Iam findByIamId(Long IamId);

    List<Iam> findAllByMember_MemberId(Long memberId);
}
