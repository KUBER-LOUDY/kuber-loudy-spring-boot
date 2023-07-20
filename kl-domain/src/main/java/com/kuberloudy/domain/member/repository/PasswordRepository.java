package com.kuberloudy.domain.member.repository;

import com.kuberloudy.domain.member.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password, Long> {
}
