package com.gogo.admin.member.service;

import com.gogo.admin.member.dto.request.CreateMember;
import com.gogo.admin.member.dto.request.MemberSearchCriteria;
import com.gogo.admin.member.dto.response.MemberDetailRes;
import com.gogo.admin.member.dto.response.MemberListRes;
import com.gogo.admin.member.entity.MemberEntity;
import com.gogo.admin.member.repository.MemberCustomRepository;
import com.gogo.admin.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    private final MemberCustomRepository memberCustomRepository;

    
    //회원 생성
    public Long PostMember(CreateMember member) {
        return memberRepository.save(new MemberEntity(member)).getId();
    }

    public List<MemberListRes> GetMemberList(MemberSearchCriteria criteria, Pageable page) {
        return memberCustomRepository.findAllMemberByCriteria(criteria,page);

    }

    public MemberDetailRes GetMemberDetail(Long memberId) {
        return memberRepository.findById(memberId)
                .map(this::of)
                .orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다. id=" + memberId));
    }

    private MemberDetailRes of(MemberEntity member){
        return MemberDetailRes.builder()
                .id(member.getId())
                .name(member.getName())
                .email(member.getEmail())
                .phone(member.getPhone())
                .password(member.getPassword())
                .phone(member.getPhone())
                .address(member.getAddress())
                .nickname(member.getNickname())
                .gender(member.getGender())
                .birth(member.getBirth())
                .role(member.getRole())
                .build();
    }
}
