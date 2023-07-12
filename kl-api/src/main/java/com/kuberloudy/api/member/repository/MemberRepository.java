package com.kuberloudy.api.member.repository;

import com.kuberloudy.api.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
}
