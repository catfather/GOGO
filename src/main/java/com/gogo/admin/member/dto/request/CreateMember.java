package com.gogo.admin.member.dto.request;

import com.gogo.admin.utill.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CreateMember {

    @NotNull
    private String email;

    @NotNull
    private String password;

    @NotNull
    private String nickname;

    @NotNull
    private String gender;

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    private String address;

    @NotNull
    private String birth;

    @NotNull
    private Role role;

}
