package com.kuberloudy.api.member.repository;

import com.kuberloudy.api.member.entity.Member;
import com.kuberloudy.api.member.entity.Password;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordRepository extends JpaRepository<Password, Member> {
}
