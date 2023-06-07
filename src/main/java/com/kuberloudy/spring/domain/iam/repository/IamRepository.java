package com.kuberloudy.spring.domain.iam.repository;

import com.kuberloudy.spring.domain.iam.entity.Iam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IamRepository extends JpaRepository<Iam,Long> {
}
