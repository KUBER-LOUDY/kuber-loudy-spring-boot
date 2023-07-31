package com.kuberloudy.domain.iam.service;


import com.kuberloudy.domain.iam.entity.Iam;
import com.kuberloudy.domain.iam.repository.IamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class IamDomainService {

    private final IamRepository iamRepository;

    public List<Iam> getIamlist(Long memberId){
        return iamRepository.findAllByMember_MemberId(memberId);

    }

}
