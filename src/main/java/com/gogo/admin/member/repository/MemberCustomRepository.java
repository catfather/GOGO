package com.gogo.admin.member.repository;

import com.gogo.admin.member.dto.request.MemberSearchCriteria;
import com.gogo.admin.member.dto.response.MemberListRes;
import com.gogo.admin.member.entity.MemberEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberCustomRepository {
    List<MemberListRes> findAllMemberByCriteria(MemberSearchCriteria criteria, Pageable page);
}
