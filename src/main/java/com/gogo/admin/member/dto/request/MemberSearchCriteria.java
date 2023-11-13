package com.gogo.admin.member.dto.request;

import com.gogo.admin.utill.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class MemberSearchCriteria {

    private Long id;

    private String name;

    private String email;

    private String phone;

    private String address;

    private String nickName;

    private String gender;

    private String birth;

    private Role role;
}
