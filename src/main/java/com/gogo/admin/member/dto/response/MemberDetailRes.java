package com.gogo.admin.member.dto.response;

import com.gogo.admin.utill.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Builder
public class MemberDetailRes {

    private Long id;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String address;

    private String nickname;

    private String gender;

    private String birth;

    private Role role;
}
