package com.gogo.admin.member.dto.response;

import com.gogo.admin.utill.Role;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberListRes {
    private Long id;

    private String name;

    private String email;

    private String phone;

    private String gender;

    private Role role;

    @QueryProjection
    public MemberListRes(String name, String email, String phone, String gender, Role role, Long id) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.gender = gender;
        this.role = role;
        this.id = id;
    }
}
