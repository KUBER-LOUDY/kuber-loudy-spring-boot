package com.kuberloudy.spring.domain.member.repository;

import com.kuberloudy.spring.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
