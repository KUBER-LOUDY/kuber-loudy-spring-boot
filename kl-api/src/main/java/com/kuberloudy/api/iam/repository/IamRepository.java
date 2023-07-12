package com.kuberloudy.api.iam.repository;

import com.kuberloudy.api.iam.entity.Iam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IamRepository extends JpaRepository<Iam,Long> {
}
