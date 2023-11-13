package com.gogo.admin.member.controller;

import com.gogo.admin.member.dto.request.CreateMember;
import com.gogo.admin.member.dto.request.MemberSearchCriteria;
import com.gogo.admin.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signin")
    public Map<String,Object> PostMember(@Validated @RequestBody CreateMember member) {
        return Collections.singletonMap("result", memberService.PostMember(member));
    }

    @GetMapping("/list")
    public Map<String,Object> GetMember(@Validated @RequestBody MemberSearchCriteria criteria,
                                        @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable page) {
        return Collections.singletonMap("result", memberService.GetMemberList(criteria,page));
    }

    @GetMapping("/detail/{memberId}")
    public Map<String,Object> GetMemberDetail(@PathVariable Long memberId) {
        return Collections.singletonMap("result", memberService.GetMemberDetail(memberId));
    }


}
