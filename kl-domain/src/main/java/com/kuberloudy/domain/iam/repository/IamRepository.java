package com.kuberloudy.domain.iam.repository;

import com.kuberloudy.domain.iam.entity.Iam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IamRepository extends JpaRepository<Iam,Long> {
}